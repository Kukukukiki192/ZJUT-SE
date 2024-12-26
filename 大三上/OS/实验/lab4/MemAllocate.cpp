// MemAllocate.cpp: implementation of the CMemAllocate class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "Memory.h"
#include "MemAllocate.h"

#include "..\OSgraphics\Rectangle.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CMemAllocate::CMemAllocate()
{	
	//���ó�ʼ״̬
	m_MemList = 0;
	InitMemoryBlock();
	InitJobs();
}

CMemAllocate::~CMemAllocate()
{
	for (MemoryBlock * p = m_MemList; p!=0; p = m_MemList)
	{
		m_MemList = p->nextPointer;
		delete p;
	}
}
void CMemAllocate::DrawMemory(CDC*pDC)//ͨ�����ڴ�������ɫ��ʾ�ڴ�ķ������
{
	CPoint ptMemLeftTop = CPoint(100,50);
	CRectangle myRect(RGB(255,111,0),4,0,RGB(100,100,100),0,1,ptMemLeftTop,ptMemLeftTop);
	for (MemoryBlock * p = m_MemList; p!=0; p = p->nextPointer)
	{
		CPoint tmpLeftTop;
		tmpLeftTop.x = ptMemLeftTop.x ;
		tmpLeftTop.y = ptMemLeftTop.y + p ->StartAddr;
		CPoint tmpRightBottom;
		tmpRightBottom.x = ptMemLeftTop.x + 200;
		tmpRightBottom.y = tmpLeftTop.y + p->BlockLength;
		myRect.SetRectPeak(tmpLeftTop,tmpRightBottom);
		if (p->JobIndex  == 0 ) //����ڴ��գ� ���ǳɫ
			myRect.SetColorFill(RGB(200,200,200));
		else
			myRect.SetColorFill(RGB(100,100,100));
		
		myRect.Draw(pDC);
	}
}

void CMemAllocate::InitMemoryBlock()//��ʼ���ڴ�飬��СΪ1KB
{
	for (MemoryBlock * p = m_MemList; p!=0; p = m_MemList)
	{
		m_MemList = p->nextPointer;
		delete p;
	}	
	MemoryBlock * tmpMemBlock = new MemoryBlock;
	tmpMemBlock->BlockLength = 1024;/*ǧ�ֽ�KB*/
	tmpMemBlock->JobIndex = 0;
	tmpMemBlock->StartAddr = 0;
	tmpMemBlock->nextPointer = 0;
	tmpMemBlock->prePointer = 0;
	
	m_MemList = tmpMemBlock;
}
void CMemAllocate::AddAJobInEnd(char * JobName,int JobIndex,int JobLength,int* JobPageTable)//��ӽ���
{
	JCBInfo * tmpJob = new JCBInfo;
	tmpJob ->JobName = JobName;
	tmpJob ->JobIndex =JobIndex;
	tmpJob ->JobLength = JobLength;
	tmpJob ->JobPageTable = JobPageTable;

	tmpJob ->nextPointer = 0;
	tmpJob ->prePointer = m_JobsEnd;

	m_JobsEnd = tmpJob;
	if (m_JobsEnd ->prePointer != 0)
		m_JobsEnd ->prePointer ->nextPointer = tmpJob;
	else
		m_JobsHead = tmpJob;
}

void CMemAllocate::InitJobs()//��ʼ�������б�����Joblength��ָ����ҵ������ڴ��С����180��ʾ180�ֽ�
{
	m_JobsHead = m_JobsEnd = 0;
	AddAJobInEnd("Job1",1,180,NULL);
	AddAJobInEnd("Job2",2,360,NULL);
	AddAJobInEnd("Job3",3,180,NULL);
	AddAJobInEnd("Job4",4,60,NULL);
	AddAJobInEnd("Job5",5,020,NULL);
}

void CMemAllocate::AllocateMem_FirstAdapt(CMemAllocate::JCBInfo& job)//ʵ�����״������㷨
{
	for (MemoryBlock * p = m_MemList; p != 0; p=p->nextPointer)
	{
		if (job.JobLength < p->BlockLength && p->JobIndex == 0)			//�����ҵ��Ҫ�ռ�С���ڴ��ռ䣬����
		{
			MemoryBlock * tmpMemBlock = new MemoryBlock;
			tmpMemBlock ->BlockLength = job.JobLength;
			tmpMemBlock ->JobIndex = job.JobIndex;
			tmpMemBlock ->StartAddr = p->StartAddr;
			tmpMemBlock ->nextPointer = p;
			tmpMemBlock ->prePointer = p ->prePointer;
			
			p->StartAddr = p->StartAddr + job.JobLength;
			p->BlockLength = p->BlockLength -job.JobLength;
			if (p->prePointer == 0 )
			{
				m_MemList = tmpMemBlock;
			}
			else
			{
				p->prePointer->nextPointer = tmpMemBlock;
			}
			p ->prePointer = tmpMemBlock;
		}
		else
		{
			continue;
		}
	}
}
//��������㷨 
void CMemAllocate::AllocateMem_BestAdapt(CMemAllocate::JCBInfo& job) {
	long MinBlockLength = 1024;
	MemoryBlock * q;
	for (MemoryBlock * p = m_MemList; p != 0; p= p->nextPointer)
	{
		if (job.JobLength <= p->BlockLength && p->JobIndex == 0) //�����ҵ��Ҫ�ռ�С���ڴ��ռ䣬����
		{
			if(p ->BlockLength <= MinBlockLength)
			{
				MinBlockLength = p ->BlockLength; //�ҵ�������ҵ����С���п�
				q = p;
			}
		}
	}
	if(q != 0)
	{
		MemoryBlock * tmpMemBlock = new MemoryBlock;
		tmpMemBlock ->BlockLength = job.JobLength;
		tmpMemBlock ->JobIndex = job.JobIndex;
		tmpMemBlock ->StartAddr = q->StartAddr;
		tmpMemBlock ->nextPointer = q;
		tmpMemBlock ->prePointer = q ->prePointer;
		q->StartAddr = q->StartAddr + job.JobLength;
		q->BlockLength = q->BlockLength -job.JobLength;
		if (q->prePointer == 0 ){
			m_MemList = tmpMemBlock;
		}
		else
		{
			q ->prePointer->nextPointer = tmpMemBlock;
		}
		q ->prePointer = tmpMemBlock;
	}
}
//�ڽ�(�´�)�����㷨
void CMemAllocate::AllocateMem_NextAdapt(CMemAllocate::JCBInfo& job)
{
	for ( MemoryBlock * p = Flag.latestMemBlock; p != 0; p=p->nextPointer) //�����һ�η����λ�ÿ�ʼ�����״������㷨
	{
		if (job.JobLength <= p->BlockLength && p->JobIndex == 0) //�����ҵ��Ҫ�ռ�С���ڴ��ռ䣬����
		{
			MemoryBlock * tmpMemBlock = new MemoryBlock;
			tmpMemBlock ->BlockLength = job.JobLength;
			tmpMemBlock ->JobIndex = job.JobIndex;
			tmpMemBlock ->StartAddr = p->StartAddr;
			tmpMemBlock ->nextPointer = p;
			tmpMemBlock ->prePointer = p ->prePointer;
			p->StartAddr = p->StartAddr + job.JobLength;
			p->BlockLength = p->BlockLength -job.JobLength;
			if (p->prePointer == 0 )
			{
				m_MemList = tmpMemBlock;
			}
			else
			{
				p->prePointer->nextPointer = tmpMemBlock;
			}
			p ->prePointer = tmpMemBlock;
			Flag.latestMemBlock = tmpMemBlock;
			Flag.JobIndex = job.JobIndex; //��¼���һ�η������ҵ��
			break;
		}
		else
		{
			continue;
		}
	}
}
void CMemAllocate::test()
{
	for (JCBInfo * p = m_JobsHead; p!= 0 ; p = p->nextPointer)
	{
		AllocateMem_FirstAdapt(*p);
	}
	
}

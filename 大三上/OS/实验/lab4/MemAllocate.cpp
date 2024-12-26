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
	//设置初始状态
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
void CMemAllocate::DrawMemory(CDC*pDC)//通过给内存块填充颜色显示内存的分配情况
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
		if (p->JobIndex  == 0 ) //如果内存块空， 填充浅色
			myRect.SetColorFill(RGB(200,200,200));
		else
			myRect.SetColorFill(RGB(100,100,100));
		
		myRect.Draw(pDC);
	}
}

void CMemAllocate::InitMemoryBlock()//初始化内存块，大小为1KB
{
	for (MemoryBlock * p = m_MemList; p!=0; p = m_MemList)
	{
		m_MemList = p->nextPointer;
		delete p;
	}	
	MemoryBlock * tmpMemBlock = new MemoryBlock;
	tmpMemBlock->BlockLength = 1024;/*千字节KB*/
	tmpMemBlock->JobIndex = 0;
	tmpMemBlock->StartAddr = 0;
	tmpMemBlock->nextPointer = 0;
	tmpMemBlock->prePointer = 0;
	
	m_MemList = tmpMemBlock;
}
void CMemAllocate::AddAJobInEnd(char * JobName,int JobIndex,int JobLength,int* JobPageTable)//添加进程
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

void CMemAllocate::InitJobs()//初始化进程列表，其中Joblength是指该作业所需的内存大小，如180表示180字节
{
	m_JobsHead = m_JobsEnd = 0;
	AddAJobInEnd("Job1",1,180,NULL);
	AddAJobInEnd("Job2",2,360,NULL);
	AddAJobInEnd("Job3",3,180,NULL);
	AddAJobInEnd("Job4",4,60,NULL);
	AddAJobInEnd("Job5",5,020,NULL);
}

void CMemAllocate::AllocateMem_FirstAdapt(CMemAllocate::JCBInfo& job)//实现了首次适配算法
{
	for (MemoryBlock * p = m_MemList; p != 0; p=p->nextPointer)
	{
		if (job.JobLength < p->BlockLength && p->JobIndex == 0)			//如果作业需要空间小于内存块空间，分配
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
//最佳适配算法 
void CMemAllocate::AllocateMem_BestAdapt(CMemAllocate::JCBInfo& job) {
	long MinBlockLength = 1024;
	MemoryBlock * q;
	for (MemoryBlock * p = m_MemList; p != 0; p= p->nextPointer)
	{
		if (job.JobLength <= p->BlockLength && p->JobIndex == 0) //如果作业需要空间小于内存块空间，分配
		{
			if(p ->BlockLength <= MinBlockLength)
			{
				MinBlockLength = p ->BlockLength; //找到满足作业的最小空闲块
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
//邻近(下次)适配算法
void CMemAllocate::AllocateMem_NextAdapt(CMemAllocate::JCBInfo& job)
{
	for ( MemoryBlock * p = Flag.latestMemBlock; p != 0; p=p->nextPointer) //从最近一次分配的位置开始进行首次适配算法
	{
		if (job.JobLength <= p->BlockLength && p->JobIndex == 0) //如果作业需要空间小于内存块空间，分配
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
			Flag.JobIndex = job.JobIndex; //记录最近一次分配的作业号
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

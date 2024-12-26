// MemAllocate.h: interface for the CMemAllocate class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_MEMALLOCATE_H__B3EE818A_71BA_4271_A81D_03613CC7ECF9__INCLUDED_)
#define AFX_MEMALLOCATE_H__B3EE818A_71BA_4271_A81D_03613CC7ECF9__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CMemAllocate  
{	
	/*内存块结构，可以表示主存空间占用情况（链表形式）*/
	typedef struct MemoryBlock {			
		long StartAddr;						//内存块起始地址(单位 KB)
		long BlockLength;					//内存块长度(单位 KB)
		int JobIndex;						//属于那个作业。nBelongToJob=0 表示“空闲”

		MemoryBlock * nextPointer;			//指向下一个MemoryBlock
		MemoryBlock * prePointer;			//指向上一个MemoryBlock
	};

	/*作业控制块信息结构*/
	typedef struct JCBInfo					
	{
		char* JobName;						//作业名
		int JobIndex;						//作业序号
		int JobLength;						//作业大小
		int* JobPageTable;					//页表首地址

		JCBInfo * nextPointer;				//指向下一个JCBInfo
		JCBInfo * prePointer;				//指向上一个JCBInfo
	};

public:
	CMemAllocate();
	virtual ~CMemAllocate();

private:
	MemoryBlock * m_MemList;				//主存空间占用列表(用链表表示)
	JCBInfo * m_JobsHead, * m_JobsEnd;		//作业控制块(用链表表示)

public:
	void DrawMemory( CDC* pDC);				//把当前的内存状态的图形画出来
	void InitMemoryBlock();					//把对象进行初始化内存空间。初始状态为一个1M(1024KB)的空间
	void InitJobs();						//初始化作业
	void AllocateMem_FirstAdapt(JCBInfo& job);		//(首次适应算法)把一个作业分配到内存中
	void AddAJobInEnd(char * JobName,int JobIndex,int JobLength,int* JobPageTable=NULL);//添加一个作业到作业链表的末尾

	void test();
};

#endif // !defined(AFX_MEMALLOCATE_H__B3EE818A_71BA_4271_A81D_03613CC7ECF9__INCLUDED_)

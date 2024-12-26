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


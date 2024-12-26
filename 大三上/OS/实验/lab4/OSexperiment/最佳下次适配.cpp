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


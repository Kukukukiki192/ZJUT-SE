void f(int *p,int n)//�������С��������
{int i,j,k,t;
	for(i=0;i<n-1;i++)
	{k=i;
	 for(j=i+1;j<n;j++)
		if(*(p+j)<*(p+k))k=j;
		t=*(p+k);*(p+i)=*(p+k);*(p+k)=t;
	}
//��ɸ����100֮�ڵ�����
#include <iostream>
using namespace std;
int main()
{
	int i,j,n=0,a[100],b[100];
	cout<<"100֮�ڵ�������"<<endl;
	for(i=0;i<100;i++)a[i]=i+1;
	for(i=1;i<100;i++)//i�Ǳ�����
	{
		for(j=2;j<i;j++)//j��iǰ�ĳ���
			if(i%j==0)break;
		if(i==j)
		{
			b[n]=i;
			n++;
		}
	}
	for(i=0;i<n;i++)cout<<b[i]<<" ";
	cout<<endl;
	return 0;
}

#include<iostream>
using namespace std;
void main()
{int i,k,m,n,a[100],*p;p=a;
	cout<<"Χ��Ȧ������n=:";
	cin>>n;
	for(i=0;i<n;i++)
		*(p+i)=i+1;//��n���˱��
	i=0;//iΪÿ��ѭ���ļ�������
	k=0;//k��1,2,3��������
	m=0;//mΪ�˳�����
	while(n-m>1)
	{if(*(p+i)!=0)k++;
	if(k==3)//�˳��߱�ű�Ϊ0
	{*(p+i)=0;
	k=0;
	m++;
	}
	i++;
	if(i==n)i=0;//������һȦ,i��Ϊ0
	}
	while(*p==0)p++;
	cout<<"������µ���ԭ�����ڵ�"<<*p<<"��"<<endl;
	system("pause");
}



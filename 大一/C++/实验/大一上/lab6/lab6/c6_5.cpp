#include<iostream>
using namespace std;
void main()
{int i,k,m,n,a[100],*p;p=a;
	cout<<"围成圈的人数n=:";
	cin>>n;
	for(i=0;i<n;i++)
		*(p+i)=i+1;//给n个人编号
	i=0;//i为每次循环的计数变量
	k=0;//k按1,2,3报数计数
	m=0;//m为退出人数
	while(n-m>1)
	{if(*(p+i)!=0)k++;
	if(k==3)//退出者编号变为0
	{*(p+i)=0;
	k=0;
	m++;
	}
	i++;
	if(i==n)i=0;//报数完一圈,i变为0
	}
	while(*p==0)p++;
	cout<<"最后留下的人原来排在第"<<*p<<"号"<<endl;
	system("pause");
}



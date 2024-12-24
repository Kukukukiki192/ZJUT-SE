#include<iostream>
using namespace std;
void f1(int a[],int n)//输入n个整数
{
	cout<<"输入"<<n<<"个整数";
	for(int i=0;i<n;i++)cin>>a[i];
}
void f2(int a[],int n)//进行处理
{int i,i_min=0,i_max=0,t,min=a[0],max=a[0];
	for(i=1;i<n;i++)
    {
		if(a[i]<a[i_min]){min=a[i];i_min=i;}
	    if(a[i]>a[i_max]){max=a[i];i_max=i;}
	}
	t=a[0];a[0]=min;a[i_min]=t;
	t=a[n-1];a[n-1]=max;a[i_max]=t;
}
void f3(int a[],int n)//输出n个整数
{   cout<<"输出这些整数:";
	for(int i=0;i<n;i++)cout<<a[i]<<" ";
}

void main()
{int a[100],n;
    cout<<"输入整数的个数n:";
    cin>>n;
	f1(a,n);
	f2(a,n);
	f3(a,n);
	system("pause");
}
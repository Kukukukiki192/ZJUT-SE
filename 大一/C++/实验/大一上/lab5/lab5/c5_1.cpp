#include<iostream>
#define n 3
using namespace std;
void main()
{void f(int *p,int n);
	int a[n],i,*p=a;
	cout<<"please enter "<<n<<" integers:";
	for(i=0;i<n;i++)cin>>a[i];
	cout<<"the original number is:";
    for(i=0;i<n;i++)cout<<a[i]<<" ";
	cout<<endl;
	cout<<"the inverted number sequence is :";
	f(p,n);
	for(i=0;i<n;i++)cout<<a[i]<<" ";
	cout<<endl;
	system("pause");
}
void f(int *p,int n)
{
	int i,t,*p1,*p2;
	for(i=0;i<n/2;i++)
	{p1=p+i;p2=p+(n-i-1);
	t=*p1;*p1=*p2;*p2=t;}
}


#include<iostream>
using namespace std;
void main()
{	void f(int *a);
	int n=0,i,a[10],*p;
	p=a;
	cout<<"输入10个数字:";
	for(i=0;i<10;i++)cin>>a[i];
    for(i=0;i<10;i++)if(a[i]!=a[i+1])n++;
	cout<<"以上数字中不同的数有"<<n<<"个，分别是:";
	f(p);
	system("pause");
}
void f(int *a)
{
	int i;
    for(i=0;i<10;i++)if(a[i]!=a[i+1])cout<<a[i]<<" ";
	cout<<endl;
}






#include<iostream>
using namespace std;
void main()
{	void f(int *a);
	int n=0,i,a[10],*p;
	p=a;
	cout<<"����10������:";
	for(i=0;i<10;i++)cin>>a[i];
    for(i=0;i<10;i++)if(a[i]!=a[i+1])n++;
	cout<<"���������в�ͬ������"<<n<<"�����ֱ���:";
	f(p);
	system("pause");
}
void f(int *a)
{
	int i;
    for(i=0;i<10;i++)if(a[i]!=a[i+1])cout<<a[i]<<" ";
	cout<<endl;
}






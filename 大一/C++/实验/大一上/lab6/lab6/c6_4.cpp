#include<iostream>
using namespace std;
const int n=7;
void main()
{void f(int *p,int n,int m);
	int a[n],i,m=3,*p;p=a;
	cout<<"输入"<<n<<"个整数:";
	for(i=0;i<n;i++)
		cin>>*(p+i);
	cout<<endl;
	cout<<"调整后的"<<n<<"个数:";
    f(p,n,m);
	cout<<endl;
	system("pause");
}
void f(int *p,int n,int m)
{int i,j,b[10],c[10];
		for(i=0;i<n-m;i++)
			b[i]=*(p+i);
		for(j=0,i=n-m;j<n-m,i<n;j++,i++)
			c[j]=*(p+i);
		for(j=0;j<m;j++)
			cout<<c[j]<<" ";
		for(i=0;i<n-m;i++)
			cout<<b[i]<<" ";
}
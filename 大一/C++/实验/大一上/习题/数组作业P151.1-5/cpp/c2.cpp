//用选择法对10个整数排序
#include<iostream>
using namespace std;
int main()
{cout<<"input 10 numbers：";
	int i,j,x,a[11];
	for(i=1;i<11;i++)cin>>a[i];
	cout<<endl;
	for(j=1;j<10;j++)
	for(i=1;i<=10-j;i++)
	if(a[i]>a[i+1])
    {x=a[i];a[i]=a[i+1];a[i+1]=x; }
    cout<<"the sorted numbers:";
    for(i=1;i<11;i++)cout<<a[i]<<" ";
    cout<<endl;
    return 0;
}
//��һ�������е�ֵ���������´��.
//eg.ԭ��˳��Ϊ8,6,5,4,1.Ҫ���Ϊ1,4,5,6,8.
#include<iostream>
using namespace std;
int main()
{ 
	const int n=3;
	int a[n],i,t;
	cout<<"input array��";
	for(i=0;i<n;i++)
	cin>>a[i];
	cout<<endl;
	for (i=0;i<n/2;i++)
	{
		t=a[i];
		a[i]=a[n-i-1];
		a[n-i-1]=t;
	}
	cout<<"inverse array:";
	for(i=0;i<n;i++)
		cout<<a[i]<<" ";
    cout<<endl;
    return 0;
}
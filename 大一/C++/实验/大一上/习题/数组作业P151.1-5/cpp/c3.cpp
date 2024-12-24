//求一个3x3矩阵对角线元素之和
#include<iostream>
using namespace std;
int main()
{int a[3][3],i,j,sum1=0,sum2=0,sum;
	cout<<"输入3x3矩阵的元素："<<endl;
	for(i=0;i<3;i++)
	{for(j=0;j<3;j++)
	 cin>>a[i][j];
	 cout<<endl;}
	for(i=0;i<3;i++) 
	for(j=0;j<3;j++)
	if(i=j)sum1+=a[i][j];
	for(i=0;i<3;i++) 
	for(j=0;j<3;j++)
	if(i+j==2)sum2+=a[i][j];
	sum=sum1+sum2;
	cout<<"对角线元素之和为："<<sum<<endl;
	return 0;
}
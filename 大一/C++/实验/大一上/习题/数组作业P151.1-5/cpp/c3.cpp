//��һ��3x3����Խ���Ԫ��֮��
#include<iostream>
using namespace std;
int main()
{int a[3][3],i,j,sum1=0,sum2=0,sum;
	cout<<"����3x3�����Ԫ�أ�"<<endl;
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
	cout<<"�Խ���Ԫ��֮��Ϊ��"<<sum<<endl;
	return 0;
}
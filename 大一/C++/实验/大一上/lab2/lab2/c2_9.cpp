#include<iostream>
#include<iomanip>
using namespace std;
int main()
{int n,i;
	cout<<"����iֵ��";
	cin>>i;
	float pi,a,b,c,x=1;
	for(n=1;n<=i;n++)
	{
		a=2*n;
		b=a-1;
		c=a+1;
		x=x*((a/b)*(a/c));
	}
	cout<<"pi�Ľ���ֵ��"<<setiosflags(ios::fixed)<<setprecision(5)<<2*x<<endl;
	return 0;
}
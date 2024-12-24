#include<iostream>
using namespace std;
int main()
{int m,n;int m1,n1,res;//被除数，除数，余数
	cout<<"输入两个正整数m和n:";
	cin>>m>>n;
	m1=m;
	n1=n;
	res=m1%n1;
	while (res!=0)
	{m1=n1;
		n1=res;
		res=m1%n1;
	}
	cout<<"最大公约数为："<<n1<<endl;
	cout<<"最小公倍数为："<<m*n/n1<<endl;
	return 0;
}
#include<iostream>
using namespace std;
int main()
{int m,n;int m1,n1,res;//������������������
	cout<<"��������������m��n:";
	cin>>m>>n;
	m1=m;
	n1=n;
	res=m1%n1;
	while (res!=0)
	{m1=n1;
		n1=res;
		res=m1%n1;
	}
	cout<<"���Լ��Ϊ��"<<n1<<endl;
	cout<<"��С������Ϊ��"<<m*n/n1<<endl;
	return 0;
}
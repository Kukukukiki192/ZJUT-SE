//�÷�(2)��ĳһ���ݼ���֤��Լ�� ������
#include <iostream>
using namespace std;
int main()//������������
{
	int n=1,N,a,b,c,x;
	cin>>N;
	while(n<=N)
	{
		cin>>a>>b>>c;
	    x=a;
		while(!(a%x==0&&b%x==0&&c%x==0))x--;
        cout<<x<<endl;
        n++;//Don't forget!!!
	}
    return 0;
}
/*
int main()//��������������,��������������������
{
	int a,b,c,x;
	while(cin>>a>>b>>c)
	{   if(!(a>0&&b>0&&c>0))break;
		x=a;
		while(!(a%x==0&&b%x==0&&c%x==0)) x--;
		cout<<x<<endl;
	}
	return 0;
}
*/
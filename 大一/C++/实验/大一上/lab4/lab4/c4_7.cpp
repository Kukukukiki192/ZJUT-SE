//Hanoi
#include<iostream>
using namespace std;

int f(int n,char A,char B,char C)//Hanoi�㷨
{void move(char A,char C);//����move����
	if(n==1)move(A,C);
	else
	{f(n-1,A,C,B);
	move(A,C);
	f(n-1,B,A,C);
	}
	return 0;
}

void move(char A,char C)//����move����
{cout<<A<<"->"<<C<<endl;}

void main()
{char A='A',B='B',C='C';
    int n;
	cout<<"�������Ӹ���n:";
	cin>>n;
	cout<<f(n,A,B,C)<<endl;
	system("pause");
}

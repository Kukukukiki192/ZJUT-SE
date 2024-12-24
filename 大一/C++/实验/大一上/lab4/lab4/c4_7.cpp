//Hanoi
#include<iostream>
using namespace std;

int f(int n,char A,char B,char C)//Hanoi算法
{void move(char A,char C);//声明move函数
	if(n==1)move(A,C);
	else
	{f(n-1,A,C,B);
	move(A,C);
	f(n-1,B,A,C);
	}
	return 0;
}

void move(char A,char C)//定义move函数
{cout<<A<<"->"<<C<<endl;}

void main()
{char A='A',B='B',C='C';
    int n;
	cout<<"输入盘子个数n:";
	cin>>n;
	cout<<f(n,A,B,C)<<endl;
	system("pause");
}

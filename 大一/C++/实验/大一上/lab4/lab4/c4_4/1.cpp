#include<iostream>
using namespace std;
int a;//全局变量
void main()
{  extern int power(int);//存在a^m的函数
	int b=5,m;
    cout<<"输入整数a,m的值:";
    cin>>a>>m;
    cout<<a<<"*"<<b<<"="<<a*b<<endl;
	cout<<a<<"^"<<m<<"="<<power(m)<<endl;
	system("pause");
}
   

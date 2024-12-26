//3.用string方法定义字符串变量
#include<iostream>
#include<string>
using namespace std;
int main()
{string a,b;
	cout<<"输入字符串1："<<endl;
	cin>>a;
	cout<<"输入字符串2："<<endl;
	cin>>b;
	cout<<"新字符串："<<(a+b)<<endl;
	return 0;
}
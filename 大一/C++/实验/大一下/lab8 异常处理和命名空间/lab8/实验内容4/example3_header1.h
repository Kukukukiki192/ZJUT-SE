//header1.h (头文件1，设其文件名为example3_header1.h)
#include <string>
#include <cmath>
#include<iostream>
using namespace std;
namespace ns1
{
class Student//声明Student类
{
public:
	Student(int n,string nam,int a)
	{num=n;name=nam;age=a;}
	void get_data( );
private:
	int num;
	string name;
	int age;
};
void Student::get_data( ) //成员函数定义
{
	cout<<num<<" "<<name<<" "<<age<<endl;
}
double fun(double a,double b) //定义全局函数(即外部函数)
{
	return sqrt(a+b);
}
}

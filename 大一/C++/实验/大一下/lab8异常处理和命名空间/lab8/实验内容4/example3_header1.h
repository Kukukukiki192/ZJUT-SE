//header1.h (ͷ�ļ�1�������ļ���Ϊexample3_header1.h)
#include <string>
#include <cmath>
#include<iostream>
using namespace std;
namespace ns1
{
class Student//����Student��
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
void Student::get_data( ) //��Ա��������
{
	cout<<num<<" "<<name<<" "<<age<<endl;
}
double fun(double a,double b) //����ȫ�ֺ���(���ⲿ����)
{
	return sqrt(a+b);
}
}

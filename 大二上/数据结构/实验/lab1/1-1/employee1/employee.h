//employee.h
#include<iostream>
using namespace std;
class employee
{
protected:
	char name[20];	//姓名
	int individualEmpNo;	//个人编号
	int grade;	//级别
	float accumPay;	//月薪
	static int employeeNo;	//本公司职员编号目前最大值
public:
	employee();	//构造函数
	~employee();	//析构函数
	void SetName(char *); 	//设置姓名函数
	char * GetName();//提取姓名函数
	void promote(int);	//升级函数
	void SetaccumPay (float pa);  	//设置月薪函数
	int GetindividualEmpNo();	//提取编号函数
	int Getgrade();	//提取级别函数
	float GetaccumPay(); 	//提取月薪函数
};

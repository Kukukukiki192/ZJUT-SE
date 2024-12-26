#include<iostream>
using namespace std;
#include"employee.h"
int main()
{
	employee emp[4];
	char namestr[20];           //输入雇员姓名时首先临时存放在namestr中
	float pa;
	int grade, i;
	for (i=0; i<4; i++)
	{
	cout<<"请输下一个雇员的姓名:";
	cin>>namestr;
	emp[i].SetName(namestr);	//设置雇员emp[i]的姓名
	cout<<"请输入雇员的月薪:";
	cin>> pa;
	emp[i]. SetaccumPay (pa);	//设置emp[i]的月薪
	cout<<"请输入雇员的提升级别:";
	cin>>grade;
	emp[i].promote(grade);	// emp[i]升级
	}

	//显示信息
	for (i=0; i<4; i++)
	{
	cout<< emp[i].GetName()<<"编号"<< emp[i].GetindividualEmpNo()
	    <<"级别为"<< emp[i].Getgrade()<<"级，本月工资"<< emp[i].GetaccumPay()<<endl;
	}
	return 0;
}

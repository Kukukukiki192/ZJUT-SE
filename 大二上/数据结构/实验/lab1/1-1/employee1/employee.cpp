//empfunc.cpp
#include<iostream>
#include<cstring>	//包含字符串操作头文件
#include"employee.h"
using namespace std;
int employee::employeeNo=1000;	//员工编号基数为1000

employee::employee()
{	individualEmpNo=employeeNo++;  	//新输入的员工编号为目前最大编号加1
	grade=1;	//级别初值为1
	accumPay=0.0; }	//月薪总额初值为0

employee::~employee() {}

void employee::promote(int increment)
{	grade+=increment;}	//升级，提升的级数由increment指定

void employee::SetName(char names[])
{	strcpy(name,names); }	//设置姓名

char* employee::GetName()
{	return name;}	//提取成员姓名

void employee::SetaccumPay (float pa)  	
{	accumPay=pa;}	//设置月薪

int employee::GetindividualEmpNo()
{	return individualEmpNo;}	//获取成员编号

int employee::Getgrade()
{	return grade;}	//获取级别

float employee::GetaccumPay()
{	return accumPay;}	//获取月薪


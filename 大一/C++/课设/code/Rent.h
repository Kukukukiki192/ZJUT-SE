#ifndef rent_h
#define rent_h
#include<string>
#include<iostream>
using namespace std;
class Date
{public:
	Date(){year=0;	month=0;	day=0;}
	Date(int y,int m,int d):year(y),month(m),day(d){}//日期信息设置
	int subDate();//计算该日期的总天数
	friend istream&operator>>(istream&,Date&);
private:
	int year;
	int month;
	int day;
};
bool Leap(int y)//判断year是否闰年
{   return y%4==0&&y%100!=0||y%400==0;//真返回为1，假为0
}
int subMonth(int y,int m)//返回某年某月的天数
{   int month[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(m!=2)return month[m-1];
	else return 28+Leap(y);//是闰年则2月有29天
}
int subDate1(int y,int m,int d)//计算某日期的总天数
{	int days=d;
	for(int y1=1;y1<y;y1++)//计算年		
	days+=365+Leap(y);	
	for(int m1=1;m1<m;m1++)//计算月		
	days+=subMonth(y,m);	
	return days;
}
int Date::subDate()
{   return subDate1(year,month,day);
}
istream&operator>>(istream& in,Date& d)
{	in>>d.year>>d.month>>d.day; 
	return in;
}

class Rent//出租信息类
{private:
	string memberName;//会员名
	string CDname;
	Date borrowDate;//借阅日期(格式:2000年1月1日写为20000101)
	Date returnDate;//归还日期
	int rental;//租金
public:
	Rent()
	{	memberName="";	CDname="";	borrowDate;	returnDate;	rental=0;
	}
	Rent(Date bo,Date re,string a,string b,int r):
		memberName(a),CDname(b),borrowDate(bo),returnDate(re),rental(r){} 
	string gmemName(){return memberName;}
	void smemName(string a){memberName=a;}
	void sCDname(string a){CDname=a;}
	string gCDname(){return CDname;}
	int find_name(string a)
	{	int b=0;
		if(memberName==a) b++; 
		return b;
	}
	void cinboDate(){cin>>borrowDate;}
	void cinreDate(){cin>>returnDate;}
	int grental()
	{	int a=(returnDate.subDate()-borrowDate.subDate())/3;
		if((returnDate.subDate()-borrowDate.subDate())%3==0) return a;
		else return a+1;
	}
};


#endif

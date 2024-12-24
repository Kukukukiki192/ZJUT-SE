#include"Date.h"
#include<iostream>
#include<iomanip>
using namespace std;
void Date::display()
{   cout<<year<<"."<<month<<"."<<day<<endl;
}
bool Leap(int y)//判断year是否闰年
{   return y%4==0&&y%100!=0||y%400==0;//真返回为1，假为0
}
int daysOfMonth(int y,int m)//返回某年某月的天数
{   int day[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(m!=2)return day[m-1];
	else return 28+Leap(y);//是闰年则2月有29天
}
int daysOfDate1(int y,int m,int d)//计算某日期的总天数
{	int days=d;
	for(int y1=1;y1<y;y1++)//计算年		
	days+=365+Leap(y);	
	for(int m1=1;m1<m;m1++)//计算月		
	days+=daysOfMonth(y,m);
	//days+=d.d;	
	return days;
}
int Date::weekday()  
{   return daysOfDate1(year,month,day)%7;
}
int Date::daysOfDate()
{   return daysOfDate1(year,month,day);
}
void Date::m_calendar()
{
    cout<<"==========================="<<endl;
    cout<<"SUN MON TUE WED THU FRI STA"<<endl;
    cout<<"---------------------------"<<endl;
    cout<<setw(4)<<setiosflags(ios::left);
	int w=weekday(),m=daysOfMonth(year,month);
    for(int i=0;i<w;i++) cout<<' ';
    for(int j=1;j<=m;j++)
    {
      cout<<j;
      if((w-1+j)%7==0) cout<<endl;
    }
    cout<<endl;
    cout<<"==========================="<< endl;
}
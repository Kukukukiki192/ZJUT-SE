#include"Date.h"
#include<iostream>
#include<iomanip>
using namespace std;
void Date::display()
{   cout<<year<<"."<<month<<"."<<day<<endl;
}
bool Leap(int y)//�ж�year�Ƿ�����
{   return y%4==0&&y%100!=0||y%400==0;//�淵��Ϊ1����Ϊ0
}
int daysOfMonth(int y,int m)//����ĳ��ĳ�µ�����
{   int day[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(m!=2)return day[m-1];
	else return 28+Leap(y);//��������2����29��
}
int daysOfDate1(int y,int m,int d)//����ĳ���ڵ�������
{	int days=d;
	for(int y1=1;y1<y;y1++)//������		
	days+=365+Leap(y);	
	for(int m1=1;m1<m;m1++)//������		
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
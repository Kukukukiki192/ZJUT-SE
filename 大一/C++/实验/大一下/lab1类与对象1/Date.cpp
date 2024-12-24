//任给2个日期，计算相差几天和各自周几
#include <iostream>
using namespace std;
struct Date
{   int y;//year
	int m;//month
	int d;//day in month
}
bool isLeap(int y)//判断year是否闰年
{   return y%4==0&&y%100!=0||y%400==0;//真返回为1，假为0
}
int daysOfMonth(int y,int m)//返回某年某月的天数
{   int day[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(m!=2)return day[m-1];
	else return 28+isLeap(y);//是闰年则2月有29天
}
int daysOfDate(Date d)//计算某日期的总天数
{	int days=d.d;
	for(int y=1;y<d.y;y++)//计算年		
	days+=365+isLeap(y);	
	for(int m=1;m<d.m;m++)//计算月		
	days+=daysOfMonth(d.y,d.m);
	//days+=d.d;	
	return days;
}
int main()
{	Date d1,d2;	
	cout<<"intput 2 dates(yyyy mm dd):";	
	cin>>d1.y>>d1.m>>d1.d;	
	cin>>d2.y>>d2.m>>d2.d;	
	int days1=daysOfDate(d1);	
	int days2=daysOfDate(d2);	
	cout<<"difference:"<<days2-days1<<endl;	//相差几天
	cout<<"weekday:"<<days1%7<<'\t'<<days2%7<<endl;//各自周几
	return 0;
}

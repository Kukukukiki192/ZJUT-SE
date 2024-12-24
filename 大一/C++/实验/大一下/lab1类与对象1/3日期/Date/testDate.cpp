#include"Date.h"
#include<iostream>
#include<cmath>
using namespace std;
int main()
{
 Date d1(1984,3,15);
 cout<<"Date1:";
 d1.display();
 cout<<"weekday:"<<d1.weekday();
 cout<<"m_calendar:";
 d1.m_calendar();
 Date d2(2019,3,15);
 cout<<"Date2:";
 d2.display();
 int x=abs(d1.daysOfDate()-d2.daysOfDate());
 cout<<"difference between Date1 n Date2:"<<x<<endl;
 system("pause");
 return 0;
}
 
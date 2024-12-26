#include "time24.h"
#include<iostream>
using namespace std;
time24::time24(int h=0,int m=0)
{
	normalizeTime();
	Hour=h; Minute=m;
}
void time24::addTime(int m)
{
	if(m+Minute>=60){
		Hour++;
		Minute-=60;
	}
	normalizeTime();
}
time24 time24::duration(const time24& t)
{
	//t.normalizeTime();
	//int h=t.Hour-Hour,m;
	//if(t.Minute>=Minute) m=t.Minute-Minute;
	//else {m=t.Minute+60-Minute; h--;}
	int now=Hour*60+Minute;
	int T=t.Hour*60+t.Minute;
	int h=(T-now)/60;
	int m=(T-now)%60;
	return time24(h,m);
} 
void time24::readTime()
{
	char c;
	cin>>Hour>>c>>Minute;
	normalizeTime();
}
void time24::writeTime() const
{
	cout<<Hour<<":"<<Minute<<endl;
}
int time24::getHour() const
{
	return Hour;
}
int time24::getMinute() const
{
	return Minute;
}

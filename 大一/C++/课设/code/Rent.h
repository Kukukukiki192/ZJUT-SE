#ifndef rent_h
#define rent_h
#include<string>
#include<iostream>
using namespace std;
class Date
{public:
	Date(){year=0;	month=0;	day=0;}
	Date(int y,int m,int d):year(y),month(m),day(d){}//������Ϣ����
	int subDate();//��������ڵ�������
	friend istream&operator>>(istream&,Date&);
private:
	int year;
	int month;
	int day;
};
bool Leap(int y)//�ж�year�Ƿ�����
{   return y%4==0&&y%100!=0||y%400==0;//�淵��Ϊ1����Ϊ0
}
int subMonth(int y,int m)//����ĳ��ĳ�µ�����
{   int month[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(m!=2)return month[m-1];
	else return 28+Leap(y);//��������2����29��
}
int subDate1(int y,int m,int d)//����ĳ���ڵ�������
{	int days=d;
	for(int y1=1;y1<y;y1++)//������		
	days+=365+Leap(y);	
	for(int m1=1;m1<m;m1++)//������		
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

class Rent//������Ϣ��
{private:
	string memberName;//��Ա��
	string CDname;
	Date borrowDate;//��������(��ʽ:2000��1��1��дΪ20000101)
	Date returnDate;//�黹����
	int rental;//���
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

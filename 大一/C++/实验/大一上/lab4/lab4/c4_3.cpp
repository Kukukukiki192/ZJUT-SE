#include<iostream>
#include<cmath>
using namespace std;
double x,x1,x2,d;
void f1(double a,double b,double c)
{cout<<"�޸�"<<endl;}
void f2(double a,double b,double c)
{cout<<"��1����,x="<<-b/(2*a)<<endl;}
void f3(double a,double b,double c)
{d=b*b-4*a*c;
	cout<<"��2������x1="<<(-b+sqrt(d))/(2*a)<<" x2="<<(-b-sqrt(d))/(2*a)<<endl;}
void main()
{double a,b,c,d;
	cout<<"����a,b,c:";
	cin>>a>>b>>c;
	d=b*b-4*a*c;
    if(d<0)f1(a,b,c);
    else if(d==0)f2(a,b,c);
    else f3(a,b,c);
	system("pause");
}

#include<iostream>
#include"circum.h"
using namespace std;
int main()
{int loop;
circum angle,month;
angle.set_mode(0,359);
angle.set_value(250);
month.set_mode(1,12);
month.set_value(11);
//显示对象的初始状态
cout<<"初角度="<<angle.get_value()<<endl;
cout<<"初月份="<<month.get_value()<<endl;
for(loop=1;loop<=100;loop+=1) angle.increment();
for(loop=1;loop<=300;loop+=1) angle.decrement();
for(loop=1;loop<=10;loop+=1) month.increment();
for(loop=1;loop<=15;loop+=1) month.decrement();
cout<<"末角度="<<angle.get_value()<<endl;
cout<<"末月份="<<month.get_value()<<endl;
system("pause");
return 0;
}
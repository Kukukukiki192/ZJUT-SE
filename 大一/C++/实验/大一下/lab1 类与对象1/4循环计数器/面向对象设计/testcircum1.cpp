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
//��ʾ����ĳ�ʼ״̬
cout<<"���Ƕ�="<<angle.get_value()<<endl;
cout<<"���·�="<<month.get_value()<<endl;
for(loop=1;loop<=100;loop+=1) angle.increment();
for(loop=1;loop<=300;loop+=1) angle.decrement();
for(loop=1;loop<=10;loop+=1) month.increment();
for(loop=1;loop<=15;loop+=1) month.decrement();
cout<<"ĩ�Ƕ�="<<angle.get_value()<<endl;
cout<<"ĩ�·�="<<month.get_value()<<endl;
system("pause");
return 0;
}
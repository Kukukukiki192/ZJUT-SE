#include "circum3.hpp"
#include <iostream.h>

int main()
{
int loop;

circular_numbers angle;
circular_numbers month;

angle.set_mode(0,359);
angle.set_value(250);
month.set_mode(1,12);
month.set_value(11);
//��ʾ����ĳ�ʼ״̬
cout<<"��ʼ�Ƕ�Ϊ"<<angle.increment()<<"\n";
cout<<"��ʼ�·�Ϊ"<<month.get_value()<<"\n";
for(loop=1;loop<=100;loop=loop+1) angle.increment();
for(loop=1;loop<=300;loop=loop+1) angle.decrement();
for(loop=1;loop<=10;loop=loop+1) month.increment();
for(loop=1;loop<=15;loop=loop+1) month.decrement();

cout<<"���ĽǶ���"<<angle.get_value()<<"\n";
cout<"�����·���"<<month.get_value()<<"\n";
return 0;
}
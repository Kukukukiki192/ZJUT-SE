//��ʾ������̵�ѭ��������
#include "circum1.hpp"
#include <iostream.h>

int main()
{
   int month;
   cout<<"�������·�(1-12)";//��������һ���·�
   cin>>month;
   //��ʼ��ѭ��������
   set_mode(1,12);//����ģ
   set_value(month);//���õ�ǰֵ
   //������һ����
   increment();
   cout<<"��һ������"<<get_value()<<endl;
   //����ǰ������
   decrement();//�ָ�ԭ��
   decrement();
   decrement();
   cout<<"����������"<<get_value()<<endl;
   return 0;
}
#include "circum.h"
#include <iostream>
int main()
{
   int month;
   cout<<"�������·�(1-12)";
   cin>>month;
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
   system("pause");
   return 0;
}
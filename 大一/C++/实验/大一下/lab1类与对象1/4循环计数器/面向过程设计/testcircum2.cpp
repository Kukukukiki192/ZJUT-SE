#include "circum.h"
#include <iostream>
int main()
{
   int month;
   cout<<"请输入月份(1-12)";
   cin>>month;
   set_mode(1,12);//设置模
   set_value(month);//设置当前值
   //计算下一个月
   increment();
   cout<<"下一个月是"<<get_value()<<endl;
   //计算前两个月
   decrement();//恢复原来
   decrement();
   decrement();
   cout<<"上两个月是"<<get_value()<<endl;
   system("pause");
   return 0;
}
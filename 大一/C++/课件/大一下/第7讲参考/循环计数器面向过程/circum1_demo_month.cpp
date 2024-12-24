//演示面向过程的循环计数器
#include "circum1.hpp"
#include <iostream.h>

int main()
{
   int month;
   cout<<"请输入月份(1-12)";//用于输入一个月份
   cin>>month;
   //初始化循环计数器
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
   return 0;
}
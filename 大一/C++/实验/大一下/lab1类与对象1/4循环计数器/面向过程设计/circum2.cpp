#include "circum.h"
//全局变量，循环计数所有函数共享
//static限制数据被其他文件使用，即数据为循环计数器内部数据
static int min_val;//循环计数器下限
static int max_val;//循环计数器上限
static int current;//循环计数器当前值

void  set_mode(int min,int max)
{  min_val=min;
   max_val=max;
}
void set_value(int value)
{ current=value;
}
int get_value()
{return current;
}
void increment()
{ int mode=max_val-min_val+1;
  current=((current-min_val)+1)%mode+min_val;
}
void decrement()
{ int mode=max_val-min_val+1;
  current=((current-min_val)-1)%mode+min_val;
}
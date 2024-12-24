
#include "circum3.hpp"


//设置循环计数器的模
void  circular_numbers::set_mode(unsigned int min,unsigned int max)
{  min_val=(min<=max)?min:max;
   max_val=(min<=max)max:min;
}

//设置循环计数器当前值
void circular_numbers::set_value(int value)
{ if(value<min_val) current=min_val;
  else if(value>max_val) current=max_val;
  else current=value;
}

//查询循环计数器当前值
int circular_numbers::get_value()
{return current;
}

//循环计数器加1
void circular_numbers::increment()
{ int mode=max_val-min_val+1;
  current=((current-min_val)+1)%mode+min_val;
}

//循环计数器减1
void circular_numbers::decrement()
{ int mode=max_val-min_val+1;
  current=((current-min_val)-1)%mode+min_val;
}
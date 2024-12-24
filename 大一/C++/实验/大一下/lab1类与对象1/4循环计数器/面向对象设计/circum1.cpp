#include<iostream>
#include"circum.h"
using namespace std;
//取模运算实现循环计数
void circum::set_mode(unsigned int min,unsigned int max)
{min_val=(min<max)?min:max;
 max_val=(max<min)?min:max;
}
void circum::set_value(int value)
{if(value<min_val) current=min_val;
 else if(value>max_val) current=max_val;
 else current=value;
}
int circum::get_value()
{return current;
}
void circum::increment()
{int mode=max_val-min_val+1;
 current=(current-min_val+1)%mode+min_val;
}
void circum::decrement()
{int mode=max_val-min_val+1;
 current=(current-min_val-1)%mode+min_val;
}
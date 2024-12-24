
#include "circum3.hpp"


//����ѭ����������ģ
void  circular_numbers::set_mode(unsigned int min,unsigned int max)
{  min_val=(min<=max)?min:max;
   max_val=(min<=max)max:min;
}

//����ѭ����������ǰֵ
void circular_numbers::set_value(int value)
{ if(value<min_val) current=min_val;
  else if(value>max_val) current=max_val;
  else current=value;
}

//��ѯѭ����������ǰֵ
int circular_numbers::get_value()
{return current;
}

//ѭ����������1
void circular_numbers::increment()
{ int mode=max_val-min_val+1;
  current=((current-min_val)+1)%mode+min_val;
}

//ѭ����������1
void circular_numbers::decrement()
{ int mode=max_val-min_val+1;
  current=((current-min_val)-1)%mode+min_val;
}
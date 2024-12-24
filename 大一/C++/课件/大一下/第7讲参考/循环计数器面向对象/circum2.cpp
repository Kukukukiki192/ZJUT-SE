class circular_numbers{
public:
  //设置循环计数器的模
  void  set_mode(int min,int max)
  {  min_val=min;
     max_val=max;
  }

   //设置循环计数器当前值
  void set_value(int value)
  { current=value;
  }

  //查询循环计数器当前值
  int get_value()
  {return current;
  }

  //循环计数器加1
  void increment()
  { int mode=max_val-min_val+1;
    current=((current-min_val)+1)%mode+min_val;
  }

  //循环计数器减1
   void decrement()
  { int mode=max_val-min_val+1;
  current=((current-min_val)-1)%mode+min_val;
  }
private:
  int min_val;
  int max_val;
  int current;
};
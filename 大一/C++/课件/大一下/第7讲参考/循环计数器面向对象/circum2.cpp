class circular_numbers{
public:
  //����ѭ����������ģ
  void  set_mode(int min,int max)
  {  min_val=min;
     max_val=max;
  }

   //����ѭ����������ǰֵ
  void set_value(int value)
  { current=value;
  }

  //��ѯѭ����������ǰֵ
  int get_value()
  {return current;
  }

  //ѭ����������1
  void increment()
  { int mode=max_val-min_val+1;
    current=((current-min_val)+1)%mode+min_val;
  }

  //ѭ����������1
   void decrement()
  { int mode=max_val-min_val+1;
  current=((current-min_val)-1)%mode+min_val;
  }
private:
  int min_val;
  int max_val;
  int current;
};
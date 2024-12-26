// MULT1_PARA_main.cpp
//#include "MULT1_PARA.hpp"
#include <iostream.h>


template  < typename  T1,typename T2 >   
class MULT1_PARA{
public:
    MULT1_PARA (const T1& x,const T2& y); 	
    void show();
private:
	T1 first;
    T2 second;
};

template  < typename  T1,typename T2 >   
MULT1_PARA<T1,T2> :: MULT1_PARA(const T1& x,const T2& y):first(x),second(y)
{    }

template  < typename  T1,typename T2 >
 void  MULT1_PARA<T1,T2> :: show()
{  cout<<first<<endl;
   cout<<second<<endl;    }

int main()
{    //注意模板类实例化的方法
     time24 t1(5,30);
     MULT1_PARA<int,double>    obj1(2,3.14);
     MULT1_PARA<time24,char>  obj2(t1, 'Y');
     
     obj1.show();
     obj2.show();
     
     return 0;    
  }

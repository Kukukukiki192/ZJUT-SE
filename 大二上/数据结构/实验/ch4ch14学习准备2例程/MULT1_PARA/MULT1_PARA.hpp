// MULT1_PARA.hpp
#include <iostream.h>
#include "..\headerfiles\string\string.h"

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

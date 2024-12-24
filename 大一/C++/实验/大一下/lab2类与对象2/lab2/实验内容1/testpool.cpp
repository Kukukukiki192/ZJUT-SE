#include <iostream>
using namespace std;
#include "pool.h"
int main()
{  const double zddj=167.5;//走道单价
   const double wldj=36.4;//围栏单价
   pool  a[3]=
   {pool(5.0,2.8,1),
   	pool(4.8,1.0,2),
   	pool(6.0,1.4,3)
   	};
 for(int I=0;I<3;I++)
 {  cout<<"第"<<I+1<<"号游泳池造价为:"
<<(a[I].rail_length()*wldj+a[I].rail_area()*zddj)<<"元"<<endl;
 }
 system("pause");
 return 0;
}

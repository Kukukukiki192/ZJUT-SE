#include <iostream>
using namespace std;
#include "pool.hpp"
void main()
{  const double zddj=167.5;//走道单价
   const double wldj=36.4;//围栏单价
   double r;//池直径
   double c;//走道宽
   pool  apool;
   cout<<"输入直径.走道宽"<<endl;
 for(int I=1;I<=5;I++)
 {  cout<<"建造第"<<I<<"号游泳池";
    apool.build(); 
    cout<<"第"<<I<<"号游泳池造价为:"
<<(apool.rail_length()*wldj+apool.rail_area()*zddj)<<"元"<<endl;
 }
 system("pause");
}

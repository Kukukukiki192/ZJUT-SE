#include <iostream>
using namespace std;
#include "pool.h"
int main()
{  const double zddj=167.5;//�ߵ�����
   const double wldj=36.4;//Χ������
   pool  a[3]=
   {pool(5.0,2.8,1),
   	pool(4.8,1.0,2),
   	pool(6.0,1.4,3)
   	};
 for(int I=0;I<3;I++)
 {  cout<<"��"<<I+1<<"����Ӿ�����Ϊ:"
<<(a[I].rail_length()*wldj+a[I].rail_area()*zddj)<<"Ԫ"<<endl;
 }
 system("pause");
 return 0;
}

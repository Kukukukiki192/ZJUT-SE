#include <iostream>
using namespace std;
#include "pool.hpp"
void main()
{  const double zddj=167.5;//�ߵ�����
   const double wldj=36.4;//Χ������
   double r;//��ֱ��
   double c;//�ߵ���
   pool  apool;
   cout<<"����ֱ��.�ߵ���"<<endl;
 for(int I=1;I<=5;I++)
 {  cout<<"�����"<<I<<"����Ӿ��";
    apool.build(); 
    cout<<"��"<<I<<"����Ӿ�����Ϊ:"
<<(apool.rail_length()*wldj+apool.rail_area()*zddj)<<"Ԫ"<<endl;
 }
 system("pause");
}

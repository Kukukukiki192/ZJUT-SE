//pool.cpp
#include<iostream.h>
#include"circle.h" //#include "circle_inline.h"

const float fencePrice=35.00;
const float concretePrice=5.00;

void main()
{  float radius,fenceCost,concreteCost;
   cout<<"������Ӿ�ذ뾶��";
   cin>>radius;
   circle pool(radius), poolRim(radius+3);
   fenceCost=poolRim.circumference()*fencePrice;
   concreteCost=(poolRim.area()-pool.area())*concretePrice;
   cout<<"�������ã�"<<fenceCost<<"Ԫ"<<endl;
   cout<<"�ߵ����ã�"<<concreteCost<<"Ԫ"<<endl;   
} 

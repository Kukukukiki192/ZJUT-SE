//pool.cpp
#include<iostream.h>
#include"circle.h" //#include "circle_inline.h"

const float fencePrice=35.00;
const float concretePrice=5.00;

void main()
{  float radius,fenceCost,concreteCost;
   cout<<"输入游泳池半径：";
   cin>>radius;
   circle pool(radius), poolRim(radius+3);
   fenceCost=poolRim.circumference()*fencePrice;
   concreteCost=(poolRim.area()-pool.area())*concretePrice;
   cout<<"护栏费用："<<fenceCost<<"元"<<endl;
   cout<<"走道费用："<<concreteCost<<"元"<<endl;   
} 

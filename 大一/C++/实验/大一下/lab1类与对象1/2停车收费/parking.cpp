#include "clock.h"
#include <iostream>
using namespace std;
double parkingFee(double); 
void main()
{
   clock arriveTime,leaveTime;
   double parkingTime,Fee;
   cout<<"���뿪ʼͣ����ʱ��"<<endl<<"ʱ,��,��:";
   arriveTime.set_time();
   arriveTime.show_time();
   cout<<"�����뿪��ʱ��"<<endl<<"ʱ,��,��:";
   leaveTime.set_time();
   leaveTime.show_time();
   parkingTime=leaveTime.diff(arriveTime);
   Fee=parkingFee(parkingTime);
   cout<<"�շ�:"<<Fee<<endl;
   system("pause");
}
double parkingFee(double parkingTime)
{  return 5*parkingTime;        //ͣ��һСʱ5Ԫ
}
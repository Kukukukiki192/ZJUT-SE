#include "clock.h"
#include <iostream>
using namespace std;
double parkingFee(double); 
void main()
{
   clock arriveTime,leaveTime;
   double parkingTime,Fee;
   cout<<"输入开始停车的时间"<<endl<<"时,分,秒:";
   arriveTime.set_time();
   arriveTime.show_time();
   cout<<"输入离开的时间"<<endl<<"时,分,秒:";
   leaveTime.set_time();
   leaveTime.show_time();
   parkingTime=leaveTime.diff(arriveTime);
   Fee=parkingFee(parkingTime);
   cout<<"收费:"<<Fee<<endl;
   system("pause");
}
double parkingFee(double parkingTime)
{  return 5*parkingTime;        //停车一小时5元
}
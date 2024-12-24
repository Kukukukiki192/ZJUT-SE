#include"clock.h"
#include<iostream>
using namespace std;
void clock::show_time()
{  cout<<hour<<":"<<minute<<":"<<second;
   cout<<endl;
}
void clock::set_time()
{ do{  
      cin>>hour>>minute>>second;
 }while(hour<0||hour>24||
        minute<0||minute>59||
        second<0||second>59);
}
long clock::normalize() const
{  return hour*60+minute;
}
double clock::diff(const clock& T)
{   long d=normalize()-T.normalize();
    int h=d/60,m=d%60;
    if(d<0) return 0;
    if(m<15) return h;
    if(m>=15&&m<30) return h+0.5;
    if(m>=30&&m<60) return h+1;
    return 0;
}
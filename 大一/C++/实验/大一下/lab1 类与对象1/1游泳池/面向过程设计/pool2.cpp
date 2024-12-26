#include <iostream.h>
#define pi 3.14
double fwlc(double);//围栏函数
double fzds(double,double);//走道函数
void main()
{  const double zddj=167.5;//走道单价
   const double wldj=36.4;//围栏单价
   double r;//池直径
   double c;//走道宽
   double wlc;//围栏长度
   double zds;//走道面积
   for(int I=1;I<=5;I++)
   {  cout<<"请输入第"<<I<<"号游泳池数据(直径，走道宽):";
      cin>>r>>c;
      wlc=fwlc(r);
      zds=fzds(c,r);
      cout<<"第"<<I<<"号造价为:" 
          <<(wlc*wldj+zds*zddj)<<"元"  
          <<endl;
   }
}
double fwlc(double r)
{//围栏周长
    double re;
    re=2*pi*r;
    return re;
}
double fzds(double c,double r)
{ //周道面积
    double re;
    re=pi* (r+c)*(r+c)-pi*r*r;
    return re;
}

#include <iostream.h>
#define pi 3.14
double fwlc(double);//Χ������
double fzds(double,double);//�ߵ�����
void main()
{  const double zddj=167.5;//�ߵ�����
   const double wldj=36.4;//Χ������
   double r;//��ֱ��
   double c;//�ߵ���
   double wlc;//Χ������
   double zds;//�ߵ����
   for(int I=1;I<=5;I++)
   {  cout<<"�������"<<I<<"����Ӿ������(ֱ�����ߵ���):";
      cin>>r>>c;
      wlc=fwlc(r);
      zds=fzds(c,r);
      cout<<"��"<<I<<"�����Ϊ:" 
          <<(wlc*wldj+zds*zddj)<<"Ԫ"  
          <<endl;
   }
}
double fwlc(double r)
{//Χ���ܳ�
    double re;
    re=2*pi*r;
    return re;
}
double fzds(double c,double r)
{ //�ܵ����
    double re;
    re=pi* (r+c)*(r+c)-pi*r*r;
    return re;
}

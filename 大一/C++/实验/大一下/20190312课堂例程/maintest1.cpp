#include ��ex?.hpp��
int main()
{ ex? objA(3),objB,objC(4);
  cout<<��objA:��<<objA.getx()<<endl;
   cout<<��objB:��<<objB.getx()<<endl;
  cout<<��objC:��<<objC.getx()<<endl;
  objA.setx(5);
  objB.setx(6);
  objC.setx(7);
   cout<<��objA:��<<objA.getx()<<endl;
   cout<<��objB:��<<objB.getx()<<endl;
  cout<<��objC:��<<objC.getx()<<endl;
return 0;
}

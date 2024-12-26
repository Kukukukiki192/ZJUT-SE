#include "ex1.h"//"ex2.h"
#include <iostream>
using namespace std;
int main()
{ ex1 objA(3),objB(objA),objC;//ex2
  cout<<"objA:"<<objA.getx()<<endl;
  cout<<"objB:"<<objB.getx()<<endl;
  cout<<"objC:"<<objC.getx()<<endl;
  cout<<"set objA,objB,ojbC:5,6,7."<<endl;
  objA.setx(5);
  objB.setx(6);
  objC.setx(7);
  cout<<"objA:"<<objA.getx()<<endl;
  cout<<"objB:"<<objB.getx()<<endl;
  cout<<"objC:"<<objC.getx()<<endl;
  return 0; 
 }

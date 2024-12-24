#include <iostream>
#include "class2.h"
using namespace std;

int main()
{
class1 objA(3),objB(objA),objC(4);
//class2 objA(3),objB(objA),objC(4);


cout<<objA.getx()<<endl;
cout<<objB.getx()<<endl;
cout<<objC.getx()<<endl;

objB=objC;

cout<<objB.getx()<<endl;

cout<<"set objA,objB,ojbC : 5,6,7."<<endl;
objA.setx(5);
objB.setx(6);
objC.setx(7);

cout<<objA.getx()<<endl;
cout<<objB.getx()<<endl;
cout<<objC.getx()<<endl;

return 0;
}
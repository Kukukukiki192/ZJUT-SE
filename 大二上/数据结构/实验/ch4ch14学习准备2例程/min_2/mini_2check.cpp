#include <iostream.h>

class  mini{
public:
    mini(int t):x(t){    }
    //read the data member
    int getx()const {return x;}
    void setx(int t){x=t;}
private:
    int x;
};

void main()
{
mini objA(3),objB(objA),objC(4);

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
}
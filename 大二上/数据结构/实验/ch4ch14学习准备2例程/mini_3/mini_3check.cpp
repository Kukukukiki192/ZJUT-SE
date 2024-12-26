#include <iostream.h>

class  mini{
public:
    mini(int t){ px=new int(t);   }
    //read the data member
    int getx()const {return *px;}
	void setx(int t){  *px=t;  }
private:
    int * px;
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
#include"Vehicle.h"
#include<iostream>
#include<string>
using namespace std;
class Truck:public Vehicle
{public:
	Truck(int d=0,int c=0,int t=0,string co="",double f=0,bool ca=true):
		Vehicle(d,c,t,co,f),cargo(ca){}
	void show2()
	{	show();
		if(cargo==true) cout<<"The truck is carrying cargo." <<endl;
		else cout<<"The truck is not carrying cargo." <<endl;
	}
private:
	bool cargo;
};

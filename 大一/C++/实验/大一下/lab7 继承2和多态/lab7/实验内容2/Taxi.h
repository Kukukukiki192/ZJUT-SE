#include"Vehicle.h"
#include<iostream>
#include<string>
using namespace std;
class Taxi:public Vehicle
{public:
	Taxi(int d=0,int c=0,int t=0,string co="",double f=0,bool p=true):
		Vehicle(d,c,t,co,f),passenger(p){}
	void show1()
	{	show();
		if(passenger==true) cout<<"The taxi has passengers." <<endl;
		else cout<<"The taxi has no passengers." <<endl;
	}
private:
	bool passenger;
};

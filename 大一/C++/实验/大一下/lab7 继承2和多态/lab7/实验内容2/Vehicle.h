#ifndef vehicle
#define vehicle
#include<iostream>
#include<string>
using namespace std;
class Vehicle
{public:
	Vehicle(int d=0,int c=0,int t=0,string co="",double f=0):
		door(d),cylinder(c),type(t),color(co),fuelLevel(f){}
	void show()
	{	cout<<"Number of doors:"<<door<<endl;
		cout<<"Number of cylinders:"<<cylinder<<endl;
		cout<<"Transmission type:"<<type<<endl;
		cout<<"Color:"<<color<<endl;
		cout<<"Fuel level:"<<fuelLevel<<endl;
	}
private:
	int door;
	int cylinder;
	int type;
	string color;
	double fuelLevel;
};
#endif

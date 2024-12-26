#include"Vehicle.h"
#include"Taxi.h"
#include"Truck.h"
#include<iostream>
#include<string>
using namespace std;
int main()
{	Vehicle v(2,6,3,"blue",14.6);
	Taxi ta(4,6,5,"yellow",3.3,false);
	Truck tr(2,16,8,"black",7.54,true);
	cout<<"Vehicle"<<endl;
	v.show();
	cout<<endl<<"Taxi"<<endl;
	ta.show1();
	cout<<endl<<"Truck"<<endl;
	tr.show2();
	return 0;
}


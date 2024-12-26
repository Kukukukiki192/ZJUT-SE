#include"time24.cpp"
#include "time24.h"
#include<iostream>

using namespace std;
int main()
{
	//cost of parking per hour
	const double PERHOUR_PARKING=6.00;

	//objects designate when a  car enters and leaves the garage and the total amount of parking time
	time24 enterGarage,exitGarage,parkingTime;

	//length of billing time in hours
	double billingHours;

	cout<<"Enter the times the car enters and exits the garage:";
	enterGarage.readTime();
	exitGarage.readTime();

	//evaluate the total parking time
    parkingTime=enterGarage.duration(exitGarage);//总=出-入 hh:mm

	billingHours=parkingTime.getHour() + parkingTime.getMinute()/60.0;//总 h.h 

	//output parking receipt including time of arrival,time of departure,total parking time,and cost of parking
	cout<<"Car enters at:";
	enterGarage.writeTime();
	cout<<endl;

	cout<<"Car exits at:";
	exitGarage.writeTime();
	cout<<endl;

	cout<<"Parking time:";
	parkingTime.writeTime();
	cout<<endl;

	cout<<"Cost is $ "<<billingHours*PERHOUR_PARKING<<endl;

	return 0;
}

//test data:
//Enter the times the car enters and exits the garage  8:30 11:30

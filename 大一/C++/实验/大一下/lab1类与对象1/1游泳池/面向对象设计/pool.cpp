//pool.cpp
#include<iostream>
using namespace std;
#define pi 3.14
#include "pool.hpp"
void pool::build()
{ cin>>radius>>c;                
}
double pool::rail_area()
{ return  pi*((radius+c)*(radius+c)-radius*radius);
}
double pool::rail_length()
{ return 2*pi*radius;  
}

/*
double pool::cir_area(double rv)
{ return  pi*rv*rv;  }
*/

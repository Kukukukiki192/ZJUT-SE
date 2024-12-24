#include<iostream>
using namespace std;
#define pi 3.14
#include "pool.h"
double pool::rail_area()
{ return  pi*((radius+c)*(radius+c)-radius*radius);
}
double pool::rail_length()
{ return 2*pi*radius;  
}
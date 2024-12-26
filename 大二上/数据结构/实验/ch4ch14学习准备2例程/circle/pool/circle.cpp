//circle.cpp
#include "circle.h"
const float PI=3.14159;

circle::circle(float r):radius(r)
{ }

float  circle::circumference() const
{ return   2*PI*radius;     } 

float  circle::area() const
{ return   PI*radius *radius;     } 

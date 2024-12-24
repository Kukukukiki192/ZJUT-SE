// Chapter 9 of C++ How to Program
// Debugging Problem (animal.cpp)

#include <iostream>
using std::cout;
using std::endl;

#include "animal.h"
Animal::Animal(int h,int w )
{
   height = h;
   weight = w;
}

void Animal::print() const
{
   cout << "This animal's height and weight are as follows\n"
        << "Height: " << height << "\tWeight: " << weight << endl << endl;
}

int Animal::getHeight() const { return height; }

int Animal::getWeight() const { return weight; }

void Animal::setHeight(int h ) { height = h; }

void Animal::setWeight(int w ) { weight = w; }

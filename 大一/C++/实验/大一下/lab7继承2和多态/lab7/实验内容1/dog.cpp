// Chapter 9 of C++ How to Program
// Debugging Problem (dog.cpp)

#include <iostream>

using std::cout;
using std::endl;

#include "dog.h"
Dog::Dog(int h,int w,char * n )
   : Animal( h, w )
{  strcpy( name, n ); }

void Dog::setName(const char * n ) { strcpy( name, n ); }

void Dog::Print() const
{
   cout << "The dog is named: " << name << endl;
   print();
}


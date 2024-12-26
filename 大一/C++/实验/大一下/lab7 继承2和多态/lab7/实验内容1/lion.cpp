// Chapter 9 of C++ How to Program
// Debugging Problem (lion.cpp)

#include <iostream>

using std::cout;
using std::endl;

#include "lion.h"

Lion::Lion(int h,int w )
: Animal( h, w ) { }

void Lion::Print() const
{
   cout << "This animal is a lion\n";
   print();
}


// Chapter 9 of C++ How to Program
// Debugging Problem (lion.h)

#ifndef LION_H
#define LION_H

#include "animal.h"

class Lion:public Animal
{
public:
   Lion(int = 0,int = 0 );
   void Print() const;
};

#endif


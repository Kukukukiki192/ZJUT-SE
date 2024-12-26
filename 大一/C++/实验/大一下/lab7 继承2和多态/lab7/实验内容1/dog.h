// Chapter 9 of C++ How to Program
// Debugging Problem (dog.h)

#ifndef DOG_H
#define DOG_H

#include "animal.h"

class Dog : public Animal {
public:
   Dog(int = 0,int = 0,char *= "Toto");
   void Print() const;
   void setName(const char * );
private:
	char name[30]; 
};

#endif


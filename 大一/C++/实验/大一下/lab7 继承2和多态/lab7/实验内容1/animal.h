// Chapter 9 of C++ How to Program
// Debugging Problem (animal.h)

#ifndef ANIMAL_H
#define ANIMAL_H
#include <iostream>
class Animal {
public:
   Animal(int = 0,int = 0 );
   void print() const;
   int getHeight() const;
   int getWeight() const;
   void setHeight( int );
   void setWeight( int );
private:
   int height;
   int weight;
};

#endif


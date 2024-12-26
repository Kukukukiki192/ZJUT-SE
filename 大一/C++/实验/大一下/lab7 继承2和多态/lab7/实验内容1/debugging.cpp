// Chapter 9 of C++ How to Program
// Debugging Problem (debug.cpp)

#include <iostream>

using std::cout;
using std::endl;

#include "animal.h"
#include "lion.h"
#include "dog.h"

int main()
{
   Animal a1( 0, 0 );
   Dog d1( 60, 120, "Fido" );
   Dog d2;
   Lion lion1 (45, 300 );

   a1.print();
   d1.Print();
   d2.Print();
   lion1.Print();

   a1 = d1;
   cout << "Animal 1 now has the same height and weight "
        << "as dog 1\n";
   a1.print();

   d2 = d1;
   cout << "Dog 2 now has the same height and weight "
        << "as animal 1\n";
   d2.print();

   return 0;
}


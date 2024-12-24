//Cylinder.cpp
#include "cylinder.hpp"
Cylinder::Cylinder(float x,float y,float r,float h):Circle(x,y,r),height(h)
{ }
void Cylinder::setHeight(float h)
{  height=h;}
float Cylinder::area( ) const
{   return 2*Circle::area( )+2*3.14159*radius*height;    }
float Cylinder::volume( ) const
{   return Circle::area( )*height;        }
ostream& operator<<(ostream& output,const Cylinder& cy)
{  output<<"["<<cy.getX()<<","<<cy.getY()<<"], r="<<cy.getRadius()<<", h="<<cy.getHeight();
   return output;
}

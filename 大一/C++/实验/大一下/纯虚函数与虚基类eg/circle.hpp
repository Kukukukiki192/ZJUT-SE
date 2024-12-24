#ifndef CIRCLE_H
#define CIRCLE_H
//����Circle��
#include "point.hpp"
class Circle:public Point {
public:
   Circle(float x=0,float y=0,float r=0);
   void setRadius(float);
   float getRadius( ) const;
   virtual float area( ) const;
   virtual void shapeName( ) const {cout<<"Circle:";}
   //���麯�������ٶ���
   friend ostream& operator<<(ostream&,const Circle &);
protected:
   float radius;
};
ostream& operator<<(ostream&,const Circle &);
#endif   //circle.h

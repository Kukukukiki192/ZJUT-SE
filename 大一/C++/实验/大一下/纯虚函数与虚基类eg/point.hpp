#ifndef POINT_H
#define POINT_H  //声明Point类
#include "Shape.hpp"
class Point:public Shape { //Point是Shape的公用派生类
public:
  Point(float=0,float=0);
  void setPoint(float,float);
  float getX( ) const {return x;}
  float getY( ) const {return y;}
  virtual void shapeName( ) const { cout<<"Point:";} 
  //对虚函数进行再定义
  //friend ostream& operator<<(ostream&,const Point &);
protected:
  float x,y;   };
  ostream& operator<<(ostream&,const Point &);
#endif //point.h

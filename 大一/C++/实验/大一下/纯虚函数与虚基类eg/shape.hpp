#ifndef SHAPE_H
#define SHAPE_H
#include <iostream>
using namespace std;
//�����������Shape
class Shape {
public:
	virtual float area( ) const {return 0.0;};//�麯��
   virtual float volume() const {return 0.0;} //�麯��
   virtual void shapeName() const =0; //���麯��
};
#endif //shape.h

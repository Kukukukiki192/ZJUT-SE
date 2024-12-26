#include<iostream>
using namespace std;
class Point 
{public:
	Point(float a=0,float b=0);
	void setPoint(float,float);
	float getX() const {return x;}
	float getY() const {return y;}
	friend ostream& operator<<(ostream&,const Point&);
protected:
	float x,y;
};
Point::Point(float a,float b)
{x=a; y=b;
}
void Point::setPoint(float a,float b)
{x=a; y=b;
}
ostream& operator<<(ostream& output,const Point& p)
{output<<"Point=["<<p.x<<","<<p.y<<"]"<<endl;
 return output;
}


class Circle:public Point
{public:
	Circle(float a=0,float b=0,float r=0);
	void modify_c(float);
	void moveto_c(float,float);
	friend ostream& operator<<(ostream&,const Circle&);
protected:
	float radius;
};
Circle::Circle(float a,float b,float r):Point(a,b),radius(r){}
void Circle::modify_c(float delta){radius=delta;}
void Circle::moveto_c(float a,float b){x=a; y=b;}
ostream& operator<<(ostream& output,const Circle& c)
{output<<"Circle=["<<c.x<<","<<c.y<<"],r="<<c.radius<<endl;
 return output;
}


class Square:public Point
{public:
	Square(float a=0,float b=0,float c=0);
	void modify_s(float);
	void moveto_s(float,float);
	friend ostream& operator<<(ostream&,const Square&);
protected:
	float side;
};
Square::Square(float a,float b,float c):Point(a,b),side(c){}
void Square::modify_s(float delta){side=delta;}
void Square::moveto_s(float a,float b){x=a; y=b;}
ostream& operator<<(ostream& output,const Square& s)
{output<<"Square=["<<s.x<<","<<s.y<<"],side="<<s.side<<endl;
 return output;
}


int main()
{
	Point p(4,3.3);
	cout<<"p: x="<<p.getX()<<",y="<<p.getY()<<endl;
	p.setPoint(8.5,6.8);
	cout<<"p':"<<p<<endl;
	
	Circle c(2.2,4.4,5);
	cout<<"c: x="<<c.getX()<<",y="<<c.getY()<<endl;
	c.modify_c(5.5);
	c.moveto_c(2,3.3);
	cout<<"c':"<<c<<endl;
	
	Square s(4.5,6.7,5.5);
	cout<<"s: x="<<s.getX()<<",y="<<s.getY()<<endl;
	s.modify_s(5.5);
	s.moveto_s(2,3.3);
	cout<<"s':"<<s<<endl;
	
	return 0;
}

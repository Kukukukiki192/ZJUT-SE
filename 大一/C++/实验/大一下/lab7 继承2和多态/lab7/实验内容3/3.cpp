#include<iostream>
using namespace std;
class Point{
public:
  Point(double x=0,double y=0);//有默认参数的构造函数
  void setPoint(double,double); //设置坐标值
  double getX ( ) const {return x;} //读x坐标
  double getY ( ) const {return y;} //读y坐标
  double area() const { return 0;}
  friend ostream& operator<<(ostream&,const Point &);//重载输出
protected://受保护成员
  double x;
  double y;
};

Point::Point(double a,double b) //对x,y初始化
{ x=a;y=b;
}
//设置x和y的坐标值
void Point::setPoint(double a,double b) //为x,y赋新值
{x=a;y=b;
}
//重载输出运算符
ostream& operator<<(ostream& output,const Point &p)
{
	output<<"["<<p.getX()<<" "<<p.getY()<<"]"<<endl;
	return output; 
}


class Circle:public Point
{
public:
  Circle(double x=0,double y=0,double r=0); //构造函数
  void setRadius(double); //设置半径值
  double getRadius( ) const; //读取半径值
  virtual double area ( ) const; //计算圆面积//添加了virtual后运行结果不变 
  friend ostream& operator<<(ostream&,const Circle &);
protected:
  double radius;
};

Circle::Circle(double a,double b,double r):Point(a,b),radius(r){ }

void Circle::setRadius(double r) //设置半径值
{radius=r;}

double Circle::getRadius( ) const//读取半径值
 {return radius;}

double Circle::area( ) const//计算圆面积
{return 3.14159*radius*radius;}

ostream& operator<<(ostream& output,const Circle &c)
{
	output<<"Center=["<<c.getX()<<","<<c.getY()<<"],r="<<c.getRadius()<<",area="<<c.area( )<<endl;
	return output;
}


class Cylinder:public Circle{
public:
    Cylinder (float x=0,float y=0,float r=0,float h=0);//构造函数
    void setHeight(float); //设置圆柱高
    float getHeight( ) const; //读取圆柱高
    double area( ) const; //计算圆表面积
    float volume( ) const; //计算圆柱体积
    friend ostream& operator<<(ostream&,const Cylinder&);//重载输出运算符
protected:
    float height; //圆柱高
};

Cylinder::Cylinder(float a,float b,float r,float h):Circle(a,b,r),height(h){}

void Cylinder::setHeight(float h) //设置圆柱高
{height=h;}

float Cylinder::getHeight( ) const//读取圆柱高
 {return height;} 

double Cylinder::area( ) const//计算圆柱体面积
{ return 2*Circle::area( )+2*3.14159*getRadius()*height;}
float Cylinder::volume() const //计算圆柱体体积
{return Circle::area()*height;}
//Cylinder类的实现
ostream& operator<<(ostream&output,const Cylinder& cy)
{output<<"Center=["<<cy.getX()<<","<<cy.getY()<<"],r="<<cy.getRadius()<<",h="<<cy.getHeight()<<",area="<<cy.area( )<<",volume="<<cy.volume( )<<endl;
  return output;
}


int main()
{  
   Point point(3.5,6.4), *p;
   Circle circle(4,5,6), *cir;
   Cylinder cyclinder(5,6,8), *cyl;
   cout<<point;
   cout<<circle;
   cout<<cyclinder;
   
   p=&point;
   cir=&circle;
   cyl=&cyclinder;
   cout<<(*p);
   cout<<(*cir);
   cout<<(*cyl);
  
   p=&circle;
   cout<<p->area()<<endl;
   p=&cyclinder;
   cout<<p->area()<<endl;
   Point &p1=circle; 
   cout<<p->area()<<endl;
   Point *p2;
   p2=&cyclinder;
   cout<<p2->area()<<endl;
   //没有加virtual时全调用 point的area，值为0 
   cout<<cir->area()<<endl;
   cir=&cyclinder;
   cout<<cir->area()<<endl;
   //+++++++++++++++++++
   return 0;
}



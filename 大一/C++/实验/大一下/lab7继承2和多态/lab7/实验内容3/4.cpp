#include<iostream>
using namespace std;
class Point{
public:
  Point(double x=0,double y=0);//��Ĭ�ϲ����Ĺ��캯��
  void setPoint(double,double); //��������ֵ
  double getX ( ) const {return x;} //��x����
  double getY ( ) const {return y;} //��y����
  virtual double area() const { return 0;}
  //������virtual,����Ϊpoint�ı�������ִ��point��area��䣬������virtual���ִ�и�ֵ�ı�����area��� 
  friend ostream& operator<<(ostream&,const Point &);//�������
protected://�ܱ�����Ա
  double x;
  double y;
};

Point::Point(double a,double b) //��x,y��ʼ��
{ x=a;y=b;
}
//����x��y������ֵ
void Point::setPoint(double a,double b) //Ϊx,y����ֵ
{x=a;y=b;
}
//������������
ostream& operator<<(ostream& output,const Point &p)
{
	output<<"["<<p.getX()<<" "<<p.getY()<<"]"<<endl;
	return output; 
}


class Circle:public Point
{
public:
  Circle(double x=0,double y=0,double r=0); //���캯��
  void setRadius(double); //���ð뾶ֵ
  double getRadius( ) const; //��ȡ�뾶ֵ
  double area ( ) const; //����Բ���
  friend ostream& operator<<(ostream&,const Circle &);
protected:
  double radius;
};

Circle::Circle(double a,double b,double r):Point(a,b),radius(r){ }

void Circle::setRadius(double r) //���ð뾶ֵ
{radius=r;}

double Circle::getRadius( ) const//��ȡ�뾶ֵ
 {return radius;}

double Circle::area( ) const//����Բ���
{return 3.14159*radius*radius;}

ostream& operator<<(ostream& output,const Circle &c)
{
	output<<"Center=["<<c.getX()<<","<<c.getY()<<"],r="<<c.getRadius()<<",area="<<c.area( )<<endl;
	return output;
}


class Cylinder:public Circle{
public:
    Cylinder (float x=0,float y=0,float r=0,float h=0);//���캯��
    void setHeight(float); //����Բ����
    float getHeight( ) const; //��ȡԲ����
    double area( ) const; //����Բ�����
    float volume( ) const; //����Բ�����
    friend ostream& operator<<(ostream&,const Cylinder&);//������������
protected:
    float height; //Բ����
};

Cylinder::Cylinder(float a,float b,float r,float h):Circle(a,b,r),height(h){}

void Cylinder::setHeight(float h) //����Բ����
{height=h;}

float Cylinder::getHeight( ) const//��ȡԲ����
 {return height;} 

double Cylinder::area( ) const//����Բ�������
{ return 2*Circle::area( )+2*3.14159*getRadius()*height;}
float Cylinder::volume() const //����Բ�������
{return Circle::area()*height;}
//Cylinder���ʵ��
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
   cout<<p->area()<<endl;//circle��area()
   p=&cyclinder;
   cout<<p->area()<<endl;//cylinder��area()
   Point *p1;
   p1=&circle; 
   cout<<p1->area()<<endl;//circle��area()
   Point *p2;
   p2=&cyclinder;
   cout<<p2->area()<<endl;//cylinder��area() 
   
   cout<<cir->area()<<endl;//circle��area() 
   cir=&cyclinder;
   cout<<cir->area()<<endl;//cylinder��area() 
   //+++++++++++++++++++
   return 0;
}



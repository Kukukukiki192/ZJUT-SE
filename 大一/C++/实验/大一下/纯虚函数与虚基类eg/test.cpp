#include "cylinder.hpp"
int main( )
{ Point point(3.2,4.5);
  Circle circle(2.4,1.2,5.6); 
  Cylinder cylinder(3.5,6.4,5.2,10.5); 
  point.shapeName(); //静态关联
  cout<<point<<endl;
  circle.shapeName(); //静态关联
  cout<<circle<<endl;
  cylinder.shapeName(); //静态关联
  cout<<cylinder<<endl<<endl;

 Shape* pt; //基类指针
 pt=&point; //指针指向Point类对象
 pt->shapeName( ); //动态关联
cout<<"x="<<point.getX( )<<
           ",y="<<point.getY( )<<
   "\n area="<<pt->area( )<<
"\n volume="<<pt->volume()<<"\n\n";

pt=&circle; //指向Circle类对象
pt->shapeName( ); //动态关联
cout<<"x="<<circle.getX( )<<
",y="<<circle.getY( )<<
"\n area="<<pt->area( )<<
"\n volume="<<pt->volume( )<<"\\n\\n";

pt=&cylinder; //指向Cylinder类对象
pt->shapeName( ); //动态关联
cout<<"x="<<cylinder.getX( )<<
",y="<<cylinder.getY( )<<
"\n area="<<pt->area( )<<
"\n volume="<<pt->volume( )<<"\\n\\n";
return 0;
}

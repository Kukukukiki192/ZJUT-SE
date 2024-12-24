#include "cylinder.hpp"
int main( )
{ Point point(3.2,4.5);
  Circle circle(2.4,1.2,5.6); 
  Cylinder cylinder(3.5,6.4,5.2,10.5); 
  point.shapeName(); //��̬����
  cout<<point<<endl;
  circle.shapeName(); //��̬����
  cout<<circle<<endl;
  cylinder.shapeName(); //��̬����
  cout<<cylinder<<endl<<endl;

 Shape* pt; //����ָ��
 pt=&point; //ָ��ָ��Point�����
 pt->shapeName( ); //��̬����
cout<<"x="<<point.getX( )<<
           ",y="<<point.getY( )<<
   "\n area="<<pt->area( )<<
"\n volume="<<pt->volume()<<"\n\n";

pt=&circle; //ָ��Circle�����
pt->shapeName( ); //��̬����
cout<<"x="<<circle.getX( )<<
",y="<<circle.getY( )<<
"\n area="<<pt->area( )<<
"\n volume="<<pt->volume( )<<"\\n\\n";

pt=&cylinder; //ָ��Cylinder�����
pt->shapeName( ); //��̬����
cout<<"x="<<cylinder.getX( )<<
",y="<<cylinder.getY( )<<
"\n area="<<pt->area( )<<
"\n volume="<<pt->volume( )<<"\\n\\n";
return 0;
}

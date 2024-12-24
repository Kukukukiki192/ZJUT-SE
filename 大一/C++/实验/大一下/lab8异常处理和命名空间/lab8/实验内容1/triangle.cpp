#include<iostream>
#include<cmath>
using namespace std;
double triangle(double a,double b,double c)
{double s=(a+b+c)/2;
return sqrt(s*(s-a)*(s-b)*(s-c));
}
int main() 
{double a,b,c;
 try
 {while(cin>>a>>b>>c)
  {
   if(a>0&&b>0&&c>0) 
   { if(a+b<=c||a+c<=b||b+c<=a) throw a;
  	else cout<<triangle(a,b,c)<<endl;
   }
  }
 }
 catch(double)
 {cout<<"a="<<a<<",b="<<b<<",c="<<",that is not a triangle!"<<endl;
 }
 cout<<"end"<<endl;
 return 0;
}

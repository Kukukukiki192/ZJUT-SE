#include<iostream>
#include<cmath>
#define P(a,b,c) (a+b+c)/2
#define S(a,b,c) sqrt(P(a,b,c)*(P(a,b,c)-a)*(P(a,b,c)-b)*(P(a,b,c)-c))
using namespace std;
void main()
{float S1,P1,a,b,c;//a,b,c为三角形三边长
cout<<"input a,b,c((|a-b|<c<a+b)&&(a,b,c>0):";
cin>>a>>b>>c;
P1=P(a,b,c);
S1=S(a,b,c);
cout<<"S="<<S1<<endl;
system("pause");
}

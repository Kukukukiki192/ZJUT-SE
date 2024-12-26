#include "mystring.h"
#include "mystring.cpp"
#include <iostream>
using namespace std;

int main()
{mystring a("are you sure?"),b('a'),c,d;

 if (a==b)  cout<<"×Ö·û´®aºÍ×Ö·û´®bÏàµÈ£¡"<<endl;
 else cout<<"×Ö·û´®aºÍ×Ö·û´®b²»ÏàµÈ£¡"<<endl;
 d=a;
 cout<<"ÇëÊäÈë×Ö·û´®cµÄÖµ£º";
 cin>>c;
 cout<<"a="<<a<<endl;
 cout<<b.compare(c)<<endl;
 cout<<"c="<<c<<endl;
 cout<<"d="<<d<<endl;
 cout<<c.operator [](1)<<endl;
 return 0;
}

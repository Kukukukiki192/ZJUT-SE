#include "mystring.h"
#include <iostream>

int main()
{mystring a("are you sure?"),b('a'),c,d;
char ch;
 if (a==b)  cout<<"�ַ���a���ַ���b��ȣ�"<<endl;
 else cout<<"�ַ���a���ַ���b����ȣ�"<<endl;
 d=a;
 cout<<"�������ַ���c��ֵ��";
 cin>>c;
 cout<<"a="<<a<<endl;
 cout<<b.compare(c)<<endl;
 cout<<"c="<<c<<endl;
 cout<<"d="<<d<<endl;
 cout<<c.operator [](1)<<endl;
 return 0;
}

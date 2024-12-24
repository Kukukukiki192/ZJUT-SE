#include<iostream>
#include<string>
using namespace std;
const int n=20;
void main()
{  void exchange(char a[n],char b[n]);
   char a[n],b[n],c[n];
   cout<<"输入三个字符串:";
   gets(a);gets(b);gets(c);
   if(strcmp(a,b)>0)exchange(a,b);//strcmp函数比较字符串大小
   if(strcmp(a,c)>0)exchange(a,c);
   if(strcmp(b,c)>0)exchange(b,c);
   cout<<"按从小到大排序:"<<a<<endl<<b<<endl<<c<<endl;
   system("pause");
}
void exchange(char a[n],char b[n])
{  char t[n];
   strcpy(t,a);strcpy(a,b);strcpy(b,t);/* strcpy函数把含有
'\0'结束符的字符串复制到另一个地址空间，返回值的类型为char* */
}
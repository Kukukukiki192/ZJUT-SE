#include<iostream>
#include<string>
using namespace std;
const int n=20;
void main()
{  void exchange(char a[n],char b[n]);
   char a[n],b[n],c[n];
   cout<<"���������ַ���:";
   gets(a);gets(b);gets(c);
   if(strcmp(a,b)>0)exchange(a,b);//strcmp�����Ƚ��ַ�����С
   if(strcmp(a,c)>0)exchange(a,c);
   if(strcmp(b,c)>0)exchange(b,c);
   cout<<"����С��������:"<<a<<endl<<b<<endl<<c<<endl;
   system("pause");
}
void exchange(char a[n],char b[n])
{  char t[n];
   strcpy(t,a);strcpy(a,b);strcpy(b,t);/* strcpy�����Ѻ���
'\0'���������ַ������Ƶ���һ����ַ�ռ䣬����ֵ������Ϊchar* */
}
#include<iostream>
using namespace std;
int main()
{
	char str1[]={"I really love you!"};
char str2[10]={"Me too?"};
strcpy(str1,str2);
cout<<str2<<endl;
cout<<str1<<endl;
system("pause");
return 0;
}
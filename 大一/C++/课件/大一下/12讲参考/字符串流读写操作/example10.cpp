#include <strstream>
#include <iostream>
using namespace std;
int main( )
{char c[50]="12 34 65 -23 -32 33 61 99 321 32";
int a[10],i,j,t;
cout<<"array c:"<<c<<endl;//显示字符数组中的字符串
istrstream strin(c,sizeof(c)); //建立输入串流对象strin并与字符数组c关联

for(i=0;i<10;i++) strin>>a[i]; //从字符数组c读入10个整数赋给整型数组a

cout<<"array a:";
for(i=0;i<10;i++)cout<<a[i]<<" "; //显示整型数组a各元素
cout<<endl;

for(i=0;i<9;i++) //用起泡法对数组a排序
	for(j=0;j<9-i;j++)
		if(a[j]>a[j+1]){
			t=a[j];
			a[j]=a[j+1];
			a[j+1]=t;
		}

ostrstream strout(c,sizeof(c)); //建立输出串流对象strout并与字符数组c关联
for(i=0;i<10;i++) strout<<a[i]<<" "; //将10个整数存放在字符数组c
strout<<ends; //加入′\\0′

cout<<"array c:"<<c<<endl; //显示字符数组c
return 0;
}
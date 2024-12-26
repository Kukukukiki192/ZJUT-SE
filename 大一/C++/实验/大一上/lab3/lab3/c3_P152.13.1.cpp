//用字符数组，不用strcat函数(自己写一个具有strcat函数功能的函数)
#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{int i,j;
	char str1[100],str2[100];
	cout<<"输入字符串1:"<<endl;
	gets(str1);
	cout<<"输入字符串2:"<<endl;
	gets(str2);
	for(i=0;str1[i]!='\0';i++);
	for(j=0;str2[j]!='\0';j++,i++)
	str1[i]=str2[j];
	cout<<"新字符串："<<endl;
	for(i=0;i<100&&str1[i]!='\0';i++)
	cout<<str1[i];
	cout<<endl;
    return 0;
}
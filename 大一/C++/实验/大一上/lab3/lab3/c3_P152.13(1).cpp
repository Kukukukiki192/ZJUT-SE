//���ַ����飬����strcat����(�Լ�дһ������strcat�������ܵĺ���)
#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{int i,j;
	char str1[100],str2[100];
	cout<<"�����ַ���1:"<<endl;
	gets(str1);
	cout<<"�����ַ���2:"<<endl;
	gets(str2);
	for(i=0;str1[i]!='\0';i++);
	for(j=0;str2[j]!='\0';j++,i++)
	str1[i]=str2[j];
	cout<<"���ַ�����"<<endl;
	for(i=0;i<100&&str1[i]!='\0';i++)
	cout<<str1[i];
	cout<<endl;
    return 0;
}
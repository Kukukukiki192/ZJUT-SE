#include<iostream>
#include"h.h"
using namespace std;
int a;//ȫ�ֱ���
void main()
{ int power(int);//����a^m�ĺ���
	int b=5,m;
    cout<<"��������a,m��ֵ:";
    cin>>a>>m;
    cout<<a<<"*"<<b<<"="<<a*b<<endl;
	cout<<a<<"^"<<m<<"="<<power(m)<<endl;
	system("pause");
}
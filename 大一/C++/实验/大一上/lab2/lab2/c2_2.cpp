#include<iostream>
using namespace std;
int main()
{ char c1,c2;
	cout<<"������2���ַ�c1��c2:"<<endl;
	c1=getchar();c2=getchar();cout<<"��putchar����������Ϊ��";putchar(c1);putchar(c2);putchar('\n');
	cout<<"��cout���������Ϊ:"<<c1<<c2<<endl;	
	return 0;
}
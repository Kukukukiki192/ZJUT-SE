#include<iostream>
using namespace std;
int main()
{ char c1,c2;
	cout<<"请输入2个字符c1，c2:"<<endl;
	c1=getchar();c2=getchar();cout<<"用putchar函数输出结果为：";putchar(c1);putchar(c2);putchar('\n');
	cout<<"用cout语句输出结果为:"<<c1<<c2<<endl;	
	return 0;
}
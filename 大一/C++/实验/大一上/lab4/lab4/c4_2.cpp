#include<iostream>
using namespace std;
int hcf(int x,int y)//最大公约数函数
{  int t,c;//c为余数
    if(x<y){t=x;x=y;y=t;}
	while(c=x%y)
	{x=y;y=c;}
	return y;
}
int lcd(int x,int y)//最小公倍数函数
{return x*y/hcf(x,y);}
void main()
{int x,y;
    cout<<"输入2个整数：";
	cin>>x>>y;
	cout<<"其最大公约数为："<<hcf(x,y)<<endl<<"最小公倍数为:"<<lcd(x,y)<<endl;
	system("pause");
}





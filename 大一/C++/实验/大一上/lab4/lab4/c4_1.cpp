//1.计算“斐波那契数列第n项”
#include<iostream>
using namespace std;
float F(int n)
{float c;
    if(n>2) c=F(n-1)+F(n-2);
	else c=1;
	return c;
}
int main()
{ int n;
	cout<<"你想查询的项数：";
	cin>>n;
	cout<<"F("<<n<<")="<<F(n)<<endl;
	system("pause");
}

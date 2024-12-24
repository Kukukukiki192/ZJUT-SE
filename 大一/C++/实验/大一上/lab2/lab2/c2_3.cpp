#include<iostream>
using namespace std;
int max(int x,int y,int z)
{int m,n;
	m=(x>y)?x:y;
	n=(m>z)?m:z;
	return (n);
}
int main()
{int a,b,c,d;
	cout<<"输入3个整数a,b,c:";
	cin>>a>>b>>c;
	d=max(a,b,c);
	cout<<"max="<<d<<'\n';
	return 0;
}
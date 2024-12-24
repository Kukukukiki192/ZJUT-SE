#include<iostream>
using namespace std;
int f(int n)
{
	int i,y=1;
	for(i=2;i<=n;i++)
		y+=i*i;
	return y;
}
void main()
{int n;
	cout<<"ÊäÈënÖµ:";
	cin>>n;
	cout<<"f("<<n<<")="<<f(n)<<endl;
	system("pause");
}
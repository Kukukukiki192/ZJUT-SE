#include<iostream>
using namespace std;
int main()
{int x,y,z,n;
	for(n=100;n<1000;n++)
	{x=n/100;
	 y=n%100/10;
	 z=n%10;
	 if(n==x*x*x+y*y*y+z*z*z)
	 cout<<n<<'\t';
	}
	cout<<"是水仙花数"<<endl;
	return 0;
}
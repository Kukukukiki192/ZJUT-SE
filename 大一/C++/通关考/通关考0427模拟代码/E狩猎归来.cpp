#include <iostream>
using namespace std;
void main()
{
	const int N=3;
	int i=0,n,h,z,x,y[N];
	while(i<N)
	{
		cin>>n>>h>>z;
		x=z/2-h;
		if(x>n)y[i]=1;
		else y[i]=0;
		++i;
	}
	for(i=0;i<N;++i)
	{
		if(y[i]) cout<<"yes"<<endl;
		else cout<<"no"<<endl;
	}
}
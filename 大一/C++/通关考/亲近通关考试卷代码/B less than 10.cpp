#include<iostream>
using namespace std;
int main()
{
	const int n=2;
	int a,b,i=0,x[n];
	while(i<n)
	{
		cin>>a>>b;
		cout<<endl;
		x[i++]=a+b;
	}
	for(i=0;i<n;++i)
	{
		if(x[i]>10)cout<< "Refuse"<<endl;
		else cout<<x[i]<<endl;
	}
	return 0;
}


#include<iostream>
using namespace std;
int main()
{
	const int N=7;
	int m,n,i=0,sum=0;    
	char k;
	while(i<N)
	{
		cin>>m>>k>>n;
		cout<<endl;
		if(k=='b')
		{	
			if(n>=4&&n<=10)sum+=(-m);
			else if(n>=11&&n<=17)sum+=m;
		}
		else if(k=='s')
		{
			if(n>=4&&n<=10)sum+=m;
			else if(n>=11&&n<=17)sum+=(-m);
		}
		++i;
	}
	cout<<sum<<endl;
	return 0;
}

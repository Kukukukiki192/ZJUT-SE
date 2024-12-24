#include<iostream>
using namespace std;
int main()
{
	int M,i,j,k,n=1,N=0,a[4];
	while(cin>>M)
	{
		for(i=0;i<M;++i)
		{
			for(j=0;j<4;++j)
			cin>>a[j];
			cout<<endl;
		}
		for(j=0;j<3;++j)
		{
			for(k=j+1;j<4;++j)
			{if(a[j]==a[k])++n;
			}
			if(n==2)N=1;
			else if(n==4)N=2;
		}
	}
	return 0;
}
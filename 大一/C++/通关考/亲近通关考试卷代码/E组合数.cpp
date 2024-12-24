#include<iostream>
using namespace std;
int c(int m,int n)
{
	int a[34][34];
	for(int i=0;i<34;++i)
	{a[i][0]=1;a[i][i]=1;
		for(int j=1;j<i;++j)
		a[i][j]=a[i-1][j-1]+a[i-1][j];
	}
	return a[m][n];
}
int main()
{
	const int N=2;
	int i,m,n,x[N];
	for(i=0;i<N;++i)
	{
		cin>>m>>n;
		cout<<endl;
	    x[i]=c(m,n);
	}
    for(i=0;i<N;++i) cout<<x[i]<<endl;
    return 0;
}
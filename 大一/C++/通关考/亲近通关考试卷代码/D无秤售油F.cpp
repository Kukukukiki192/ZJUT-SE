#include<iostream>
using namespace std;
int main()
{
	const int N=2;
	int n[N],i=0,j=0,a[18];
	a[0]=0.05;
	while(i<N) cin>>n[i++];
	for(i=1;i<18;++i) a[i]=a[i-1]*2;
	for(i=0;i<N;++i)
	{
		cout<<n[i]<<":"<<endl;
		display(n[i]);
	}
	return 0;
}
void display(int n)
{
	int x=n*0.05;
	
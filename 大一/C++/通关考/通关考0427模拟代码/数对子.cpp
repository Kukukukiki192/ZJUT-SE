#include<iostream>
#include<string>
using namespace std;
int main()
{	int f(string);
	int M,i,j,k,n=1,N=0,x[5];
	string a;
	for(i=0;cin>>M;++i)
	{
		for(j=0;j<M;++j)
		{
			cin>>a;
			cout<<endl;
			N+=f(a);
		}
		x[i]=N;
		N=0;
	}j=0;
	while(j<=i)cout<<x[j++]<<endl;
	return 0;
}
void sort(string a)
{
	int i,j,k;
	char t;
	for(i=0;i<3;++i)
	{k=i;
		for(j=i+1;j<4;++j)
		if(a[k]>a[j])k=j;
		t=a[i];a[i]=a[k];a[k]=t;
	}
}
int f(string a)
{
	sort(a);
	if(a[0]!=a[1]&&a[1]!=a[2]
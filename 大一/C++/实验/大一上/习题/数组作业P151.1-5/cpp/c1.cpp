//用筛法求100之内的素数
#include <iostream>
using namespace std;
int main()
{
	int i,j,n=0,a[100],b[100];
	cout<<"100之内的素数："<<endl;
	for(i=0;i<100;i++)a[i]=i+1;
	for(i=1;i<100;i++)//i是被除数
	{
		for(j=2;j<i;j++)//j是i前的除数
			if(i%j==0)break;
		if(i==j)
		{
			b[n]=i;
			n++;
		}
	}
	for(i=0;i<n;i++)cout<<b[i]<<" ";
	cout<<endl;
	return 0;
}

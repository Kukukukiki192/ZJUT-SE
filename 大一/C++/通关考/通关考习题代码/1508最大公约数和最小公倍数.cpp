#include <iostream>
using namespace std;
int f1(int a,int b)
{   int r;
	while(r=a%b)
	{a=b;b=r;
	}
	return b;
}
int f2(int a,int b)
{return (a*b)/f1(a,b);
}
int main()
{
	int a,b,i=0,n,c[20],d[20];
	while(cin>>a>>b)
	{   
		if(a==0&&b==0)break;
		c[i]=f1(a,b);
		d[i]=f2(a,b);
		i++;
	}n=i;
	for(i=0;i<n;i++)
	{cout<<c[i]+d[i]<<endl;
	}
    return 0;
}
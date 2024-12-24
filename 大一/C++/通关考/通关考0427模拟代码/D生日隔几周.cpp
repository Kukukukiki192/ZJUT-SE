#include <iostream >
#include <cmath>
using namespace std;
int main()
{const int y1=1999,m1=1,d1=1,N=5;
	int f(int,int,int);
	int i=0,y,m,d,n,x[N];
	while(i<N)
	{
		cin>>y>>m>>d;
		n=abs(f(y,m,d)-f(y1,m1,d1));
		if(n%7==0)x[i]=n/7;
		else x[i]=n/7+1;
		++i;
	}i=0;
	while(i<N)cout<<x[i++]<<endl;
	return 0;
}
int leap(int y)
{return (y%4==0&&y%100!=0)||(y%400==0);
}
int m_d(int y,int m,int d)
{
	int sum=0,a[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(m==1)sum=d;
	if(m==2)sum=d+31;
	else if(m>2)
	{for(int i=0;i<m-1;++i)sum+=a[i];sum+=d+leap(y);}
	return sum;
}
int f(int y, int m,int d)
{
	int sum=0;
	for(int i=1;i<y;++i)
	sum+=365+leap(i);
	return sum+m_d(y,m,d);
}

//2法(1)辗转相除(2)从某一数递减验证公约数
#include <iostream>
using namespace std;
int main()
{
	int n=1,N,a,b,r;
	cin>>N;
	while(n<=N)
	{
		cin>>a>>b;
		if(a<b){r=a;a=b;b=r;}
		while(r=a%b){a=b;b=r;}
	  /*int x=a;
		while(!(a%x==0&&b%x==0))x--;
		换12行,17行x替代b,删去6行r */
		cout<<"case"<<n<<":"<<b<<endl;
		n++;
	}  
    return 0;
}
// µİ¹éµ÷ÓÃ2
#include <iostream>
using namespace std;
int f(int);
void main(void)
{int i;
	cin>>i;
	f(i);
}
int f(int n)
{if(n==0)return 0;
	else
	{cout<<n%10;
		f(n/10);
	cout<<n%10;   
	return n;
	}
}
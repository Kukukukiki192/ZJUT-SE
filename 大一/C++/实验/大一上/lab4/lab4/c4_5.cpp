#include<iostream>
#include<cmath>
using namespace std;
int prime(int x)
{for(int i=2;i<=sqrt(x);++i)
	if(x%i==0)return 0;
	return 1;
}
void gotbaha(int n)
{int a,b;
    for(a=3;a<n;a++)
    if(prime(a)==1)
	{b=n-a;
	if(prime(b)==1&&b>=a)
		cout<<n<<"="<<a<<"+"<<b<<endl;
	}
}
void main()
{int n;
	cout<<"输入一个>=6的偶数n:";
    cin>>n;
    for(;n<6||(n%2)!=0;)
	{                          
        cout<<"重新输入n: ";
        cin>>n;
    }
	gotbaha(n);
	system("pause");
}
    

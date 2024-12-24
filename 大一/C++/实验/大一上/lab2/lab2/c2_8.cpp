#include<iostream>
using namespace std;
int main()
{float a=2,b=1,t=2;
	int m,n;
	for(m=1;m<20;m++)
    {
    	n=a;
    	a=a+b;
    	b=n;
    	t+=a/b;
    }
    cout<<"sum="<<t<<endl;
    return 0;
}
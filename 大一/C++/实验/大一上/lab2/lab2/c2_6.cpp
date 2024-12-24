#include<iostream>
using namespace std;
int main()
{float n=1,sum=0; //n为阶乘后的值
	int i;     
	for(i=1;i<=20;++i) 
	{n*=i;
	sum+=n;
	}
	cout<<"1!+2!+3!+4!+…+20!="<<sum<<endl;
	return 0;
}
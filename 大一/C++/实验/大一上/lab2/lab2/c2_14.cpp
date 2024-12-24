#include<iostream>
#include<iomanip>
using namespace std;
int main()
{int n;
	float a=0.01,b=0.00,c,sum=0.00;
	for(n=1;n<=30;n++)
	{
	cout<<"第"<<setw(2)<<n<<"天,";    
	sum+=a;
	cout<<"陌生人得到的钱数为："<<setiosflags(ios::fixed)<<setprecision(2)<<setw(11)<<sum<<'\t';
	a*=2;
	cout<<"第"<<setw(2)<<n<<"天,"; 
	b=100000*n;
	cout<<"富翁赢得总钱数为："<<setiosflags(ios::fixed)<<setprecision(2)<<setw(11)<<b<<endl;
	}
	cout<<'\n';
	c=sum-b;
	cout<<"30天后，陌生人得到"<<sum<<"块钱"<<endl;
	cout<<"30天后，富翁得到"<<b<<"块钱"<<endl;
	cout<<"30天后，富翁亏损"<<c<<"块钱"<<endl;
	cout<<"富翁哭哭哭哭哭了  富翁是个傻子"<<endl;
    return 0;
}
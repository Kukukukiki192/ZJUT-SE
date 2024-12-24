#include<iostream>
using namespace std;
int main()
{int i,j;//i为利润(i>=10)，j为奖金
	cout<<"当月利润=";
	cin>>i;
	if (i<=100000)j=0.1*i;
	else if (100000<i<=200000)j=10000+0.075*(i-100000);
	else if (200000<i<=400000)j=20000+0.05*(i-200000);
	else if (400000<i<=600000)j=40000+0.03*(i-400000);
    else if (600000<i<=1000000)j=60000+0.015*(i-600000);
	else j=100000+0.01*(i-1000000); 
	cout<<"应发奖金总数="<<j<<endl;
	return 0;
}
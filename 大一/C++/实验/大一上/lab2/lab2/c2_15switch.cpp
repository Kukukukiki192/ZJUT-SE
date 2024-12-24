#include<iostream>
using namespace std;
int main()
{
	long i;
	float a,b,c,d,e,x;
	cout<<"当月利润：";
	cin>>i;
	a=100000*0.1;
	b=a+100000*0.075;
	c=b+200000*0.05;
	d=c+200000*0.03;
	e=d+400000*0.015;
	switch (i/100000)
	{
	    case 0:x=i*0.1;break;
		case 1:x=a+(i-100000)*0.075;break;
		case 2:
		case 3:x=b+(i-200000)*0.05;break;
		case 4:
		case 5:x=c+(i-400000)*0.03;break;
		case 6:
		case 7:
		case 8:
		case 9:x=d+(i-600000)*0.015;break;
		default:x=e+(i-1000000)*0.01;
	}
	cout<<"应发奖金总数："<<x<<endl;
	return 0;
}
//矩形法求定积分
#include<iostream>
#include<cmath>
using namespace std;
float sin(float x)
{return sin(x);
}
float cos(float x)
{return cos(x);
}
float exp(float x)
{return exp(x);
}
float jifen(float (*p)(float),float a,float b,int n)
//a-下限,b-上限,n-梯形份数,h-每份长度(任意份的高)
{float y,h;
    y=(p(a)+p(b))/2;
    h=(b-a)/n;
    for(int i=1;i<n;i++)
		y+=p(a+i*h);
    y*=h;
	return y;
}
int main()
{float a,b,c;
	a=jifen(sin,0.0,1.0,100);
	b=jifen(cos,-1.0,1.0,100);
	c=jifen(exp,0.0,2.0,100);
	cout<<"0-1积分下sinx的值为:"<<a<<endl
		<<"-1-1积分下cosx的值为:"<<b<<endl
		<<"0-2积分下e^x的值为:"<<c<<endl;
	return 0;
	system("pause");
}




//���η��󶨻���
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
//a-����,b-����,n-���η���,h-ÿ�ݳ���(����ݵĸ�)
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
	cout<<"0-1������sinx��ֵΪ:"<<a<<endl
		<<"-1-1������cosx��ֵΪ:"<<b<<endl
		<<"0-2������e^x��ֵΪ:"<<c<<endl;
	return 0;
	system("pause");
}




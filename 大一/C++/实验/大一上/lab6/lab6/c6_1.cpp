#include<iostream>
using namespace std;
void main()
{int fun(int x,int *p);
	int x=30,i,f,*p,a[15];p=a;
    f=fun(x,p);
    cout<<"numbers in the array is:"<<endl;
    for(i=0;i<f;i++)
        cout<<*(p+i)<<'\t';
	cout<<endl;
    cout<<"n="<<f<<endl;
	system("pause");
}
int fun(int x,int *p)
{int y,n=0;
	for(y=1;y<=x/2;y+=2)
	if(x%y==0)
	{ *p++=y;n++;
	}
	return n;
}
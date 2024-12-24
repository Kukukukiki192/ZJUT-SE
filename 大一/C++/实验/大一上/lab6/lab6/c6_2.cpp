#include<iostream>
using namespace std;
void main()
{int i,j,a[3][4],(*p)[4];p=a;
    void f(int (*p)[4]);
    cout<<"请输入矩阵元素："<<endl;
	for(i=0;i<3;i++)
    for(j=0;j<4;j++)
	cin>>*(*(p+i)+j);
	f(p);
	cout<<"处理后的矩阵："<<endl;
    for(i=0;i<4;i++)
    {for(j=0;j<3;j++)
	 cout<<*(*(p+i)+j)<<" ";
	 cout<<endl;
	}
    system("pause");
}
void f(int (*p)[4])
{int i,j,t;
    for(j=0;j<4;j++)
    for(i=0;i<=j;i++)
	{t=*(*(p+i)+j);
     *(*(p+i)+j)=*(*(p+j)+i);
     *(*(p+j)+i)=t;
	}
}

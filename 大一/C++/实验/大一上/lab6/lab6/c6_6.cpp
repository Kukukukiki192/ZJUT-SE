//指针数组处理不等长的字符串排序问题
#include<iostream>
#include<iostream>
using namespace std;
void main()
{void f(char *p[]);
    int i;
	char *p[10],str[10][20];
    for(i=0;i<10;i++)p[i]=str[i];
//将第i个字符串的首地址赋给指针数组的第i个元素
	cout<<"输入10个字符串:";
	for(i=0;i<10;i++)cin>>p[i];
    f(p);
	cout<<endl;
	cout<<"排序后的字符串:";
	for(i=0;i<10;i++)cout<<p[i]<<'\t';
	system("pause");
}
void f(char *p[])
{int i,j,k;
    char *t;
	for(i=0;i<9;i++)
	{k=i;
	for(j=i+1;j<10;j++)
		if(strcmp(*(p+j),*(p+k))<0)//从小到大排序
		{k=j;
		t=*(p+i);*(p+i)=*(p+k);*(p+k)=t;
		}
	}
}
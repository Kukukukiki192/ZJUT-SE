//��һ�����ź�������飬������һ������Ҫ��ԭ������Ĺ��ɽ�������������
#include<iostream>
using namespace std;
int main()
{int a[11]={1,6,10,23,34,50,78,86,99,100};
int num,i,j;
cout<<"Enter:";
cin>>num;
for(i=0;i<10;i++)
{if(num<a[i])
	{
		for(j=9;j>=i;j--)
		a[j+1]=a[j];
		break;
	}
}
a[i]=num;
for(i=0;i<11;i++)
cout<<a[i]<<" ";
cout<<endl;
return 0;
}
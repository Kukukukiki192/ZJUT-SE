#include<iostream>
using namespace std;
void f1(int *p,int n)//����n������
{
	cout<<"����"<<n<<"������";
	for(int i=0;i<n;i++)cin>>*(p+i);
}
void f2(int *p,int n)//���д���
{int i,i_min=0,i_max=0,t,min=*p,max=*p;
	for(i=1;i<n;i++)
    {
		if(*(p+i)<*(p+i_min)){min=*(p+i);i_min=i;}
	    if(*(p+i)>*(p+i_max)){max=*(p+i);i_max=i;}
	}
	t=*p;*p=min;*(p+i_min)=t;
	t=*(p+n-1);*(p+n-1)=max;*(p+i_max)=t;
}
void f3(int *p,int n)//���n������
{   cout<<"�����Щ����:";
	for(int i=0;i<n;i++)cout<<*(p+i)<<" ";
}

void main()
{int a[100],n,*p=a;
    cout<<"���������ĸ���n:";
    cin>>n;
	f1(p,n);
	f2(p,n);
	f3(p,n);
	system("pause");
}
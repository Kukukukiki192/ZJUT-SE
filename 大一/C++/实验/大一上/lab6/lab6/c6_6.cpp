//ָ�����鴦���ȳ����ַ�����������
#include<iostream>
#include<iostream>
using namespace std;
void main()
{void f(char *p[]);
    int i;
	char *p[10],str[10][20];
    for(i=0;i<10;i++)p[i]=str[i];
//����i���ַ������׵�ַ����ָ������ĵ�i��Ԫ��
	cout<<"����10���ַ���:";
	for(i=0;i<10;i++)cin>>p[i];
    f(p);
	cout<<endl;
	cout<<"�������ַ���:";
	for(i=0;i<10;i++)cout<<p[i]<<'\t';
	system("pause");
}
void f(char *p[])
{int i,j,k;
    char *t;
	for(i=0;i<9;i++)
	{k=i;
	for(j=i+1;j<10;j++)
		if(strcmp(*(p+j),*(p+k))<0)//��С��������
		{k=j;
		t=*(p+i);*(p+i)=*(p+k);*(p+k)=t;
		}
	}
}
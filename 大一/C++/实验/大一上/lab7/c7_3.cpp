#include <iostream>
using namespace std;
struct object
{char name[20];
 float price;
 int num;
 float sum;
}obj[5];
int main()
{float sort(object obj[5]);
	int i;
	for (i=0;i<5;i++)
	{cout<<"������Ʒ��.����.��������:"<<endl;
	 cin>>obj[i].name>>obj[i].price>>obj[i].num;
	}
	sort(obj);
	system("pause");
	return 0;
}
float sort(object obj[5])
{int i,j,k;float s=0;object t;
	for (k=0;k<5;k++)
	{obj[k].sum=obj[k].price*obj[k].num;
	 s=s+obj[k].price*obj[k].num;
	}
	for(i=0;i<4;i++)
	for(j=0;j<4-i;j++)
	if(obj[j].sum<obj[j+1].sum)
	{t=obj[j];obj[j]=obj[j+1];obj[j+1]=t;}
	cout<<"���ι����嵥:"<<'\n'<<"��Ʒ"<<'\t'<<"����"<<'\t'<<"����"<<'\t'<<"�ܼ�"<<endl;
	for(i=0;i<5;i++)
		cout<<obj[i].name<<'\t'<<obj[i].price<<'\t'<<obj[i].num<<'\t'<<obj[i].sum<<endl;
	cout<<'\n'<<"Ӧ���ܼ�(Ԫ):"<<s<<endl;
	return 0;
}

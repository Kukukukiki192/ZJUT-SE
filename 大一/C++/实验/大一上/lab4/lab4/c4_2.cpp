#include<iostream>
using namespace std;
int hcf(int x,int y)//���Լ������
{  int t,c;//cΪ����
    if(x<y){t=x;x=y;y=t;}
	while(c=x%y)
	{x=y;y=c;}
	return y;
}
int lcd(int x,int y)//��С����������
{return x*y/hcf(x,y);}
void main()
{int x,y;
    cout<<"����2��������";
	cin>>x>>y;
	cout<<"�����Լ��Ϊ��"<<hcf(x,y)<<endl<<"��С������Ϊ:"<<lcd(x,y)<<endl;
	system("pause");
}





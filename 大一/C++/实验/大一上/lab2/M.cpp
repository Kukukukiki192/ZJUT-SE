#include<iostream>
using namespace std;
int main()
{int i,j;                     //iΪ����
	for(i=1;i<=10;i++)
	{
		for(j=1;j<i;j++)      //����jΪ�ո���
		cout<<" ";
		for(j=1;j<=21-2*i;++j)//����jΪM�ĸ���
		cout<<"M";
		cout<<endl;
	}
  return 0;  
}
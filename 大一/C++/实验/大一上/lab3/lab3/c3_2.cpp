#include <iostream>
using namespace std;
int main()
{int le=0,num=0,sp=0,others=0,i,j;//i-����,j-����
	char c[3][80],a;
	for(i=0;i<3;i++)
	{cout<<"�����"<<i+1<<"��:"<<endl;
	 cin.getline(c[i],80);
	}
	for(i=0;i<3;i++)
	{
		for(j=0;j<80&&(a=c[i][j])!='\0';j++)
		{
			if(a>='a'&&a<='z'||a>='A'&&a<='Z')le++;
	        else if(a>='0'&&a<='9')num++;
	        else if(a==' ')sp++;
	        else others++;
		}
	}
	cout<<"Ӣ����ĸ"<<le<<endl<<"����"<<num<<endl
	<<"�ո�"<<sp<<endl<<"�����ַ�"<<others<<endl;
    return 0;
}
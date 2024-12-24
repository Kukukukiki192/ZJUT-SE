#include <iostream>
using namespace std;
int main()
{int le=0,num=0,sp=0,others=0,i,j;//i-行数,j-列数
	char c[3][80],a;
	for(i=0;i<3;i++)
	{cout<<"输入第"<<i+1<<"行:"<<endl;
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
	cout<<"英文字母"<<le<<endl<<"数字"<<num<<endl
	<<"空格"<<sp<<endl<<"其它字符"<<others<<endl;
    return 0;
}
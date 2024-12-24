#include<iostream>
using namespace std;
int main()
{char c;
	int le=0,sp=0,num=0,other=0;
	cout<<"请输入一行字符：";
	while(cin.get(c))
	{if(c=='\n') break;
		if(c>='A'&&c<='Z'||c>='a'&&c<='z') le++;
		else if(c==' ') sp++;
		else if(c>='0'&&c<='9') num++;
		else other++;
	}
	cout<<"英文字母个数="<<le<<endl<<"空格个数="<<sp<<endl<<"数字个数="<<num<<endl<<"其他字符个数="<<other<<endl;
	return 0;
}
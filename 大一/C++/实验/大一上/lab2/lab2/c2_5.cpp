#include<iostream>
using namespace std;
int main()
{char c;
	int le=0,sp=0,num=0,other=0;
	cout<<"������һ���ַ���";
	while(cin.get(c))
	{if(c=='\n') break;
		if(c>='A'&&c<='Z'||c>='a'&&c<='z') le++;
		else if(c==' ') sp++;
		else if(c>='0'&&c<='9') num++;
		else other++;
	}
	cout<<"Ӣ����ĸ����="<<le<<endl<<"�ո����="<<sp<<endl<<"���ָ���="<<num<<endl<<"�����ַ�����="<<other<<endl;
	return 0;
}
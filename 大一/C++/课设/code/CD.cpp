#include"CD.h"
void CD::write(ofstream &fout)//写入文件 
{	static int i=1;
	cout<<"碟片名称:"; cin>>name; 
	cout<<"国家:"; cin>>country;  
	cout<<"类型:"; cin>>type;  
	fout<<i++<<" "<<name<<" "<<country<<" "<<type<<" "<<1<<endl;
	cout<<"输入完成"<<endl;
}
void CD::read(ifstream &fin)//读取文件
{	fin>>num>>name>>country>>type>>mark;	
}
int CD::find_name(string a)//查找碟片名称 
{	int b=0;
	if(name==a) ++b;
	return b;
}
int CD::find(string a)//查询碟片信息 
{	int b=0;
	if(name==a) 
	{	++b; show();
		if(mark==1) cout<<"可借阅"<<endl;
		else cout<<"已借出"<<endl;
	} return b;
}
void CD::add(int n)//写入文件 
{	
	cout<<"碟片名称:"; cin>>name; 
	cout<<"国家:"; cin>>country;  
	cout<<"类型:"; cin>>type;  
	num=n;
	cout<<"添加完成"<<endl;
}
int CD::modify(string a)//修改碟片信息 
{	int b=0;
	if(name==a) 	
	{	++b;	char c;	int i;
		show();
		cout<<"确认修改?(y/n)"<<endl; 
		cin>>c;
		if(c=='y')
	  {	cout<<"1.碟片名称 2.国家 3.类型 4.退出修改"<<endl; 
		do{ cout<<"请选择你要修改的碟片信息(1-4):"<<endl;
			cin>>i;	
			if(i!=4) 
			{	cout<<"请输入新的信息:";
				switch(i)
				{case 1: cin>>name; break;
				 case 2: cin>>country; break;
				 case 3: cin>>type; break;
				 default: cout<<"输入错误"<<endl; break;
				}
			}
		}while(i!=4);
		cout<<"修改成功"<<endl;
	  }
	}return b;
} 
int CD::delet(string a)//删除碟片信息 
{	int b=0;
	if(name==a) 
	{	++b;	
		show();
	}return b;
}

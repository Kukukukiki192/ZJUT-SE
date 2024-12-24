#ifndef CD_h
#define CD_h
#include<string>
#include<iostream>
#include<fstream>
#include<string>
using namespace std;
class CD//影碟信息类
{private:	
	int num;//碟片编号 
	string name;//碟片名称
	string country;//国家
	string type;//类型
	int mark;//借阅标记:1-可借阅 0-已借出
public:
	CD(string nam="null",string countr="null",string typ="null",int mar=0)://初始化碟片信息 
	name(nam),country(countr),type(typ),mark(mar){}
	void show()//显示碟片信息 
	{	cout<<num<<endl;
		cout<<"碟片名称："<<name<<endl;
		cout<<"国家："<<country<<endl;
		cout<<"类型："<<type<<endl;
		cout<<"借阅标记："<<mark<<endl<<endl;
	}
	void showtxt(ofstream &fout)
	{fout<<num<<" "<<name<<" "<<country<<" "<<type<<" "<<mark<<endl;
	}
	int gnum(){return num;}//获取编号 
	string gname(){return name;}//获取碟片名称 
	int gmark(){return mark;}// 获取碟片借阅标记 
	void smark(int a){mark=a;}//修改碟片借阅标记 
	void snum(int a){num=a;}//修改碟片编号 
	
	void write(ofstream &);//写入文件 
	void read(ifstream &);//读取信息 
	int find_name(string);//查找碟片名称 
	int find(string);//查询碟片信息 
	void add(int);//添加碟片信息 
	int modify(string);//修改碟片信息 
	int delet(string);//删除碟片信息 
};
#endif

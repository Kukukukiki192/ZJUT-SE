#ifndef CD_h
#define CD_h
#include<string>
#include<iostream>
#include<fstream>
#include<string>
using namespace std;
class CD//Ӱ����Ϣ��
{private:	
	int num;//��Ƭ��� 
	string name;//��Ƭ����
	string country;//����
	string type;//����
	int mark;//���ı��:1-�ɽ��� 0-�ѽ��
public:
	CD(string nam="null",string countr="null",string typ="null",int mar=0)://��ʼ����Ƭ��Ϣ 
	name(nam),country(countr),type(typ),mark(mar){}
	void show()//��ʾ��Ƭ��Ϣ 
	{	cout<<num<<endl;
		cout<<"��Ƭ���ƣ�"<<name<<endl;
		cout<<"���ң�"<<country<<endl;
		cout<<"���ͣ�"<<type<<endl;
		cout<<"���ı�ǣ�"<<mark<<endl<<endl;
	}
	void showtxt(ofstream &fout)
	{fout<<num<<" "<<name<<" "<<country<<" "<<type<<" "<<mark<<endl;
	}
	int gnum(){return num;}//��ȡ��� 
	string gname(){return name;}//��ȡ��Ƭ���� 
	int gmark(){return mark;}// ��ȡ��Ƭ���ı�� 
	void smark(int a){mark=a;}//�޸ĵ�Ƭ���ı�� 
	void snum(int a){num=a;}//�޸ĵ�Ƭ��� 
	
	void write(ofstream &);//д���ļ� 
	void read(ifstream &);//��ȡ��Ϣ 
	int find_name(string);//���ҵ�Ƭ���� 
	int find(string);//��ѯ��Ƭ��Ϣ 
	void add(int);//��ӵ�Ƭ��Ϣ 
	int modify(string);//�޸ĵ�Ƭ��Ϣ 
	int delet(string);//ɾ����Ƭ��Ϣ 
};
#endif

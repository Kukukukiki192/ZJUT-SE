#include"CD.h"
void CD::write(ofstream &fout)//д���ļ� 
{	static int i=1;
	cout<<"��Ƭ����:"; cin>>name; 
	cout<<"����:"; cin>>country;  
	cout<<"����:"; cin>>type;  
	fout<<i++<<" "<<name<<" "<<country<<" "<<type<<" "<<1<<endl;
	cout<<"�������"<<endl;
}
void CD::read(ifstream &fin)//��ȡ�ļ�
{	fin>>num>>name>>country>>type>>mark;	
}
int CD::find_name(string a)//���ҵ�Ƭ���� 
{	int b=0;
	if(name==a) ++b;
	return b;
}
int CD::find(string a)//��ѯ��Ƭ��Ϣ 
{	int b=0;
	if(name==a) 
	{	++b; show();
		if(mark==1) cout<<"�ɽ���"<<endl;
		else cout<<"�ѽ��"<<endl;
	} return b;
}
void CD::add(int n)//д���ļ� 
{	
	cout<<"��Ƭ����:"; cin>>name; 
	cout<<"����:"; cin>>country;  
	cout<<"����:"; cin>>type;  
	num=n;
	cout<<"������"<<endl;
}
int CD::modify(string a)//�޸ĵ�Ƭ��Ϣ 
{	int b=0;
	if(name==a) 	
	{	++b;	char c;	int i;
		show();
		cout<<"ȷ���޸�?(y/n)"<<endl; 
		cin>>c;
		if(c=='y')
	  {	cout<<"1.��Ƭ���� 2.���� 3.���� 4.�˳��޸�"<<endl; 
		do{ cout<<"��ѡ����Ҫ�޸ĵĵ�Ƭ��Ϣ(1-4):"<<endl;
			cin>>i;	
			if(i!=4) 
			{	cout<<"�������µ���Ϣ:";
				switch(i)
				{case 1: cin>>name; break;
				 case 2: cin>>country; break;
				 case 3: cin>>type; break;
				 default: cout<<"�������"<<endl; break;
				}
			}
		}while(i!=4);
		cout<<"�޸ĳɹ�"<<endl;
	  }
	}return b;
} 
int CD::delet(string a)//ɾ����Ƭ��Ϣ 
{	int b=0;
	if(name==a) 
	{	++b;	
		show();
	}return b;
}

#include"AVL.h"
#include<fstream>
#include<string>
#include<iostream>
using namespace std;

int main(){
	string a,b,c;
	AVL user;
	ofstream fout("user.txt");
	ifstream fin("info.txt");
	while(fin>>a>>b){ //��!fin.eof()����һ���û������ظ� 
		user.add(a,b);
	}
	fin.close();
	
	system("cls");
	int i=1,i1,i2;
	while(i){system("cls");	i1=1;
		cout<<"|              �û���¼ģ��ϵͳ                  |"<<endl;
		cout<<"|������������������������������������������������|"<<endl;
		cout<<"|               1.ע��                           |"<<endl;
		cout<<"|               2.��¼                           |"<<endl;		
		cout<<"|               3.�˳�                           |"<<endl;
		cout<<"|������������������������������������������������|"<<endl;
		cout<<"��ѡ��(1-3):"<<endl;
		cin>>i;
		system("cls");
		switch(i){
			case 1: while(i1){
						cout<<"�û���(��1-10λ���ֻ���ĸ���):";
						cin>>a;
						cout<<"����(��6-10λ���ֻ���ĸ���):";
						cin>>b;	
						if(!user.check(a,b)) {//a,b����Ƿ�
							cout<<"����Ƿ�,����������"<<endl;
							continue;
						}
						user.insert(a,b);//a,b����Ϸ� ����û�
						cout<<"��������������:";	
						cin>>i1;
						i1=0;											 
					}break;
			case 2: while(i1){	
						cout<<"�û���(��1-10λ���ֻ���ĸ���):";
						cin>>a;
						cout<<"����(��6-10λ���ֻ���ĸ���):";
						cin>>b;	
						if(!user.search(a,b)) {//��֤ʧ��(���û�������)
							cout<<"�û������������,��ѡ��(1-2): 1.�������� 2.�˳�"<<endl; 
							int t; cin>>t;
							if(t==1) continue;
							else break;
						}
						//��֤�ɹ�(���û�����),�����½���
					 	while(i1){system("cls");i2=1;
						 	cout<<"��¼�ɹ�"<<endl;
				 			cout<<"1.ɾ���û�"<<endl;
							cout<<"2.�޸��û���"<<endl;
		    				cout<<"3.�����û�����"<<endl;
							cout<<"4.�˳�"<<endl;
							cout<<"��ѡ��(1-4):";
							cin>>i1;
							system("cls");
				 			switch(i1){
						 		case 1:while(i2){char x;
						 				cout<<"ȷ��ɾ��?(Y/N)"; cin>>x;
						 				if(x=='Y'){
								 			user.remove(a);
							 				cout<<"ɾ���û��ɹ�,����������������ҳ��:";
											cin>>i2;
											i2=0; i1=0;
											}
										else if(x=='N'){
											cout<<"��������������:";
											cin>>i2;
											i2=0; 
											}
										else continue;
										}break;
								case 2:while(i2){
										cout<<"���û���(��1-10λ���ֻ���ĸ���):";
										cin>>c; 
										if(!user.check(c,b)) {
											cout<<"����Ƿ�,����������"<<endl;
											continue;
										}
								 		user.remove(a);
								 		a=c;
								 		user.add(c,b);
							 			cout<<"�޸��û����ɹ�,��������������:";
										cin>>i2;
										i2=0;
										}break;
								case 3:while(i2){
										cout<<"������(��6-10λ���ֻ���ĸ���):";
										cin>>c;
										if(!user.check(a,c)) {
											cout<<"����Ƿ�,����������"<<endl;
											continue;
										}
								 		user.modify(a,c);
							 			cout<<"�����û�����ɹ�,��������������:";
										cin>>i2;
										i2=0;
										}break;
								case 4:i1=0;break;
								default:i1=1;break;
							}													
						}
					}break;
			case 3: i=0;break;
			default:i=1;break;
		}
	}
	fout<<"�޸ĺ����Ϣ:"<<endl;
	user.save(fout);
	fout.close();	 
	
	cout<<"�û���Ϣ����ͼ(����):"<<endl;
	user.graph(cout);
	cout<<"ллʹ��"<<endl;
	return 0;
}

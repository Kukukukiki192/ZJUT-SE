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
	while(fin>>a>>b){ //用!fin.eof()总有一个用户输入重复 
		user.add(a,b);
	}
	fin.close();
	
	system("cls");
	int i=1,i1,i2;
	while(i){system("cls");	i1=1;
		cout<<"|              用户登录模拟系统                  |"<<endl;
		cout<<"|————————————————————————|"<<endl;
		cout<<"|               1.注册                           |"<<endl;
		cout<<"|               2.登录                           |"<<endl;		
		cout<<"|               3.退出                           |"<<endl;
		cout<<"|————————————————————————|"<<endl;
		cout<<"请选择(1-3):"<<endl;
		cin>>i;
		system("cls");
		switch(i){
			case 1: while(i1){
						cout<<"用户名(由1-10位数字或字母组成):";
						cin>>a;
						cout<<"密码(由6-10位数字或字母组成):";
						cin>>b;	
						if(!user.check(a,b)) {//a,b输入非法
							cout<<"输入非法,请重新输入"<<endl;
							continue;
						}
						user.insert(a,b);//a,b输入合法 添加用户
						cout<<"输入任意数返回:";	
						cin>>i1;
						i1=0;											 
					}break;
			case 2: while(i1){	
						cout<<"用户名(由1-10位数字或字母组成):";
						cin>>a;
						cout<<"密码(由6-10位数字或字母组成):";
						cin>>b;	
						if(!user.search(a,b)) {//验证失败(该用户不存在)
							cout<<"用户名或密码错误,请选择(1-2): 1.重新输入 2.退出"<<endl; 
							int t; cin>>t;
							if(t==1) continue;
							else break;
						}
						//验证成功(该用户存在),进入新界面
					 	while(i1){system("cls");i2=1;
						 	cout<<"登录成功"<<endl;
				 			cout<<"1.删除用户"<<endl;
							cout<<"2.修改用户名"<<endl;
		    				cout<<"3.更新用户密码"<<endl;
							cout<<"4.退出"<<endl;
							cout<<"请选择(1-4):";
							cin>>i1;
							system("cls");
				 			switch(i1){
						 		case 1:while(i2){char x;
						 				cout<<"确认删除?(Y/N)"; cin>>x;
						 				if(x=='Y'){
								 			user.remove(a);
							 				cout<<"删除用户成功,输入任意数返回主页面:";
											cin>>i2;
											i2=0; i1=0;
											}
										else if(x=='N'){
											cout<<"输入任意数返回:";
											cin>>i2;
											i2=0; 
											}
										else continue;
										}break;
								case 2:while(i2){
										cout<<"新用户名(由1-10位数字或字母组成):";
										cin>>c; 
										if(!user.check(c,b)) {
											cout<<"输入非法,请重新输入"<<endl;
											continue;
										}
								 		user.remove(a);
								 		a=c;
								 		user.add(c,b);
							 			cout<<"修改用户名成功,输入任意数返回:";
										cin>>i2;
										i2=0;
										}break;
								case 3:while(i2){
										cout<<"新密码(由6-10位数字或字母组成):";
										cin>>c;
										if(!user.check(a,c)) {
											cout<<"输入非法,请重新输入"<<endl;
											continue;
										}
								 		user.modify(a,c);
							 			cout<<"更新用户密码成功,输入任意数返回:";
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
	fout<<"修改后的信息:"<<endl;
	user.save(fout);
	fout.close();	 
	
	cout<<"用户信息的树图(横向):"<<endl;
	user.graph(cout);
	cout<<"谢谢使用"<<endl;
	return 0;
}

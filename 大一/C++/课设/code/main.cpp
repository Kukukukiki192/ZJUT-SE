#include"CD.cpp"
#include"Rent.h"
#include<fstream>
#include<iostream>
#include<string>
using namespace std;
int main()
{
	CD cd[1000],cdd;
	Rent rent[1000];
	int i=0,fh,i1,y,j,k;
	int n=0,r=0;
	string x; 
	ofstream fout("CD.txt");
	ifstream fin("CD.txt");
	system("cls");
	while(i!=-1)
	{	i1=0,fh=0;
		cout<<"|             欢迎使用影碟出租系统               |"<<endl;
		cout<<"|————————————————————————|"<<endl;
		cout<<"|               1.碟片信息                       |"<<endl;
		cout<<"|               2.碟片查询                       |"<<endl;
		cout<<"|               3.碟片借阅                       |"<<endl;
		cout<<"|               4.碟片归还                       |"<<endl; 
		cout<<"|               5.显示所有碟片信息               |"<<endl;
		cout<<"|————————————————————————|"<<endl;
		cout<<"请选择1-5,输入-1结束:"<<endl;
		cin>>i;
		system("cls");
		switch(i)
		{case 1: 	system("cls");
					while(i1!=-1)
				 {	fh=0;
				 	cout<<"1.录入碟片信息"<<endl;
					cout<<"2.添加碟片信息"<<endl;
		    		cout<<"3.修改碟片信息"<<endl;
					cout<<"4.删除碟片信息"<<endl;
					cout<<"请选择1-4,输入-1返回上层结构:"<<endl;
					cin>>i1;
					system("cls");
				 	switch(i1)
					{	case 1: while(fh!=-1)
							   	{	cout<<"输入要录入的碟片信息"<<endl;
							   		cdd.write(fout);//将添加的碟片信息写入文件 
									cd[n++].read(fin); //读取信息
					 				cout<<"输入任意数字返回"<<endl;
			         				cin>>fh;system("cls");
                     				fh=-1;
								}break;
						case 2:	 while(fh!=-1)
							   	{	cout<<"输入要添加的碟片信息"<<endl;
							   		cd[n].add(n+1);n++;
					 				cout<<"输入任意数字返回"<<endl;
			         				cin>>fh;system("cls");
                     				fh=-1;
                     				n=cd[n-1].gnum();
								}break;	
			 			case 3:while(fh!=-1)
								{	cout<<"输入要修改的碟片名称:";	cin>>x; 
									for(j=0;j<n;j++)
									{	y=cd[j].modify(x);
										if(y) break;
									}if(y==0) cout<<"无此片"<<endl;
						 			cout<<"输入任意数字返回"<<endl;
			        	 			cin>>fh;system("cls");
                    				fh=-1;
								} break;
			 			case 4:while(fh!=-1)
								{	cout<<"输入要删除的碟片名称:";	cin>>x;
									for(j=0;j<n;j++)
									{	y=cd[j].delet(x);
										if(y) break;
									}if(y==0) cout<<"无此片"<<endl;
									else{	cout<<"确认删除?(y/n)"<<endl; 
											char c;		cin>>c;
											if(c=='y')
											{for(int k=j+1;k<n;k++)
 											 {cd[k-1]=cd[k];	cd[k-1].snum(cd[k].gnum()-1);	n--;}
											 cout<<"删除成功"<<endl;
											 } 
										}
					 				cout<<"输入任意数字返回"<<endl;
			         				cin>>fh;system("cls");
                     				fh=-1;
								} break;
			 			case -1:{i1=-1; system("cls");} break;
						default: {cout<<"输入错误"<<endl;system("cls");}  break;	
					}
				 } break;
		case 2: while(fh!=-1)
				{	cout<<"输入要查询的碟片名称:";	cin>>x;	
					for(j=0;j<n;j++)
					{	y=cd[j].find(x);
						if(y) break;
					}if(y==0) cout<<"无此片"<<endl;
			 		cout<<"输入任意数字返回"<<endl;
					cin>>fh;system("cls");
             		fh=-1;
				} break;
		case 3: while(fh!=-1)
				{
					cout<<"输入会员名:"; cin>>x; rent[r].smemName(x);
					cout<<"请输入要借阅的碟片名称:" ;  cin>>x; 
					for(j=0;j<n;j++)
					{	y=cd[j].find_name(x);
						if(y) break;
					}
					if(y) 
					{	rent[r].sCDname(x);
						cout<<"请输入借阅日期(yyyy mm dd):";
	 					rent[r].cinboDate();
	 					cd[j].smark(0); 
					}
					else cout<<"无此片"<<endl;
					r++;
			 		cout<<"输入任意数字返回"<<endl;
			 		cin>>fh;system("cls");
            		fh=-1;
				} break;
		case 4: while(fh!=-1)
				{
					cout<<"输入会员名:"; cin>>x;
					for(j=0;j<r;j++)
					{	y=rent[j].find_name(x);
						if(y) break;
					}
					if(y)  
					{	cout<<"请输入要归还的碟片名称:";  cin>>x;
						if(rent[j].gCDname()==x)
						{	cout<<"请输入归还日期(yyyy mm dd):";
	 						rent[j].cinreDate();
	 						for(k=0;k<n;k++)
							{	y=cd[k].find_name(x);
								if(y) break;
							} cd[k].smark(1);
							cout<<"租金:"<<rent[j].grental()<<"元"<<endl;
						}
						else cout<<"无此片/该片已归还"<<endl;
					}
					else cout<<"无此会员"<<endl;
			 		cout<<"输入任意数字返回"<<endl;
			 		cin>>fh;system("cls");
            		fh=-1;
				} break;
		case 5: while(fh!=-1)
				{	for(j=0;j<n;j++) cd[j].show();	
			 		cout<<"输入任意数字返回"<<endl;
			 		cin>>fh;system("cls");
            		fh=-1;
				} break;
		case -1: {i=-1; system("cls");}break;
		default: {cout<<"输入错误"<<endl; system("cls");} break;	
		}
	}
	fout<<"修改后的信息:"<<endl;
	for(j=0;j<n;j++) cd[j].showtxt(fout);
	fout.close();	fin.close(); 
	cout<<"谢谢使用"<<endl;
	return 0;
}

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
		cout<<"|             ��ӭʹ��Ӱ������ϵͳ               |"<<endl;
		cout<<"|������������������������������������������������|"<<endl;
		cout<<"|               1.��Ƭ��Ϣ                       |"<<endl;
		cout<<"|               2.��Ƭ��ѯ                       |"<<endl;
		cout<<"|               3.��Ƭ����                       |"<<endl;
		cout<<"|               4.��Ƭ�黹                       |"<<endl; 
		cout<<"|               5.��ʾ���е�Ƭ��Ϣ               |"<<endl;
		cout<<"|������������������������������������������������|"<<endl;
		cout<<"��ѡ��1-5,����-1����:"<<endl;
		cin>>i;
		system("cls");
		switch(i)
		{case 1: 	system("cls");
					while(i1!=-1)
				 {	fh=0;
				 	cout<<"1.¼���Ƭ��Ϣ"<<endl;
					cout<<"2.��ӵ�Ƭ��Ϣ"<<endl;
		    		cout<<"3.�޸ĵ�Ƭ��Ϣ"<<endl;
					cout<<"4.ɾ����Ƭ��Ϣ"<<endl;
					cout<<"��ѡ��1-4,����-1�����ϲ�ṹ:"<<endl;
					cin>>i1;
					system("cls");
				 	switch(i1)
					{	case 1: while(fh!=-1)
							   	{	cout<<"����Ҫ¼��ĵ�Ƭ��Ϣ"<<endl;
							   		cdd.write(fout);//����ӵĵ�Ƭ��Ϣд���ļ� 
									cd[n++].read(fin); //��ȡ��Ϣ
					 				cout<<"�����������ַ���"<<endl;
			         				cin>>fh;system("cls");
                     				fh=-1;
								}break;
						case 2:	 while(fh!=-1)
							   	{	cout<<"����Ҫ��ӵĵ�Ƭ��Ϣ"<<endl;
							   		cd[n].add(n+1);n++;
					 				cout<<"�����������ַ���"<<endl;
			         				cin>>fh;system("cls");
                     				fh=-1;
                     				n=cd[n-1].gnum();
								}break;	
			 			case 3:while(fh!=-1)
								{	cout<<"����Ҫ�޸ĵĵ�Ƭ����:";	cin>>x; 
									for(j=0;j<n;j++)
									{	y=cd[j].modify(x);
										if(y) break;
									}if(y==0) cout<<"�޴�Ƭ"<<endl;
						 			cout<<"�����������ַ���"<<endl;
			        	 			cin>>fh;system("cls");
                    				fh=-1;
								} break;
			 			case 4:while(fh!=-1)
								{	cout<<"����Ҫɾ���ĵ�Ƭ����:";	cin>>x;
									for(j=0;j<n;j++)
									{	y=cd[j].delet(x);
										if(y) break;
									}if(y==0) cout<<"�޴�Ƭ"<<endl;
									else{	cout<<"ȷ��ɾ��?(y/n)"<<endl; 
											char c;		cin>>c;
											if(c=='y')
											{for(int k=j+1;k<n;k++)
 											 {cd[k-1]=cd[k];	cd[k-1].snum(cd[k].gnum()-1);	n--;}
											 cout<<"ɾ���ɹ�"<<endl;
											 } 
										}
					 				cout<<"�����������ַ���"<<endl;
			         				cin>>fh;system("cls");
                     				fh=-1;
								} break;
			 			case -1:{i1=-1; system("cls");} break;
						default: {cout<<"�������"<<endl;system("cls");}  break;	
					}
				 } break;
		case 2: while(fh!=-1)
				{	cout<<"����Ҫ��ѯ�ĵ�Ƭ����:";	cin>>x;	
					for(j=0;j<n;j++)
					{	y=cd[j].find(x);
						if(y) break;
					}if(y==0) cout<<"�޴�Ƭ"<<endl;
			 		cout<<"�����������ַ���"<<endl;
					cin>>fh;system("cls");
             		fh=-1;
				} break;
		case 3: while(fh!=-1)
				{
					cout<<"�����Ա��:"; cin>>x; rent[r].smemName(x);
					cout<<"������Ҫ���ĵĵ�Ƭ����:" ;  cin>>x; 
					for(j=0;j<n;j++)
					{	y=cd[j].find_name(x);
						if(y) break;
					}
					if(y) 
					{	rent[r].sCDname(x);
						cout<<"�������������(yyyy mm dd):";
	 					rent[r].cinboDate();
	 					cd[j].smark(0); 
					}
					else cout<<"�޴�Ƭ"<<endl;
					r++;
			 		cout<<"�����������ַ���"<<endl;
			 		cin>>fh;system("cls");
            		fh=-1;
				} break;
		case 4: while(fh!=-1)
				{
					cout<<"�����Ա��:"; cin>>x;
					for(j=0;j<r;j++)
					{	y=rent[j].find_name(x);
						if(y) break;
					}
					if(y)  
					{	cout<<"������Ҫ�黹�ĵ�Ƭ����:";  cin>>x;
						if(rent[j].gCDname()==x)
						{	cout<<"������黹����(yyyy mm dd):";
	 						rent[j].cinreDate();
	 						for(k=0;k<n;k++)
							{	y=cd[k].find_name(x);
								if(y) break;
							} cd[k].smark(1);
							cout<<"���:"<<rent[j].grental()<<"Ԫ"<<endl;
						}
						else cout<<"�޴�Ƭ/��Ƭ�ѹ黹"<<endl;
					}
					else cout<<"�޴˻�Ա"<<endl;
			 		cout<<"�����������ַ���"<<endl;
			 		cin>>fh;system("cls");
            		fh=-1;
				} break;
		case 5: while(fh!=-1)
				{	for(j=0;j<n;j++) cd[j].show();	
			 		cout<<"�����������ַ���"<<endl;
			 		cin>>fh;system("cls");
            		fh=-1;
				} break;
		case -1: {i=-1; system("cls");}break;
		default: {cout<<"�������"<<endl; system("cls");} break;	
		}
	}
	fout<<"�޸ĺ����Ϣ:"<<endl;
	for(j=0;j<n;j++) cd[j].showtxt(fout);
	fout.close();	fin.close(); 
	cout<<"ллʹ��"<<endl;
	return 0;
}

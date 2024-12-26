#include<iostream>
#include<fstream>
using namespace std;
struct student
{	char name[20];
	int age;
	int score[3];
	float aver;
	int rank;
};
int main()
{	int i,j;
	student stud[10],t;
	//ASCII文件读入
	ifstream fin("student.txt");
	if(!fin) {cerr<<"open error!"<<endl; exit(1);}
	for(i=0;i<10;i++)
	{
		fin.get(stud[i].name,7,' ');
		fin>>stud[i].age;
		for(j=0;j<3;j++)
			fin>>stud[i].score[j];
		char a; fin.get(a);
	}
 	fin.close();
	//写入二进制文件
	ofstream fout("student_sort.dat",ios::binary);
	if(!fout) {cerr<<"open error!"<<endl; abort();}
	for(i=0;i<10;i++)
		fout.write((char*)&stud[i],sizeof(stud[i]));
	fout.close();
	//二进制文件读入
	fin.open("student_sort.dat",ios::binary);
	if(!fin) {cerr<<"open error!"<<endl; abort();}
	for(i=0;i<10;i++)
		fin.read((char*)&stud[i],sizeof(stud[i]));
	fin.close();
	//平均分.排名 
	for(i=0;i<10;i++)
		stud[i].aver=(stud[i].score[0]+stud[i].score[1]+stud[i].score[2])/3;
 	for(i=0;i<9;i++)
 	for(j=i+1;j<10;j++)
 	{if(stud[i].aver<stud[j].aver) 
	 {t=stud[i]; stud[i]=stud[j]; stud[j]=t; }
	}
	for(i=0;i<10;i++) stud[i].rank=i+1;
	//ASCII文件输出 
	fout.open("student_sort.txt");
	if(!fout)
	{
		cerr<<"open error!"<<endl;
		exit(1);
	}
	for(i=0;i<10;i++)
	{//输出到文件 
	fout<<stud[i].name<<'\t'
		<<stud[i].age<<'\t'
		<<stud[i].score[0]<<'\t'
		<<stud[i].score[1]<<'\t'
		<<stud[i].score[2]<<'\t'
		<<stud[i].aver<<'\t'
		<<stud[i].rank<<endl;
	//输出到屏幕 
	cout<<stud[i].name<<'\t'
		<<stud[i].age<<'\t'
		<<stud[i].score[0]<<'\t'
		<<stud[i].score[1]<<'\t'
		<<stud[i].score[2]<<'\t'
		<<stud[i].aver<<'\t'
		<<stud[i].rank<<endl;
	} 
	fout.close();
	return 0;
}
	


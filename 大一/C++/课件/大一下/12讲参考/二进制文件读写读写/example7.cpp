//将example6以二进制形式存放在磁盘文件中的数据读入内存并在显示器上显示。
#include <fstream>
#include <iostream>
#include <string>
using namespace std;
struct student
{string name;
int num;
int age;
char sex;
};
int main( )
{student stud[3];
int i;
ifstream infile("stud.txt",ios::binary);
if(!infile)
{
cerr<<"open error!"<<endl;
abort( );
}
for(i=0;i<3;i++)
infile.read((char*)&stud[i],sizeof(stud[i]));
infile.close( );
for(i=0;i<3;i++)
{
cout<<"NO."<<i+1<<endl;
cout<<"name:"<<stud[i].name<<endl;
cout<<"num:"<<stud[i].num<<endl;
cout<<"age:"<<stud[i].age<<endl;
cout<<"sex:"<<stud[i].sex<<endl<<endl;
}
return 0;
}
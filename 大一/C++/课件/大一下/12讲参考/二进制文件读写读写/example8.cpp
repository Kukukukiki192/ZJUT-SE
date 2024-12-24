#include <fstream>
#include <iostream>
#include <cstring>
using namespace std;
struct student
{
int num;
char name[20];
float score;
};
int main( )
{student stud[5]={1001,"Li",85,1002,"Fun",97.5,1004,"Wang",54,1006,"Tan",76.5,1010,"ling",96};
fstream iofile("c:\\stud.txt",ios::in|ios::out|ios::binary);
//用fstream类定义输入输出二进制文件流对象iofile,有读工作，必须文件存在。所以先在对应位置新建空文件。

/*注意：对二进制文件的操作也需要先打开文件，用完后要关闭文件。
在打开时要用ios::binary指定为以二进制形式传送和存储。
二进制文件除了可以作为输入文件或输出文件外,还可以是既能输入又能输出的文件。这是和ASCII文件不同的地方。*/

if(!iofile)
{
cerr<<"open error!"<<endl;
abort( );
}

for(int i=0;i<5;i++)//向磁盘文件输出5个学生的数据
   iofile.write((char*)&stud[i],sizeof(stud[i]));
/*循环可以使用单一语句：outfile.write((char*)&stud[0],sizeof(stud)); 代替*/


student stud1[5]; //用来存放从磁盘文件读入的数据
for(int i=0;i<5;i=i+2)
{
iofile.seekg(i*sizeof(stud[i]),ios::beg); //定位于第0,2,4学生数据开头
//g表示get，用于读文件时定位

iofile.read((char*)&stud1[i/2],sizeof(stud1[0]));
//先后读入3个学生的数据，存放在stud1[0],stud[1]和stud[2]中
cout<<stud1[i/2].num<<" "<<stud1[i/2].name<<" "<<stud1[i/2].score<<endl;
//输出stud1[0],stud[1]和stud[2]各成员的值
}
cout<<endl;
stud[2].num=1012; //修改第3个学生(序号为2)的数据
strcpy(stud[2].name,"Wu");
stud[2].score=60;

iofile.seekp(2*sizeof(stud[0]),ios::beg); //定位于第3个学生数据的开头
//p表示put,用于写文件时定位

iofile.write((char*)&stud[2],sizeof(stud[2])); //更新第3个学生数据
iofile.seekg(0,ios::beg); //重新定位于文件开头
for(int i=0;i<5;i++)
{
iofile.read((char*)&stud[i],sizeof(stud[i])); //读入5个学生的数据
cout<<stud[i].num<<" "<<stud[i].name<<" "<<stud[i].score<<endl;
}
iofile.close( );
return 0;
}
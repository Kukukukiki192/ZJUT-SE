#include <fstream>
#include <iostream>
using namespace std;
void save_to_file();// save_to_file函数从键盘读入一行字符，并将其中的字母存入磁盘文件
void get_from_file();//从磁盘文件f2.txt读入字母字符，将其中的小写字母改为大写字母，再存入f3.txt

void save_to_file( )
{
ofstream outfile("f2.txt");
//定义输出文件流对象outfile，以输出方式打开磁盘文件f2.txt
if(!outfile)
{
cerr<<"open f2.txterror!"<<endl;
exit(1);
}
char c[80];
cin.getline(c,80);//从键盘读入一行字符
for(int i=0;c[i]!=0;i++) //对字符逐个处理，直到遇'/0 '为止
if(c[i]>=65 && c[i]<=90||c[i]>=97 && c[i]<=122)//如果是字母字符
{
	outfile.put(c[i]); //将字母字符存入磁盘文件f2.txt
	cout<<c[i]; //同时送显示器显示
}
cout<<endl;
outfile.close(); //关闭f2.txt
}

//从磁盘文件f2.txt读入字母字符，将其中的小写字母改为大写字母，再存入f3.txt
void get_from_file()
{char ch;
ifstream infile("f2.txt",ios::in);//定义输入文件流outfile，以输入方式打开磁盘文件f2.txt
if(!infile)
{
cerr<<"open f2.txterror!"<<endl;
exit(1);
}
ofstream outfile("f3.txt");//定义输出文件流outfile，以输出方式打开磁盘文件f3.txt
if(!outfile)
{
cerr<<"open f3.txterror!"<<endl;
exit(1);
}

while(infile.get(ch))//当读取字符成功时执行下面的复合语句
{
	if(ch>=97 &&ch<=122) //判断ch是否为小写字母
		ch=ch-32; //将小写字母变为大写字母
	outfile.put(ch); //将该大写字母存入磁盘文件f3.txt
	cout<<ch; //同时在显示器输出
}
cout<<endl;
infile.close( ); //关闭磁盘文件f2.txt
outfile.close(); //关闭磁盘文件f3.txt
}

//主函数
int main( )
{
	save_to_file( );//调用save_to_file( )，从键盘读入一行字符并将其中的字母存入磁盘文件f2.txt
    get_from_file( );//调用get_from_file()，从f2.txt读入字母字符，改为大写字母，再存入f3.txt
    return 0;
}
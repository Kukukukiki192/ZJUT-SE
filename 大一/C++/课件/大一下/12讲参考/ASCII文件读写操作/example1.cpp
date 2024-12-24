#include <fstream>
#include <iostream>
using namespace std;
int main( )
{
int a[10];
ofstream outfile("f1.txt",ios::out);//定义文件流对象，打开磁盘文件
if(!outfile) //如果打开失败，outfile返回0值
{  cerr<<"open error!"<<endl;
   exit(1);
}
cout<<"Enter 10 integer numbers:"<<endl;
for(int i=0;i<10;i++)  
{
cin>>a[i];
outfile<<a[i]<<" ";  //向磁盘文件输出数据
} 
outfile.close(); //关闭磁盘文件
return 0;
}

//测试数据
//1 3 5 2 4 6 10 8 7 9↙
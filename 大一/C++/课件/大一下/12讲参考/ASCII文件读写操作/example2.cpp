#include <fstream>
#include <iostream>
using namespace std;
int main( )
{
int a[10],max,i,order;
ifstream infile("f1.dat",ios::in);//定义输入文件流对象，以输入方式打开磁盘文件

if(!infile)
{
cerr<<"open error!"<<endl;
exit(1);
}
for(i=0;i<10;i++)
{
infile>>a[i];//从磁盘文件读入10个整数，顺序存放在a数组中
cout<<a[i]<<" ";//在显示器上顺序显示10个数
} 
cout<<endl;
max=a[0];
order=0;
for(i=1;i<10;i++)
   if(a[i]>max){
	   max=a[i]; //将当前最大值放在max中
       order=i; //将当前最大值的元素序号放在order中
   }
cout<<"max="<<max<<endl<<"order="<<order<<endl;
infile.close();
return 0;
}
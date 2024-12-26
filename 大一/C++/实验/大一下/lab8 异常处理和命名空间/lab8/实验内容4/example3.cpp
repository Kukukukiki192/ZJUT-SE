//在main函数所在的文件中包含头文件header1.h:
#include <iostream>
#include"example3_header1.h"
#include "example3_header2.h"
//注意要用双引号，因为文件一般是放在用户目录中的
using namespace std;
int main( )
{ns1::Student stud1(101,"Wang",18); //定义类对象stud1
stud1.get_data( );
cout<<ns1::fun(5,3)<<endl;

ns2::Student stud2(102,"Li",'f'); //定义类对象stud2
stud2.get_data( );
cout<<ns2::fun(5,3)<<endl;
return 0;
}

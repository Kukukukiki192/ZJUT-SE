#include "Student2.h"
#include <cstring>
using namespace std;

Student::Student(){
   name=new char[1];
   name[0]='\0';
}

Student::Student(const Student & o)
{
     name=new char[strlen(o.name)+1];
     strcpy(name,o.name); //若循环赋值注意处理终结符
}

void Student::operator=(const Student& o)
{
      if(this!=&o) {//保证不是自赋值,注意不能是*this和o比较，思考为什么？
          if( strlen(name)!=strlen(o.name))  //空间不匹配
          {  delete []name;
              name=new char[strlen(o.name)+1];
           }
         strcpy(name,o.name);
      }
}//若返回类型非void, 则函数结束末尾加 return  (*this);

Student::Student(char *n)
{
        name=new char[strlen(n)+1];
        strcpy(name,n);
}

char* Student::GetName()
{
   return name;
}

void Student::ChangeName(char *n)
{
    if( strlen(name)!=strlen(o.name))  //空间不匹配
   {   delete []name;
        name=new char[strlen(n)+1];
    }
   strcpy(name,n);
}

Student::~Student( )
{  delete []name;
}
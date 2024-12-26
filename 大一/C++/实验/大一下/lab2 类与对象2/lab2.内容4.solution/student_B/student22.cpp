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
     strcpy(name,o.name); //��ѭ����ֵע�⴦���ս��
}

void Student::operator=(const Student& o)
{
      if(this!=&o) {//��֤�����Ը�ֵ,ע�ⲻ����*this��o�Ƚϣ�˼��Ϊʲô��
          if( strlen(name)!=strlen(o.name))  //�ռ䲻ƥ��
          {  delete []name;
              name=new char[strlen(o.name)+1];
           }
         strcpy(name,o.name);
      }
}//���������ͷ�void, ��������ĩβ�� return  (*this);

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
    if( strlen(name)!=strlen(o.name))  //�ռ䲻ƥ��
   {   delete []name;
        name=new char[strlen(n)+1];
    }
   strcpy(name,n);
}

Student::~Student( )
{  delete []name;
}
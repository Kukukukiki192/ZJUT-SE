#include "mystring.h"

mystring::mystring( )
{  buflen=1;
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<assert.h>
   buffer[0]='\0';
}   //空串

mystring::mystring(unsigned size)
{  buflen=size;
   buffer=new char[size];
   assert(buffer!=0); //  # include<assert.h>
   for (unsigned i=0;i<buflen;i++)  buffer[i]='\0';
}   //给定长度的串

mystring::mystring(char c)
{  buflen=2;
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<assert.h>
   buffer[0]=c;
   buffer[1]='\0';
}   //给定值的串-字符


mystring::mystring(const char * initstr)
{  buflen=1+cstrLen(initstr);
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<assert.h>
   unsigned i;
   for (i=0;i<buflen -1;i++)  buffer[i]=initstr[i];
   buffer[i]='\0';
}   //给定值的串-c/c++表示

unsigned cstrLen(const char* s)
{  unsigned len=0;
    for(; s[len]!='\0';len++);   
    return len;
}   //求C++表示的字符串的字面长度。

mystring::mystring(const mystring& initstr)
{  buflen=1+cstrLen(initstr.buffer); //buflen=1+initstr.length();
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<assert.h>
   unsigned i;
   for (i=0;i<buflen-1;i++)  buffer[i]=initstr.buffer[i];
   buffer[i]='\0';
}   //给定值的串-mystring类型表示


mystring::~mystring()
{
	delete []buffer;
	buflen=0;
	buffer=NULL;
}

void mystring ::operator =( const mystring & right)
{ const unsigned rightLength=right.length();
  if(right.length()>=buflen)
  {
	delete []buffer;
	buflen=1+rightLength;
	buffer=new char[buflen];
	assert(buffer!=0);
  }
  for(unsigned i=0;right.buffer[i]!='\0';i++)
	 buffer[i]=right.buffer[i];
  //buffer[i]='\0';
} 


int mystring ::compare ( const mystring & right) const
{ char *p=buffer;
  char *q=right.buffer;
  
  for(;(*p!='\0')&&(*p==*q);p++,q++);//

  return *p-*q;
}  

char nothing;
char& mystring ::operator[] (unsigned index) const
{ if (index>=cstrLen(buffer))
   {
     	nothing='\0';
      return  nothing;
   }
   return buffer[index]; } 

unsigned mystring ::length( )const
{ return cstrLen(buffer); } 

istream& mystring ::getline( istream& in)
{ in.getline(buffer,buflen,'\n');
   return in; }  

mystring ::operator const char*( ) const
{ return buffer; }  

//关于关系运算的扩充 
int operator<=(const mystring& left,const mystring& right)
{    return left.compare(right)<=0;     }

int operator<(const mystring& left,const mystring& right)
{    return left.compare(right)<0;     }

int operator>(const mystring& left,const mystring& right)
{    return left.compare(right)>0;     }

int operator>=(const mystring& left,const mystring& right)
{    return left.compare(right)>=0;     }

int operator==(const mystring& left,const mystring& right)
{    return left.compare(right)==0;     }

int operator!=(const mystring& left,const mystring& right)
{    return left.compare(right)!=0;     }

//输入输出的扩充
istream& operator>>(istream& in,mystring& str)
{    char inbuffer[1000];
      if(in>>inbuffer) 
           str=inbuffer;
      else  
           str=" ";
      return in;    }

ostream& operator<<(ostream& out,const mystring& str)
{ 
	out<<str.buffer<<endl;
    return out;
}

#include "mystring.h"
#include <iostream>
using namespace std;
mystring::mystring( )
{  buflen=1;
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<cassert>
   buffer[0]='\0';
}   //空串

mystring::mystring(unsigned size)
{  buflen=size;
   buffer=new char[size];
   assert(buffer!=0); //  # include<cassert>
   for (unsigned i=0;i<buflen;i++)  buffer[i]='\0';
}   //给定长度的串

mystring::mystring(char c)
{  buflen=2;
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<cassert>
   buffer[0]=c;
   buffer[1]='\0';
}   //给定值的串-字符


mystring::mystring(const char * initstr)
{  unsigned i;
   buflen=1+cstrLen(initstr);
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<assert.h>
   for (i=0;i<buflen -1;i++)  buffer[i]=initstr[i];
   buffer[i]='\0';
}   //给定值的串-c/c++表示

unsigned cstrLen(const char* s)
{  unsigned len=0;
    for(; s[len]!='\0';len++);   
    return len;
}   //求C++表示的字符串的字面长度。
mystring::mystring(char *buf,int pos,int patlen)
{	
	int l=patlen-pos,i;
	buffer=new char[l];
	assert(buffer!=0);
	for(i=0;i<l;i++)
	{	buffer[i]=buf[pos+i];
	}buffer[i]='\0';
	buflen=patlen-pos;
}
mystring::mystring(const mystring& initstr)
{  unsigned i;
   buflen=1+cstrLen(initstr.buffer); //buflen=1+initstr.length();
   buffer=new char[buflen];
   assert(buffer!=0); //  # include<assert.h>
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
  unsigned i;
  if(right.length()>=buflen)
  {
	delete []buffer;
	buflen=1+rightLength;
	buffer=new char[buflen];
	assert(buffer!=0);
  }
  for(i=0;right.buffer[i]!='\0';i++)
	 buffer[i]=right.buffer[i];
  buffer[i]='\0';
} 


int mystring ::compare ( const mystring & right) const
{ char *p=buffer;
  char *q=right.buffer;
  
  for(;(*p!='\0')&&(*p==*q);p++,q++); //

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
char* mystring::getBuffer() const 
{ return buffer;
}

istream& mystring ::Getline( istream& in)
{ in.getline(buffer,buflen,'\n');
   return in; }  
 

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
	out<<str.getBuffer()<<endl;
    return out;
}


int mystring::SimpleMatch(const mystring& pattern) const
 {   int patlen= pattern.length(); 
     int last=(*this).length()- patlen; //最后一个可能匹配位置  
     int pos=0;
     for(; pos<=last;pos++)
      {    mystring  t(buffer,pos,patlen);          
           if(pattern==t) return pos;} //找到匹配位置返回
      pos=-1; // 找不到匹配位置 
      return pos;
  }

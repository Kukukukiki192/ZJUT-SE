#ifndef	mystring_H
#define mystring_H

#include <iostream>
#include <assert.h>
using namespace std;
class mystring {
private: 
    unsigned buflen;  //空间大小
public: 
	char  *buffer; //存放字符串的空间的起始位置
     //初始化
     mystring();    //空串
     mystring(unsigned); //指定长度串（无值）
     mystring(char); //给定值的串-字符
     mystring(const char *); //给定值的串-c/c++类型的字符串
     mystring(const mystring&); //给定值的串-mystring类型的字符串
     ~mystring();  //  析构

     void operator = (const mystring& right); //赋值
     int compare(const mystring& right) const; //比较
     char& operator[](unsigned index) const;//下标访问
     unsigned length( ) const;  //求串长
     istream& getline(istream&); //按行读入
     operator const char* ( ) const; //转换成C/C++表示的字符串   
};

unsigned cstrLen( const char str[]);
istream& operator>>(istream& in,mystring& str);
int operator<=(const mystring& left,const mystring& right);
int operator<(const mystring& left,const mystring& right);
int operator>(const mystring& left,const mystring& right);
int operator>=(const mystring& left,const mystring& right);
int operator==(const mystring& left,const mystring& right);
int operator!=(const mystring& left,const mystring& right);

#endif

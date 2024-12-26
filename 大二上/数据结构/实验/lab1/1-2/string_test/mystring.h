#ifndef	mystring_H
#define mystring_H

#include <iostream>
#include <assert.h>
using namespace std;
class mystring {
private: 
    unsigned buflen;  //�ռ��С
public: 
	char  *buffer; //����ַ����Ŀռ����ʼλ��
     //��ʼ��
     mystring();    //�մ�
     mystring(unsigned); //ָ�����ȴ�����ֵ��
     mystring(char); //����ֵ�Ĵ�-�ַ�
     mystring(const char *); //����ֵ�Ĵ�-c/c++���͵��ַ���
     mystring(const mystring&); //����ֵ�Ĵ�-mystring���͵��ַ���
     ~mystring();  //  ����

     void operator = (const mystring& right); //��ֵ
     int compare(const mystring& right) const; //�Ƚ�
     char& operator[](unsigned index) const;//�±����
     unsigned length( ) const;  //�󴮳�
     istream& getline(istream&); //���ж���
     operator const char* ( ) const; //ת����C/C++��ʾ���ַ���   
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

#ifndef	mystring_H
#define mystring_H

#include <iostream>
#include <cassert>
/*	C���ļ�һ�㶼�ж�Ӧ��C++��׼���ļ�,�������C���ļ���ǰ����ĸC,
	��ȥ�������.h��׺������assert.h���ӦΪcassert 
	
	C++��ߵ�assert����ͷ�ļ�CASSERT��ߣ���Ҫ�ǲ��Գ��������������
	��ȷ�����κβ����������������Ϣ��ֹͣ����	*/
using namespace std;

class mystring {
private: 
    char  *buffer; //����ַ����Ŀռ����ʼλ��
    unsigned buflen;  //�ռ��С
public: 
     //��ʼ��
     mystring();    //�մ�
     mystring(unsigned); //ָ�����ȴ�����ֵ��
     mystring(char); //����ֵ�Ĵ�-�ַ�
     mystring(const char *); //����ֵ�Ĵ�-c/c++���͵��ַ���
     mystring(const mystring&); //����ֵ�Ĵ�-mystring���͵��ַ���
     ~mystring();  //  ����

	 mystring(char *buf,int pos,int patlen);

     void operator = (const mystring& right); //��ֵ
     int compare(const mystring& right) const; //�Ƚ�
     char& operator[](unsigned index) const;//�±����
     unsigned length( ) const;  //�󴮳�
	 char* getBuffer() const; //ȡ�ַ����Ĵ洢�ռ��׵�ַ
     istream& Getline(istream&); //���ж���
     operator const char* ( ) const; //ת����C/C++��ʾ���ַ���  
     
    
     friend ostream& operator<<(ostream& out,const mystring& str);
     
     int SimpleMatch (const mystring& pattern)const;
};

unsigned cstrLen( const char str[]);//�󴮳�
istream& operator>>(istream& in,mystring& str);//����������
ostream& operator<<(ostream& out,const mystring& str);//���������
int operator<=(const mystring& left,const mystring& right);//��ϵ���������ϵ��
int operator<(const mystring& left,const mystring& right);
int operator>(const mystring& left,const mystring& right);
int operator>=(const mystring& left,const mystring& right);
int operator==(const mystring& left,const mystring& right);
int operator!=(const mystring& left,const mystring& right);


#endif

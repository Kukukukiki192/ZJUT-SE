//2.�ñ�׼���е�strcat����
#include <iostream>
#include<string>
using namespace std;
int main()
{const int n=100;
	char str1[n],str2[n];
	cout<<"�����ַ���1��"<<endl;
	cin.getline(str1,n);
	cout<<"�����ַ���2��"<<endl;
	cin.getline(str2,n);
	cout<<"���ַ�����"<<strcat(str1,str2)<<endl;
    return 0;
}
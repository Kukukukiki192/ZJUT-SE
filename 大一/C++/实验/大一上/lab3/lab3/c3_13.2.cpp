//2.用标准库中的strcat函数
#include <iostream>
#include<string>
using namespace std;
int main()
{const int n=100;
	char str1[n],str2[n];
	cout<<"输入字符串1："<<endl;
	cin.getline(str1,n);
	cout<<"输入字符串2："<<endl;
	cin.getline(str2,n);
	cout<<"新字符串："<<strcat(str1,str2)<<endl;
    return 0;
}
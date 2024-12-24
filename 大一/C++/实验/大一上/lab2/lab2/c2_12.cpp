#include<iostream>
#include<iomanip>
using namespace std;
int main()
{int i,j;//i为行数，j为列数
	cout<<"九九乘法表"<<endl;
    for(i=1;i<=9;i++)
    {
    	for(j=1;j<=i;j++)
        cout<<j<<"x"<<i<<"="<<j*i<<"\t"<<setiosflags(ios::left);
    	cout<<endl;
    }
    return 0;
}
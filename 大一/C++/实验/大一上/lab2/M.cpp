#include<iostream>
using namespace std;
int main()
{int i,j;                     //i为行数
	for(i=1;i<=10;i++)
	{
		for(j=1;j<i;j++)      //此行j为空格数
		cout<<" ";
		for(j=1;j<=21-2*i;++j)//此行j为M的个数
		cout<<"M";
		cout<<endl;
	}
  return 0;  
}
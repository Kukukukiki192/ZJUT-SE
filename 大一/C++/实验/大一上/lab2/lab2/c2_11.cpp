#include<iostream>
using namespace std; 
int main()
{int i,j,n;//i为空格数，j为*数，n为行数
	for(n=1;n<=4;n++)
	{
	for(i=1;i<=4-n;i++)
	cout<<" ";
    for(j=1;j<=n;j++)
    cout<<"*";
    cout<<endl;
	}
	for(n=1;n<=4;n++)
	{
    for(j=1;j<=4-n;j++)
    cout<<"*";
    for(i=1;i<=n;i++)
	cout<<" ";
    cout<<endl;
	}
	return 0;
}
#include<iostream>
using namespace std;
int main()
{int i,j;
	for(i=1;i<=10;i++)
	{
	for(j=1;j<=10-i;j++)
	cout<<" ";
	for(j=1;j<=2*i-1;j++)
	putchar(64+j);
	cout<<endl;	
	}
	return 0;
}
#include<iostream>
#include<fstream>
using namespace std;
int main()
{
	int a[10]={56,34,3,67,89,55,22,43,12,9},i,j,t;
	for(i=0;i<9;i++)
	for(j=i+1;j<10;j++)
		if(a[i]<a[j]) 
		{t=a[i];a[i]=a[j];a[j]=t;}
	ofstream fout("data.txt");
	for(i=0;i<10;i++) fout<<a[i]<<" ";
	fout.close();
	ifstream fin("data.txt");
	char b;
	while(fin.get(b)) cout<<b;
	fin.close();
	return 0;
}

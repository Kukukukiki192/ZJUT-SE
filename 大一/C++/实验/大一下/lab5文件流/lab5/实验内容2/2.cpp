#include<iostream>
#include<fstream>
#include<cmath>
using namespace std;
int main()
{
	int prime(int);
	ofstream fout("prime.txt");
	int i,n=0,sum=0;
	for(i=2;i<=2000;i++)
	if(prime(i)==1) 
	{
	 if(n%10==0) {fout<<endl;cout<<endl;}
	 fout.width(5);
	 fout.setf(ios::right);
	 if((n+1)%10==0||i==1999) {fout<<i; cout<<i;} 
	 else {fout<<i<<","; cout<<i<<","; }
	 n++; sum+=i;
	}
	fout.close();
	
	cout<<"sum="<<sum<<endl;
	return 0;
} 
int prime(int x)
{
	for(int i=2;i<=sqrt(x);i++)
		if(x%i==0) return 0;
	return 1;
}


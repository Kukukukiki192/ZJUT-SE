#include<iostream>
using namespace std;
void main()
{
	for(int i=0;i<5;++i)
	{
		if(i==0)
		cout<<" 000      11"<<endl;
		else if(i==5)
		cout<<"00 00    1111"<<endl;
		else cout<<"00 00     11"<<endl;
	}
}
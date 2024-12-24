#include<fstream>
#include <iostream>
using namespace std;
//------------------------
int main()
{
	int n;
	ifstream cin("c1_4.txt");
	cin>>n;
	int sum=((1+n)*n)>>1;
	cout<<sum<<endl;
	return 0;
}

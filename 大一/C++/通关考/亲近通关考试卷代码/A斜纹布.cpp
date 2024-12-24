#include <iostream>
#include <string>
using namespace std;
int main()
{
	const int N=2;
	int i,j,n[N];
	string s[N];
	for(i=0;i<N;++i) 
	{
		cin>>s[i]>>n[i];
 		while(s[i].length()<2*n[i])
 		s[i]+=s[i];
	}
	for(i=0;i<N;++i)
	cout<<s[i].substr(i,n)<<endl;
    return 0;
}
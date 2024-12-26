#include <iostream>
#include<string>
using namespace std;
int main()
{
	string ch="3.14";
   //char ch;
   double num;
   //cin>>ch;
   cout<<ch<<endl;
   if(ch[0]>='0' && ch[0]<='9') cin.putback(ch[0]);
   cin>>num;
   cout<<num<<endl;
}

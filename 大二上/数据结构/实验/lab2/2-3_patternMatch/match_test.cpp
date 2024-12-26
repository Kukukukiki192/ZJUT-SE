#include <iostream>
#include <string>
#include"mystirng.h"
#include"mystirng.cpp"
using namespace std;

int main()
{string s1,s2="neu",s3="roses are red";
 cout<<s3.find_first_of(s2)<<endl;
 cout<<s3.compare(s2)<<endl;
 mystring s("She loves roses so much!");
 int position=s.SimpleMatch("roses");
 cout<<"Original string:"<<s<<endl;
 if(position==-1) cout<<"Can't find \"roses\"!"<<endl;
 else cout<<"The position of \"roses\" in original string is:"<<position;
 return 0;
}

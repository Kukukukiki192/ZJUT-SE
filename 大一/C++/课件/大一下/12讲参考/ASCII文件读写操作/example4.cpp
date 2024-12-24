#include <fstream>
#include <iostream>
using namespace std;

void display_file(char* filename)
{
 ifstream infile(filename,ios::in);
 if(!infile)
 {
	cerr<<"open error!"<<endl;
 exit(1);
	}
char ch;
while(infile.get(ch))  cout.put(ch);
cout<<endl;
infile.close();
}

int main( )
{
	display_file("f3.dat");//将f3.dat的入口地址传给形参filename
    return 0;
}
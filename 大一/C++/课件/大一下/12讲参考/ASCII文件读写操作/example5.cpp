#include <fstream>
#include <iostream>
using namespace std;

void copyfile(char* source,char* newfile);

int main(int argc,char* argv[])
{
	if(argc!=3) {
		cerr<<"Copyfile's format is:copyfile existing-file new-file"<<endl;
		exit(1);
	}
	copyfile(argv[1],argv[2]);
    return 0;
}

void copyfile(char* source,char* newfile)
{	ifstream readfile(source,ios::in);
	ofstream writefile(newfile,ios::out);
	if(!readfile) {
		cerr<<"Readfile openning failed";
		exit(1);
	}
	if(!writefile) {
		cerr<<"Writefile openning failed";
		exit(1);
	}
    char ch;
	while(readfile.get(ch))
		writefile.put(ch);

	readfile.close();
	writefile.close();
}
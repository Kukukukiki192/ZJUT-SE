#include<ctime> 
#include<iostream> 
using namespace std;
int main() { 
	struct tm *local; 
	time_t t; 
	t=time(NULL); 
	local=localtime(&t); 
	cout<<"Local hour is: "<<local->tm_hour<<endl; 
	local=gmtime(&t); 
	cout<<"UTC hour is: "<<local->tm_hour<<endl; 
	return 0; 
} 

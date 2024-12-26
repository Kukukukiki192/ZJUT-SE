#include<iostream>
#include<cstdlib>
#include<ctime> 
using namespace std;
/*
	clock_t clock();
	time_t time();
*/
int main(){ 
	long i=10000000L;//L表明这个数是long int类型
	clock_t start,finish; 
	double duration; 
	//测量一个事件持续的时间 
	cout<<"Time to do "<<i<<" empty loops is "; 
	start=clock(); 
	while(i--); 
	finish=clock(); 
	duration=(double)(finish-start)/CLOCKS_PER_SEC; 
	cout<<duration<<" seconds "<<endl;
	
//	struct tm *ptr; 
//	time_t lt; 
//	lt=time(NULL); 
	cout<<"The Calendar Time now is "<<time()<<endl;
	
	return 0;
} 

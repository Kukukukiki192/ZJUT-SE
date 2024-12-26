#include<iostream>
#include<ctime>
using namespace std;
long long fib1(int n){//µÝ¹é 
	if(n<=2) return 1;
	return fib1(n-1)+fib1(n-2);
}
long long fib2(int n){//·ÇµÝ¹é
	if(n<=2) return 1;
	long long f1=1,f2=1,sum;
	for(int i=3;i<=n;i++){
		sum=f1+f2;
		f1=f2;
		f2=sum;
	}
	return sum;
} 
int main(){
	int n;	clock_t start,end;
	cout<<"Input 0 to stop."<<endl;
	cout<<"·ÇµÝ¹éFib"<<endl;
	while(1){
		cout<<"Please input the number to calculate:";
		cin>>n;	if(n==0) break;
		start=clock();
		cout<<"F("<<n<<")="<<fib2(n)<<endl;
		end=clock();
		cout<<"time="<<(double)(end-start)*1000/CLOCKS_PER_SEC<<"ms"<<endl;
	}
	cout<<endl; 
	cout<<"µÝ¹éFib"<<endl;
	while(1){
		cout<<"Please input the number to calculate:";
		cin>>n;	if(n==0) break;
		start=clock();
		cout<<"F("<<n<<")="<<fib1(n)<<endl;
		end=clock();
		cout<<"time="<<(double)(end-start)*1000/CLOCKS_PER_SEC<<"ms"<<endl;
	}
	return 0;
	//F(100)~3.7*10^18
} 


#include<iostream>
#include<cstdlib>
#include<ctime>
#include<set>
using namespace std;
const int N=1e4;
int BinarySearch(int a[],const int& x,int l,int r){
    while(r>=l){ 
    	int m=(l+r)/2;
        if(x==a[m]) return m;
        if(x<a[m]) r=m-1; else l=m+1;
    }
    return -1;
} 
int main(){
	int n,x,i,a[N]; 
	cout<<"数组大小:";
	cin>>n;
	cout<<"输入数组:";
	for(i=0;i<n;i++){
		cin>>x; 
		a[i]=x;
	}
	cout<<"输入要寻找的数:";
	cin>>x;
	cout<<"其所在位置:";
	int local=BinarySearch(a,x,0,n-1)+1;
	if(local==0) cout<<"无此数"<<endl;
	else cout<<local<<endl;
	
//随机生成1e4个有序整数-通过set集合去重生成随机有序序列 
	cout<<"随机生成10000个有序整数(输入1开始):";
	cin>>x;
	if(x==1){
	set<int> b; 
	set<int>::iterator it;
	srand((unsigned)time(0));
	clock_t start,end;
	start=clock(); // 计时器开始 
//运行时set和list只能生成size()/2的递增随机数,所以用N*2生成N个随机数 
	while(b.size()<2*N){ 
		b.insert(rand());
	}
	end=clock(); // 计时器停止 
	it=b.begin();
	for(i=0;i<N;i++){
		if(i%20==0) { cout<<endl; cout<<i+1<<"~"<<i+20<<":"<<'\t'; }
		a[i]=*(it);
		cout<<*(it++)<<'\t';
	}cout<<endl;
	
	cout<<"用时"<<(double)(end-start)*1000/CLOCKS_PER_SEC<<"ms"<<endl;
	cout<<"输入要寻找的数:";
	cin>>x;
	cout<<"其所在位置:";
	local=BinarySearch(a,x,0,N-1)+1;
	if(local==0) cout<<"无此数"<<endl;
	else cout<<local<<endl; 
	}
	return 0;
}
//rand()%n获得[0,n-1]的随机整数的缺点: 
//(1)当n不是2的若干次幂时,产生的随机数不是等概率的
//(2)rand()函数有上限,只能生成[0,32767]的伪随机数,所以n<=RAND_MAX+1=32768
//通过多个随机数拼接生成随机数可解决上述问题
// 生成[0,n-1]之间的整数 
//long long Rand(long long n){
//	long long result=0;
//	// 这里的随机数上限是1e18,考虑时间效率与数据范围选择每次左移10位
//	for(int i=0;i<6;i++){
//		result=((result<<10)+rand()%1024)%n;
//	}
//	return result;
//} 

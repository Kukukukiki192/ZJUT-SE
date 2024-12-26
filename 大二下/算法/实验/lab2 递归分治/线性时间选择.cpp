#include <cstdlib>
#include <iostream>   
#include <ctime>
#include <set>  
#define N 10000
using namespace std;   
//随机划分线性选择:对输入数组进行递归划分，与快速排序不同的是，它只对划分出的子数组之一进行递归处理

void Swap(int &x,int &y)  {  
    int temp = x;  
    x = y;  
    y = temp;  
}  
int Random(int x, int y)  {  
     srand((unsigned)time(0));  
     int ran_num = rand() % (y - x) + x;//生成x到y-x-1的随机整数 
     return ran_num;  
}  
int Partition(int a[],int p,int r) {
    int i = p,j = r + 1;  
    int x = a[p];  
    while(true) {  
        while(a[++i]<x && i<r);  
        while(a[--j]>x);  
        if(i>=j) break;  
        Swap(a[i],a[j]);  
    }  
    a[p] = a[j];  
    a[j] = x;  
    return j;  
}   
int RandomizedPartition(int a[],int p,int r) {  
    int i = Random(p,r);  
    Swap(a[i],a[p]);  
    return Partition(a,p,r);  
}  
int RandomizedSelect(int a[],int p,int r,int k) {  //n个元素，索引为0~n-1 (p~r) 
    if(p == r) return a[p];  
    int i = RandomizedPartition(a,p,r);  
    int j = i - p + 1;  
    if(k <= j) return RandomizedSelect(a,p,i,k); 
    else return RandomizedSelect(a,i+1,r,k-j); 	
	//由于已知道子数组a[p:i]中的元素均小于要找的第k小元素  
    //因此，要找的a[p:r]中第k小元素是a[i+1:r]中第k-j小元素。 
} 	//平均情况O(n)  最坏情况O(n^2) 

int main()  {  
	int a[N],n,i,x;
	cout<<"数组大小:";
	cin>>n;
	cout<<"输入数组:";
	for(i=0;i<n;i++) cin>>a[i];
	cout<<endl; 
    cout<<"最大值="<<RandomizedSelect(a,0,n-1,n)<<endl; //第1大元素=第n小元素 
    cout<<"第2大值="<<RandomizedSelect(a,0,n-1,n-1)<<endl;
    cout<<"第4大值="<<RandomizedSelect(a,0,n-1,n-3)<<endl;
    
    //随机生成1e4个有序整数-通过set集合去重生成随机有序序列 
	cout<<"随机生成10000个有序整数(输入1开始):";
	cin>>x;
	if(x==1){
	set<int> b; 
	set<int>::iterator it;
	srand((unsigned)time(0));
//运行时set和list只能生成size()/2的递增随机数,所以用N*2生成N个随机数 
	while(b.size()<2*N){ 
		b.insert(rand());
	}it=b.begin();
	for(i=0;i<N;i++) a[i]=*(it);//集合中的数赋值给数组 
	for(i=N; i>0; --i) Swap(a[i], a[rand()%i]);//将有序数组打乱 
	for(i=0;i<N;i++){
		if(i%20==0) { cout<<endl; cout<<i+1<<"~"<<i+20<<":"<<'\t'; }
		cout<<*(it++)<<'\t';
	}cout<<endl;
    cout<<"第4999小的数="<<RandomizedSelect(a,0,N-1,4999)<<endl;
	}
    return 0;
}  

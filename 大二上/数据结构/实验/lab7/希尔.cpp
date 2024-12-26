//希尔排序
#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#define num 100
using namespace std;

template<class T>//插入排序
void InsertSort(vector<T> &x){//x[1~n] x[0]存放x[i]的副本 x.size()=n+1
	int i,j;
	for(i=2;i<=x.size()-1;i++)
		if(x[i]<x[i-1]){
			x[0]=x[i];//x[0]-监视哨
			x[i]=x[i-1];
			for(j=i-2;x[0]<x[j];j--) x[j+1]=x[j];
			x[j+1]=x[0]; 
		} 
}
template<class T>
void sort_interval(int start,int increment,vector<T> &x){
	vector<T> y; 
	int i=1,j=start+increment*(i-1);
	for(i=1;j<x.size();i++){
		y[i]=x[j];
	}
	InsertSort(y);
	for(i=1;j<x.size();i++){
		x[j]=y[i];
	}
}
template<class T>
void ShellSort(vector<T> &x){
	int increment=x.size()-1,start;
    do{increment=increment/3+1;
        for(start=1;start<=increment;start++)
            sort_interval(start,increment,x); //修改插入排序?
    }while(increment>1);
}

template<class T>
void Display(vector<T> &x){    
	for(int i=1;i<x.size();i++){	
		cout<<setw(5)<<x[i]<<" ";
	    if(i%10==0) cout<<endl;
	}
}

template<class T>
void ResetData(vector<T> &x,vector<T> &y){//使用y重置x
	int n=y.size();
	x.reserve(n);
	for(int i=1;i<n;i++) x[i]=y[i];
}

int main(){
	vector<int> a(num+1),b(num+1); 
	//有效数据从1开始，也可以设计从0开始，自行根据需要调整
    int i;
    srand(time(0));//随机数种子初始化
	for(i=1;i<=num;i++)
	{	a[i]=rand()%10000+1; //随机生成1-10000内的数值作为排序对象
	    b[i]=a[i];
	}
	//排序前显示数据
	cout<<"排序前"<<endl;
    Display(a);
	//希尔排序
   	ResetData(a,b);
   	ShellSort(a);
  	cout<<"希尔排序后"<<endl;
   	Display(a);
	
	return 0;
}

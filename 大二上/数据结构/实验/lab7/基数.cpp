#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#include <queue>
#define num 100
using namespace std;
 
template<class T>
int Base(vector<T> x){//求待排序序列最大元素位数 
//这里不要用引用& 会改变原数组,把最大数变为0 !
	int max=1,bits=0;
	for(int i=2;i<x.size();i++)
		if(x[i]>x[max]) max=i;
	while(x[max]){
		bits++;
		x[max]/=10;
	}
	return bits;
} 
template<class T>
int BitNum(T x,int bit){//求x第bit位上的数 
	int t=1;
	for(int i=1;i<bit;i++) t*=10;
	return (x/t)%10;
}
template<class T>//基数排序P677 稳定 
void RadixSort(vector<T> &x){
	queue<int> q[10];
	int i,j,k,t,base=Base(x);
	for(i=1;i<=base;i++){
		cout<<i<<endl;
		for(j=1;j<x.size();j++){
			int bit=BitNum(x[j],i);
			q[bit].push(x[j]);//派发 
			cout<<x[j]<<" ";
		}	cout<<endl;	
		for(t=0,k=1;t<10;t++){
			while(!q[t].empty()){
				x[k++]=q[t].front();//收集 
				cout<<q[t].front()<<" ";
				q[t].pop();
			}
		}	cout<<endl;	
	}
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
    
	//基数排序
   	ResetData(a,b);
   	RadixSort(a);
   	cout<<"基数排序后"<<endl;
   	Display(a);
	
	return 0;
}

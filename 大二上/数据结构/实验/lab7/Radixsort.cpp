#include <iostream>
#include <vector>
#include <queue>
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
		for(j=1;j<x.size();j++){
			int bit=BitNum(x[j],i);
			q[bit].push(x[j]);//派发 
		}
		for(t=0,k=1;t<10;t++){
			while(!q[t].empty()){
				x[k++]=q[t].front();//收集 
				q[t].pop();
			}
		}	
	}
}

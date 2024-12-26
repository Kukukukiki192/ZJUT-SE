#include <iostream>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#define N 10000
using namespace std;
void Swap(int& a,int& b){int t=a; a=b; b=t;}
int Partition (int a[], int p, int r){
        int i = p, j = r + 1; 
        int x=a[p];
        //将<x的交换到左边区域，>x的交换到右边区域
        while (true) {
           while (a[++i] <x && i<r); 
           while (a[- -j] >x);
           if (i >= j) break; 
           Swap(a[i], a[j]);
        }
       a[p] = a[j];  a[j] = x;  return j;
}
void QuickSort(int a[], int p, int r)
{
      if (p<r) {
        int q=Partition(a,p,r); //以a[p]分基准为左右两半
        QuickSort (a,p,q-1); //对左半段排序
        QuickSort (a,q+1,r); //对右半段排序
        }
}
void Display(int x[],int n){    
	for(int i=0;i<n;i++){	
		if(i%20==0) cout<<endl;
		cout<<setw(5)<<x[i]<<" ";
	}cout<<endl;
}
int main(){
	int n,x,i,a[N],b[N]; 
	cout<<"数组大小:";
	cin>>n;
	cout<<"输入数组:";
	for(i=0;i<n;i++){
		cin>>x; 
		a[i]=x;
		b[i]=a[i];
	}
	cout<<endl;
	cout<<"快速排序后"<<endl;
	QuickSort(a,0,n);
	Display(a,n);
	return 0;
}

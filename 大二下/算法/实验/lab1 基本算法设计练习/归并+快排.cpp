#include <iostream>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#define N 10000
using namespace std;
//归并-非递归 nlogn
void Merge(int c[],int d[],int l,int m,int r){
  int i=l,j=m+1,k=l,q;
  while( i<=m && j<=r ){
    if(c[i]<=c[j])
      d[k++]=c[i++];
    else
      d[k++]=c[j++];
  }
  if(i>m)
     for(q=j;q<=r;q++)
        d[k++]=c[q];
  else
     for(q=i;q<=m;q++)
        d[k++]=c[q];
}
void MergePass(int x[],int y[],int s,int n){
  int i=0,j;
  while(i<=n-2*s){//合并大小为s的相邻子段到y
     Merge(x,y,i,i+s-1,i+2*s-1);
     i+=2*s;
  }
  if(i+s<n) //处理剩下的元素(大于s个，少于2s个)
    Merge(x,y,i,i+s-1,n-1);
  else //处理剩下的元素(少于s个)
    for(j=i;j<=n-1;j++)
       y[j]=x[j];
}
void MergeSort(int a[],int n){
  int s=1;
  int *b=new int[n];
  while(s<n){
    MergePass(a,b,s,n);//合并到临时存储数组b
    s+=s;
    MergePass(b,a,s,n);//合并到数组a
    s+=s;
  }
  delete []b;
}

//快排-递归 nlogn
void Swap(int& a,int& b){int t=a; a=b; b=t;}
int Partition (int a[], int l, int r){
        int i = l, j = r,x=a[l]; 
        //将<x的交换到左边区域，>x的交换到右边区域
        while (i<j) {
           while (a[j]>x && i<r)j--; 
           if(i<j) {
           	Swap(a[i++], a[j]);
		   }
           while (a[i] <=x&&i<j)i++;
           if (i<j){
		   Swap(a[i], a[j--]);
		   }
        }
       return i;
}
void QuickSort(int a[], int l, int r)
{
      if (l<r) {
        int q=Partition(a,l,r); //以a[p]分基准为左右两半
        QuickSort (a,l,q-1); //对左半段排序
        QuickSort (a,q+1,r); //对右半段排序
        }
}

void Display(int x[],int n){    
	for(int i=0;i<n;i++){	
		if(i%20==0) cout<<endl;
		cout<<setw(5)<<x[i]<<" ";
	}cout<<endl;
}
void ResetData(int x[],int y[],int n){//使用y重置x
	for(int i=0;i<n;i++) x[i]=y[i];
}

int main(){
	int n,x,i,a[N],b[N]; 
	cout<<"数组大小:";
	cin>>n;
	cout<<"输入数组:";
	for(i=0;i<n;i++){
		cin>>a[i];
		b[i]=a[i];
	}
	cout<<endl;
	cout<<"归并排序后:"<<endl;
	MergeSort(a,n);
	Display(a,n);
	cout<<"重置:"<<endl;
	ResetData(a,b,n);
	Display(a,n);
	cout<<"快速排序后:"<<endl;
	QuickSort(a,0,n-1);//原来写成n耽误了很久！！！！这里的n-1指数组最后一项 
	Display(a,n);
	
    srand(time(0));//随机数种子初始化
	for(i=0;i<N;i++)
	{	a[i]=rand()%10000; //随机生成0-10000内的数值作为排序对象
	    b[i]=a[i];
	}
	clock_t start,end,duration[2]; 
	//排序前显示数据
	cout<<"排序前，随机生成10000个整数，输入1开始输出:";
    cin>>x; 
	if(x==1){
	Display(a,N);
    
    //归并排序
  	start=clock();
  	MergeSort(a,N);
  	end=clock(); 
  	duration[0]=end-start;
  	cout<<"归并排序后:"<<endl;
	Display(a,N);
	cout<<"用时"<<duration[0]<<"ms"<<endl;
  	
    //快速排序
  	ResetData(a,b,N);
  	start=clock();
  	QuickSort(a,0,N);
  	end=clock(); 
  	duration[1]=end-start;
  	cout<<"快速排序后:"<<endl;
	Display(a,N);
	cout<<"用时"<<duration[1]<<"ms"<<endl;
    }
    return 0;
}

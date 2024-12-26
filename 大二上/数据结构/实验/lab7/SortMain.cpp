#include"Heapsort.cpp"
#include"BSTsort.cpp"
#include"Quicksort.cpp"
#include"Radixsort.cpp"
#include"Bubblesort.cpp"
#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#include <queue>
#define num 100
using namespace std;
//效率O(n2)的排序 
template<class T>
void Swap(T& a,T& b){T t=a; a=b; b=t;}

//冒泡排序 移动多
template<class T> 
void BubbleSort3(vector<T> &x);


//选择排序 不稳定
template<class T>//-基于数组  
void SelectSort(vector<T> &x){
	int i,j,k;//k-minpos 
	for(i=0;i<x.size()-1;i++){
		k=i;
		for(j=i+1;j<x.size();j++)
			if(x[j]<x[k]) k=j;
		if(k!=i){
			Swap(x[i],x[k]);
		}
	}
}
//template<class T>//-基于链表 
//void SelectSortLink(node<T> &x){
//	node<T> p,q,r;//r-minptr
//	for(p=x;p->next;p=p->next){
//		r=p;
//		q=p->next;
//		while(q){
//			if(q->data<r->data) r=q;
//			q=q->next; 
//		}
//		if(r!=p){
//			Swap(p->data,r->data);
//		}
//	}
//}


//插入排序 稳定
template<class T>
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


//希尔排序 
template<class T>
void ShellInsert(vector<T> &r,int n,int start){//修改直接插入排序
 	int i,j;
	for(i=n+start;i<r.size();i+=n)  //r[i]插入有序子表
        if(r[i]<r[i-n]){ //r[i]和前一个元素r[i-n]比较
		    r[0]=r[i];	 //r[i]暂存到r[0]中,r[0]-监视哨
		    r[i]=r[i-n]; //r[i-n]后移 
            for(j=i-n*2;j>0&&r[0]<r[j];j-=n) //从后向前寻找插入位置,逐个后移,直到找到插入位置
				r[j+n]=r[j];	//r[j]后移n位
            r[j+n]=r[0];		//将r[0]插入到r[j+n]位置
		}
}
template<class T>
void ShellSort(vector<T> &r){ 
	int n=r.size()-1,start;
	do{	n=n/3+1;
		for(start=1;start<=n;start++)
			ShellInsert(r,n,start);//一趟增量为n的希尔插入排序
	}while(n>1); 
}


//计数排序
template<class T> 
void CountedSort(vector<T> &v){
	vector<int> counted(v.size()); //暂存
    vector<T> temp_v(v.size()); //数据备份
    for(int i=1;i<v.size();i++){
        counted[i]=0; //计数初始化       
        temp_v[i]=v[i];        
	}
    //计数
    for(int i=1;i<v.size();i++)
        for(int j=i+1;j<v.size();j++)
            if(v[i]>v[j]) counted[i]++;
            else counted[j]++;              
    for(int i=1;i<v.size();i++)  v[counted[i]+1]=temp_v[i];
}


template<class T>
void RadixSort(vector<T> &x);//基数排序 

template<class T>//快速排序
void QuickSort(vector<T> &x);

template<class T>//二叉查找树排序
void BSTSort(vector<T> &x);

template<class T>//堆排序 O(nlog2n)
void HeapSort(vector<T> &x);

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
	clock_t start,finish,duration[7];
	//排序前显示数据
	cout<<"排序前"<<endl;
    Display(a);
	//冒泡排序
    BubbleSort3(a);
	cout<<"冒泡排序后"<<endl;
	Display(a);
	
	i=5000;
  	start=clock();
  	while(i--){
  		ResetData(a,b);
  		BubbleSort3(a);
	  }
  	finish=clock(); 
  	duration[0]=finish-start;
  	
    //选择排序
   	ResetData(a,b);
   	SelectSort(a);
  	cout<<"选择排序后"<<endl;
   	Display(a);
   	
   	i=5000;
  	start=clock();
  	while(i--){
  		ResetData(a,b);
  		SelectSort(a);
	  }
  	finish=clock(); 
  	duration[1]=finish-start;
  	
   	//插入排序
//   	ResetData(a,b);
//   	InsertSort(a);
//   	cout<<"插入排序后"<<endl;
//   	Display(a);
//   	
//   	i=5000;
//  	start=clock();
//  	while(i--){
//  		ResetData(a,b);
//  		InsertSort(a);
//	  }
//  	finish=clock(); 
//  	duration[2]=finish-start;
//  	
//   	//希尔排序
//   	ResetData(a,b);
//   	ShellSort(a);
//  	cout<<"希尔排序后"<<endl;
//   	Display(a);
//   	
//   	i=5000;
//  	start=clock();
//  	while(i--){
//  		ResetData(a,b);
//  		ShellSort(a);
//	  }
//  	finish=clock(); 
//  	duration[3]=finish-start;
//  	
    //计数排序
//   	ResetData(a,b);
//   	CountedSort(a);
//   	cout<<"计数排序后"<<endl;
//   	Display(a);
//   	
//   	i=5000;
//  	start=clock();
//  	while(i--){
//  		ResetData(a,b);
//  		CountedSort(a);
//	  }
//  	finish=clock(); 
//  	duration[4]=finish-start;
  	
    //基数排序
//   	ResetData(a,b);
//   	RadixSort(a);
//   	cout<<"基数排序后"<<endl;
//   	Display(a);
// 
//	i=5000;
//  	start=clock();
//  	while(i--){
//  		ResetData(a,b);
//  		RadixSort(a);
//	  }
//  	finish=clock(); 
//  	duration[5]=finish-start;

  	//快速排序
  	ResetData(a,b);
  	QuickSort(a);
  	cout<<"快速排序后"<<endl;
  	Display(a);
  	
  	i=5000;
  	start=clock();
  	while(i--){
  		ResetData(a,b);
  		QuickSort(a);
	  }
  	finish=clock(); 
  	duration[7]=finish-start;

  	//堆排序
//  	ResetData(a,b);
//  	HeapSort(a); 
//  	cout<<"堆排序后"<<endl; 
//  	Display(a);
//  	
//  	i=5000;
//  	start=clock();
//  	while(i--){
//  		ResetData(a,b);
//  		HeapSort(a);
//	  }
//  	finish=clock();
//	duration[8]=finish-start; 
	
	//   	额外产品：BST排序
//   	ResetData(a, b);
//   	BSTSort(a);
//   	cout << "BST排序后" << endl;
//   	Display(a);
//   	
//   	i=5000;
//  	start=clock();
//  	while(i--){
//  		ResetData(a,b);
//  		BSTSort(a);
//	  }
//  	finish=clock(); 
//  	duration[6]=finish-start;

  	cout<<"5000次重置和排序用时从多到少各为(ms):"<<endl;
  	cout<<"快速排序"<<"\t"<<duration[7]<<endl;
//  	cout<<"希尔排序"<<"\t"<<duration[3]<<endl;
//  	cout<<"插入排序"<<"\t"<<duration[2]<<endl;
//  	cout<<"基数排序"<<"\t"<<duration[5]<<endl;
  	cout<<"选择排序"<<"\t"<<duration[1]<<endl;
  	cout<<"冒泡排序"<<"\t"<<duration[0]<<endl;
//  	cout<<"计数排序"<<"\t"<<duration[4]<<endl;
//  	cout<<"堆排序  "<<"\t"<<duration[8]<<endl;
//  	cout<<"BST排序 "<<"\t"<<duration[6]<<endl;//这2个计算时间运行不了 
  	return 0;
}



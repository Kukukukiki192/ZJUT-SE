#include <iostream>
#include <vector>
using namespace std;

template<class T>
void Swap2(T& a,T& b){T t=a; a=b; b=t;}
//冒泡排序 移动多
template<class T> 
void BubbleSort1(vector<T> &x){
	int i,j;
	for(i=0;i<x.size()-1;i++)		//for(i=x.size()-1;i>0;i--)进行x.size()-1次排序 
		for(j=0;j<x.size()-1-i;j++) //for(j=0;j<i;j++)
			if(x[j]>x[j+1]) Swap2(x[j],x[j+1]);
}

//template<class T>//引用flag 大元素沉底(0号位未闲置) O(n^2)
//void BubbleSort2(vector<T> &x){
//	int i,j,flag=1;
//	for(i=x.size()-1;i>0&&flag;i--){
//		flag=0;
//		for(j=0;j<i;j++) 
//			if(x[j]>x[j+1]) Swap2(x[j],x[j+1]);
//	}
//}
//0号位置闲置,排序段1~x.size()-1;
template <class T>//引用flag  
void BubbleSort2(vector<T>& x){   
	//小元素上浮 比BubbleSort1快 
	int n=x.size()-1,i,j,flag=1;				 		
    for(i=1;i<n&&flag!=0;i++){//进行x.size()-2次排序    
	 	flag=0;
        for(j=n;j>i;j--)  								
            if(x[j]<x[j-1]){ 
                Swap2(x[j],x[j+1]);
                flag=1;
            }      
    }
}

//0号位置闲置,排序段1~x.size()-1;
template <class T>
void  BubbleSort3(vector<T>& x){   //ppt上部分逻辑错误 
	//大元素沉底 比BubbleSort2快 
	int numCompares=x.size()-1,last;
    //书上numCompares的作用:下轮扫面中需要比较的对的数目 
    while(numCompares!=1){    
		last=1;//重置 
        for(int j=1;j<numCompares;j++) 
            if(x[j]>x[j+1]){ 
                Swap2(x[j],x[j+1]);
                last=j;
            }   
        numCompares=last;//冒泡终点 
    }
}

#include<iostream>
#include <vector>
using namespace std;
void Swap(int& a,int& b){int t=a; a=b; b=t;}
template<class T>
void Swap1(T& a,T& b){T t=a; a=b; b=t;}
//0号位闲置
//quickSort --1partition分治策略 
template <class T>
int split(vector<T>& v,int first,int last){//p665
	T pivot=v[first];    
	int left=first,right=last;
	while(left<right){
		while(v[right]>pivot) right--;
		while(left<right&&v[left]<=pivot) left++;
		//||v[left]==pivot
		if(left<right) Swap1(v[left],v[right]);
	}
	int pos=right;
	Swap1(v[first],v[pos]);
	return pos;
}     

//2轮换策略

//quickSort –quickSort_sub
template <class T>
void quickSort_sub(vector<T>& v,int first,int last){
      if(first>=last)  return;
      int pos=split(v,first,last); //p665
      quickSort_sub(v,first,pos-1);//排first~pos-1
      //mIndex已经就绪
      quickSort_sub(v, pos+1,last);//排pos+1~last
}

template <class T>
void QuickSort(vector<T>& v){      
	quickSort_sub(v,0,v.size()-1);   
} 

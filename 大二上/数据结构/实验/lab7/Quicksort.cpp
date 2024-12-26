#include<iostream>
#include <vector>
using namespace std;
void Swap(int& a,int& b){int t=a; a=b; b=t;}
template<class T>
void Swap1(T& a,T& b){T t=a; a=b; b=t;}
//0��λ����
//quickSort --1partition���β��� 
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

//2�ֻ�����

//quickSort �CquickSort_sub
template <class T>
void quickSort_sub(vector<T>& v,int first,int last){
      if(first>=last)  return;
      int pos=split(v,first,last); //p665
      quickSort_sub(v,first,pos-1);//��first~pos-1
      //mIndex�Ѿ�����
      quickSort_sub(v, pos+1,last);//��pos+1~last
}

template <class T>
void QuickSort(vector<T>& v){      
	quickSort_sub(v,0,v.size()-1);   
} 

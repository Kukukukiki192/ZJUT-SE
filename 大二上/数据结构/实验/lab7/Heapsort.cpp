#include<iostream>
#include <vector>
using namespace std;
/*存储方式:按层存储,完全二叉树最适合
	从0开始存:
	左子	2*i+1     
	右子	2*i+2     
	父亲	(i-1)/2   
  √从1开始存: 
	左子	2*i    
	右子	2*i+1    
	父亲	i/2    
*/
template <class T>
class heap{
public:
   	heap():mySize(0){} //构造函数
   	//成员函数,优先队列的操作
   	bool empty() const{return mySize==0;} //判空
   	T top(){return myArray[1];} //取堆顶元素 	
   	void add(const T& item); 	//添加元素 p651	会破坏堆序性,需要调整
   	void removeTop(); 			//删除堆顶 p650	会破坏堆序性,需要调整
   	void deleteAllValues(); 	//删除所有元素	
	void Sink(vector<T>& v,unsigned int n,unsigned int i); 
	void Heapfying(vector<T>& v,unsigned int n);
private:
   	vector<T> myArray;
   	unsigned int mySize; //堆的元素个数
};
template <class T>
void heap<T>::add(const T& item){//p651上调算法
    //添加一个元素入堆,堆的规模扩大
    unsigned int loc=++mySize; //mySize: 堆最后的位置
    unsigned int parent=loc/2;
    while(parent>=1&&item>myArray[parent]){ //向上逐层调整
   		myArray[loc]=myArray[parent];
        loc=parent;
        parent=loc/2; 
    }
   //在合适位置放入新元素
   myArray[loc]=item;                                  
}
template<class T>
void heap<T>::removeTop()
{   myArray[1]=myArray[mySize]; //将堆尾元素覆盖堆顶
    mySize-- ; //堆的规模减小
    Sink(myArray,mySize,1); //调整堆   p650下调算法
} 
template<class T>
void heap<T>::deleteAllValues()
{   mySize=0; 
    return myArray.setSize(0); //删除堆中所有元素 
}


template<class T>
void Swap3(T& a,T& b){T t=a; a=b; b=t;}

template<class T> //处理由于堆顶导致的假堆 p650下调算法
void Sink(vector<T>& v,unsigned int n,unsigned int i)//v-堆数组,n-heapsize,i-position
{   T value=v[i]; //假堆顶
    int l=2*i; //左子
    while(l<=n){  	//取左右子中较大的
    	if((l<n)&&v[l]<v[l+1]) l++;   //若i有2子且右子较大           
        if(value<v[l]){ //找到合适位置，放好
            v[i]=v[l];
            i=l;    
        }      
        else break;
        l=2*i;  
 	}  
    v[i]=value;
}//O(log2n)


//template<class T>
//void Heapfying(vector<T>& data,unsigned int heapsize){//调整data为堆
//    int lastPos=heapsize;//堆的最后位置
//    int RootPos=lastPos/2; //最后的子树根
//    while(RootPos>=1){ //没有调整到堆顶，则继续调整
//       //调整以RootPos为根的子树
//        Sink(data,heapsize,RootPos); 
//           
//        RootPos--;  //下一棵子树的根 
//    } //O(nlog2n)
template<class T>
void Heapfying(vector<T>& v,unsigned int n){//调整data为堆-化简 
	for(int i=n/2;i>0;i--)	Sink(v,n,i);//从最后一个分支节点n/2开始下沉调整为堆,直到第一个节点 
}


template<class T>
void HeapSort(vector<T>& v){
   	int n=v.size()-1;
    Heapfying(v,n); //将x调整成堆,有效元素1~x.size()-1
    while(n>1){
		Swap3(v[1],v[n--]);//头尾交换 
		Sink(v,n,1);//调整1~ n-1之间的元素为堆 
	}
} //O(nlog2n)

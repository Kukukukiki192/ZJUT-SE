#include<iostream>
#include <vector>
using namespace std;
/*�洢��ʽ:����洢,��ȫ���������ʺ�
	��0��ʼ��:
	����	2*i+1     
	����	2*i+2     
	����	(i-1)/2   
  �̴�1��ʼ��: 
	����	2*i    
	����	2*i+1    
	����	i/2    
*/
template <class T>
class heap{
public:
   	heap():mySize(0){} //���캯��
   	//��Ա����,���ȶ��еĲ���
   	bool empty() const{return mySize==0;} //�п�
   	T top(){return myArray[1];} //ȡ�Ѷ�Ԫ�� 	
   	void add(const T& item); 	//���Ԫ�� p651	���ƻ�������,��Ҫ����
   	void removeTop(); 			//ɾ���Ѷ� p650	���ƻ�������,��Ҫ����
   	void deleteAllValues(); 	//ɾ������Ԫ��	
	void Sink(vector<T>& v,unsigned int n,unsigned int i); 
	void Heapfying(vector<T>& v,unsigned int n);
private:
   	vector<T> myArray;
   	unsigned int mySize; //�ѵ�Ԫ�ظ���
};
template <class T>
void heap<T>::add(const T& item){//p651�ϵ��㷨
    //���һ��Ԫ�����,�ѵĹ�ģ����
    unsigned int loc=++mySize; //mySize: ������λ��
    unsigned int parent=loc/2;
    while(parent>=1&&item>myArray[parent]){ //����������
   		myArray[loc]=myArray[parent];
        loc=parent;
        parent=loc/2; 
    }
   //�ں���λ�÷�����Ԫ��
   myArray[loc]=item;                                  
}
template<class T>
void heap<T>::removeTop()
{   myArray[1]=myArray[mySize]; //����βԪ�ظ��ǶѶ�
    mySize-- ; //�ѵĹ�ģ��С
    Sink(myArray,mySize,1); //������   p650�µ��㷨
} 
template<class T>
void heap<T>::deleteAllValues()
{   mySize=0; 
    return myArray.setSize(0); //ɾ����������Ԫ�� 
}


template<class T>
void Swap3(T& a,T& b){T t=a; a=b; b=t;}

template<class T> //�������ڶѶ����µļٶ� p650�µ��㷨
void Sink(vector<T>& v,unsigned int n,unsigned int i)//v-������,n-heapsize,i-position
{   T value=v[i]; //�ٶѶ�
    int l=2*i; //����
    while(l<=n){  	//ȡ�������нϴ��
    	if((l<n)&&v[l]<v[l+1]) l++;   //��i��2�������ӽϴ�           
        if(value<v[l]){ //�ҵ�����λ�ã��ź�
            v[i]=v[l];
            i=l;    
        }      
        else break;
        l=2*i;  
 	}  
    v[i]=value;
}//O(log2n)


//template<class T>
//void Heapfying(vector<T>& data,unsigned int heapsize){//����dataΪ��
//    int lastPos=heapsize;//�ѵ����λ��
//    int RootPos=lastPos/2; //����������
//    while(RootPos>=1){ //û�е������Ѷ������������
//       //������RootPosΪ��������
//        Sink(data,heapsize,RootPos); 
//           
//        RootPos--;  //��һ�������ĸ� 
//    } //O(nlog2n)
template<class T>
void Heapfying(vector<T>& v,unsigned int n){//����dataΪ��-���� 
	for(int i=n/2;i>0;i--)	Sink(v,n,i);//�����һ����֧�ڵ�n/2��ʼ�³�����Ϊ��,ֱ����һ���ڵ� 
}


template<class T>
void HeapSort(vector<T>& v){
   	int n=v.size()-1;
    Heapfying(v,n); //��x�����ɶ�,��ЧԪ��1~x.size()-1
    while(n>1){
		Swap3(v[1],v[n--]);//ͷβ���� 
		Sink(v,n,1);//����1~ n-1֮���Ԫ��Ϊ�� 
	}
} //O(nlog2n)

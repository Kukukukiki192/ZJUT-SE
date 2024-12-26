#include <iostream>
#include <vector>
using namespace std;

template<class T>
void Swap2(T& a,T& b){T t=a; a=b; b=t;}
//ð������ �ƶ���
template<class T> 
void BubbleSort1(vector<T> &x){
	int i,j;
	for(i=0;i<x.size()-1;i++)		//for(i=x.size()-1;i>0;i--)����x.size()-1������ 
		for(j=0;j<x.size()-1-i;j++) //for(j=0;j<i;j++)
			if(x[j]>x[j+1]) Swap2(x[j],x[j+1]);
}

//template<class T>//����flag ��Ԫ�س���(0��λδ����) O(n^2)
//void BubbleSort2(vector<T> &x){
//	int i,j,flag=1;
//	for(i=x.size()-1;i>0&&flag;i--){
//		flag=0;
//		for(j=0;j<i;j++) 
//			if(x[j]>x[j+1]) Swap2(x[j],x[j+1]);
//	}
//}
//0��λ������,�����1~x.size()-1;
template <class T>//����flag  
void BubbleSort2(vector<T>& x){   
	//СԪ���ϸ� ��BubbleSort1�� 
	int n=x.size()-1,i,j,flag=1;				 		
    for(i=1;i<n&&flag!=0;i++){//����x.size()-2������    
	 	flag=0;
        for(j=n;j>i;j--)  								
            if(x[j]<x[j-1]){ 
                Swap2(x[j],x[j+1]);
                flag=1;
            }      
    }
}

//0��λ������,�����1~x.size()-1;
template <class T>
void  BubbleSort3(vector<T>& x){   //ppt�ϲ����߼����� 
	//��Ԫ�س��� ��BubbleSort2�� 
	int numCompares=x.size()-1,last;
    //����numCompares������:����ɨ������Ҫ�ȽϵĶԵ���Ŀ 
    while(numCompares!=1){    
		last=1;//���� 
        for(int j=1;j<numCompares;j++) 
            if(x[j]>x[j+1]){ 
                Swap2(x[j],x[j+1]);
                last=j;
            }   
        numCompares=last;//ð���յ� 
    }
}

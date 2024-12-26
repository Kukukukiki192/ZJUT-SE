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
//Ч��O(n2)������ 
template<class T>
void Swap(T& a,T& b){T t=a; a=b; b=t;}

//ð������ �ƶ���
template<class T> 
void BubbleSort3(vector<T> &x);


//ѡ������ ���ȶ�
template<class T>//-��������  
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
//template<class T>//-�������� 
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


//�������� �ȶ�
template<class T>
void InsertSort(vector<T> &x){//x[1~n] x[0]���x[i]�ĸ��� x.size()=n+1
	int i,j;
	for(i=2;i<=x.size()-1;i++)
		if(x[i]<x[i-1]){
			x[0]=x[i];//x[0]-������
			x[i]=x[i-1];
			for(j=i-2;x[0]<x[j];j--) x[j+1]=x[j];
			x[j+1]=x[0]; 
		} 
}


//ϣ������ 
template<class T>
void ShellInsert(vector<T> &r,int n,int start){//�޸�ֱ�Ӳ�������
 	int i,j;
	for(i=n+start;i<r.size();i+=n)  //r[i]���������ӱ�
        if(r[i]<r[i-n]){ //r[i]��ǰһ��Ԫ��r[i-n]�Ƚ�
		    r[0]=r[i];	 //r[i]�ݴ浽r[0]��,r[0]-������
		    r[i]=r[i-n]; //r[i-n]���� 
            for(j=i-n*2;j>0&&r[0]<r[j];j-=n) //�Ӻ���ǰѰ�Ҳ���λ��,�������,ֱ���ҵ�����λ��
				r[j+n]=r[j];	//r[j]����nλ
            r[j+n]=r[0];		//��r[0]���뵽r[j+n]λ��
		}
}
template<class T>
void ShellSort(vector<T> &r){ 
	int n=r.size()-1,start;
	do{	n=n/3+1;
		for(start=1;start<=n;start++)
			ShellInsert(r,n,start);//һ������Ϊn��ϣ����������
	}while(n>1); 
}


//��������
template<class T> 
void CountedSort(vector<T> &v){
	vector<int> counted(v.size()); //�ݴ�
    vector<T> temp_v(v.size()); //���ݱ���
    for(int i=1;i<v.size();i++){
        counted[i]=0; //������ʼ��       
        temp_v[i]=v[i];        
	}
    //����
    for(int i=1;i<v.size();i++)
        for(int j=i+1;j<v.size();j++)
            if(v[i]>v[j]) counted[i]++;
            else counted[j]++;              
    for(int i=1;i<v.size();i++)  v[counted[i]+1]=temp_v[i];
}


template<class T>
void RadixSort(vector<T> &x);//�������� 

template<class T>//��������
void QuickSort(vector<T> &x);

template<class T>//�������������
void BSTSort(vector<T> &x);

template<class T>//������ O(nlog2n)
void HeapSort(vector<T> &x);

template<class T>
void Display(vector<T> &x){    
	for(int i=1;i<x.size();i++){	
		cout<<setw(5)<<x[i]<<" ";
	    if(i%10==0) cout<<endl;
	}
}

template<class T>
void ResetData(vector<T> &x,vector<T> &y){//ʹ��y����x
	int n=y.size();
	x.reserve(n);
	for(int i=1;i<n;i++) x[i]=y[i];
}

int main(){
	vector<int> a(num+1),b(num+1); 
	//��Ч���ݴ�1��ʼ��Ҳ������ƴ�0��ʼ�����и�����Ҫ����
    int i;
    srand(time(0));//��������ӳ�ʼ��
	for(i=1;i<=num;i++)
	{	a[i]=rand()%10000+1; //�������1-10000�ڵ���ֵ��Ϊ�������
	    b[i]=a[i];
	}
	clock_t start,finish,duration[7];
	//����ǰ��ʾ����
	cout<<"����ǰ"<<endl;
    Display(a);
	//ð������
    BubbleSort3(a);
	cout<<"ð�������"<<endl;
	Display(a);
	
	i=5000;
  	start=clock();
  	while(i--){
  		ResetData(a,b);
  		BubbleSort3(a);
	  }
  	finish=clock(); 
  	duration[0]=finish-start;
  	
    //ѡ������
   	ResetData(a,b);
   	SelectSort(a);
  	cout<<"ѡ�������"<<endl;
   	Display(a);
   	
   	i=5000;
  	start=clock();
  	while(i--){
  		ResetData(a,b);
  		SelectSort(a);
	  }
  	finish=clock(); 
  	duration[1]=finish-start;
  	
   	//��������
//   	ResetData(a,b);
//   	InsertSort(a);
//   	cout<<"���������"<<endl;
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
//   	//ϣ������
//   	ResetData(a,b);
//   	ShellSort(a);
//  	cout<<"ϣ�������"<<endl;
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
    //��������
//   	ResetData(a,b);
//   	CountedSort(a);
//   	cout<<"���������"<<endl;
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
  	
    //��������
//   	ResetData(a,b);
//   	RadixSort(a);
//   	cout<<"���������"<<endl;
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

  	//��������
  	ResetData(a,b);
  	QuickSort(a);
  	cout<<"���������"<<endl;
  	Display(a);
  	
  	i=5000;
  	start=clock();
  	while(i--){
  		ResetData(a,b);
  		QuickSort(a);
	  }
  	finish=clock(); 
  	duration[7]=finish-start;

  	//������
//  	ResetData(a,b);
//  	HeapSort(a); 
//  	cout<<"�������"<<endl; 
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
	
	//   	�����Ʒ��BST����
//   	ResetData(a, b);
//   	BSTSort(a);
//   	cout << "BST�����" << endl;
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

  	cout<<"5000�����ú�������ʱ�Ӷൽ�ٸ�Ϊ(ms):"<<endl;
  	cout<<"��������"<<"\t"<<duration[7]<<endl;
//  	cout<<"ϣ������"<<"\t"<<duration[3]<<endl;
//  	cout<<"��������"<<"\t"<<duration[2]<<endl;
//  	cout<<"��������"<<"\t"<<duration[5]<<endl;
  	cout<<"ѡ������"<<"\t"<<duration[1]<<endl;
  	cout<<"ð������"<<"\t"<<duration[0]<<endl;
//  	cout<<"��������"<<"\t"<<duration[4]<<endl;
//  	cout<<"������  "<<"\t"<<duration[8]<<endl;
//  	cout<<"BST���� "<<"\t"<<duration[6]<<endl;//��2������ʱ�����в��� 
  	return 0;
}



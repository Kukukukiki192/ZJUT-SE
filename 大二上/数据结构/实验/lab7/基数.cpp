#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#include <queue>
#define num 100
using namespace std;
 
template<class T>
int Base(vector<T> x){//��������������Ԫ��λ�� 
//���ﲻҪ������& ��ı�ԭ����,���������Ϊ0 !
	int max=1,bits=0;
	for(int i=2;i<x.size();i++)
		if(x[i]>x[max]) max=i;
	while(x[max]){
		bits++;
		x[max]/=10;
	}
	return bits;
} 
template<class T>
int BitNum(T x,int bit){//��x��bitλ�ϵ��� 
	int t=1;
	for(int i=1;i<bit;i++) t*=10;
	return (x/t)%10;
}
template<class T>//��������P677 �ȶ� 
void RadixSort(vector<T> &x){
	queue<int> q[10];
	int i,j,k,t,base=Base(x);
	for(i=1;i<=base;i++){
		cout<<i<<endl;
		for(j=1;j<x.size();j++){
			int bit=BitNum(x[j],i);
			q[bit].push(x[j]);//�ɷ� 
			cout<<x[j]<<" ";
		}	cout<<endl;	
		for(t=0,k=1;t<10;t++){
			while(!q[t].empty()){
				x[k++]=q[t].front();//�ռ� 
				cout<<q[t].front()<<" ";
				q[t].pop();
			}
		}	cout<<endl;	
	}
}
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
	//����ǰ��ʾ����
	cout<<"����ǰ"<<endl;
    Display(a);
    
	//��������
   	ResetData(a,b);
   	RadixSort(a);
   	cout<<"���������"<<endl;
   	Display(a);
	
	return 0;
}

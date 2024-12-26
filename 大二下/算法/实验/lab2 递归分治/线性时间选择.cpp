#include <cstdlib>
#include <iostream>   
#include <ctime>
#include <set>  
#define N 10000
using namespace std;   
//�����������ѡ��:������������еݹ黮�֣����������ͬ���ǣ���ֻ�Ի��ֳ���������֮һ���еݹ鴦��

void Swap(int &x,int &y)  {  
    int temp = x;  
    x = y;  
    y = temp;  
}  
int Random(int x, int y)  {  
     srand((unsigned)time(0));  
     int ran_num = rand() % (y - x) + x;//����x��y-x-1��������� 
     return ran_num;  
}  
int Partition(int a[],int p,int r) {
    int i = p,j = r + 1;  
    int x = a[p];  
    while(true) {  
        while(a[++i]<x && i<r);  
        while(a[--j]>x);  
        if(i>=j) break;  
        Swap(a[i],a[j]);  
    }  
    a[p] = a[j];  
    a[j] = x;  
    return j;  
}   
int RandomizedPartition(int a[],int p,int r) {  
    int i = Random(p,r);  
    Swap(a[i],a[p]);  
    return Partition(a,p,r);  
}  
int RandomizedSelect(int a[],int p,int r,int k) {  //n��Ԫ�أ�����Ϊ0~n-1 (p~r) 
    if(p == r) return a[p];  
    int i = RandomizedPartition(a,p,r);  
    int j = i - p + 1;  
    if(k <= j) return RandomizedSelect(a,p,i,k); 
    else return RandomizedSelect(a,i+1,r,k-j); 	
	//������֪��������a[p:i]�е�Ԫ�ؾ�С��Ҫ�ҵĵ�kСԪ��  
    //��ˣ�Ҫ�ҵ�a[p:r]�е�kСԪ����a[i+1:r]�е�k-jСԪ�ء� 
} 	//ƽ�����O(n)  ����O(n^2) 

int main()  {  
	int a[N],n,i,x;
	cout<<"�����С:";
	cin>>n;
	cout<<"��������:";
	for(i=0;i<n;i++) cin>>a[i];
	cout<<endl; 
    cout<<"���ֵ="<<RandomizedSelect(a,0,n-1,n)<<endl; //��1��Ԫ��=��nСԪ�� 
    cout<<"��2��ֵ="<<RandomizedSelect(a,0,n-1,n-1)<<endl;
    cout<<"��4��ֵ="<<RandomizedSelect(a,0,n-1,n-3)<<endl;
    
    //�������1e4����������-ͨ��set����ȥ����������������� 
	cout<<"�������10000����������(����1��ʼ):";
	cin>>x;
	if(x==1){
	set<int> b; 
	set<int>::iterator it;
	srand((unsigned)time(0));
//����ʱset��listֻ������size()/2�ĵ��������,������N*2����N������� 
	while(b.size()<2*N){ 
		b.insert(rand());
	}it=b.begin();
	for(i=0;i<N;i++) a[i]=*(it);//�����е�����ֵ������ 
	for(i=N; i>0; --i) Swap(a[i], a[rand()%i]);//������������� 
	for(i=0;i<N;i++){
		if(i%20==0) { cout<<endl; cout<<i+1<<"~"<<i+20<<":"<<'\t'; }
		cout<<*(it++)<<'\t';
	}cout<<endl;
    cout<<"��4999С����="<<RandomizedSelect(a,0,N-1,4999)<<endl;
	}
    return 0;
}  

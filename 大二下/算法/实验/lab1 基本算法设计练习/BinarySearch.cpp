#include<iostream>
#include<cstdlib>
#include<ctime>
#include<set>
using namespace std;
const int N=1e4;
int BinarySearch(int a[],const int& x,int l,int r){
    while(r>=l){ 
    	int m=(l+r)/2;
        if(x==a[m]) return m;
        if(x<a[m]) r=m-1; else l=m+1;
    }
    return -1;
} 
int main(){
	int n,x,i,a[N]; 
	cout<<"�����С:";
	cin>>n;
	cout<<"��������:";
	for(i=0;i<n;i++){
		cin>>x; 
		a[i]=x;
	}
	cout<<"����ҪѰ�ҵ���:";
	cin>>x;
	cout<<"������λ��:";
	int local=BinarySearch(a,x,0,n-1)+1;
	if(local==0) cout<<"�޴���"<<endl;
	else cout<<local<<endl;
	
//�������1e4����������-ͨ��set����ȥ����������������� 
	cout<<"�������10000����������(����1��ʼ):";
	cin>>x;
	if(x==1){
	set<int> b; 
	set<int>::iterator it;
	srand((unsigned)time(0));
	clock_t start,end;
	start=clock(); // ��ʱ����ʼ 
//����ʱset��listֻ������size()/2�ĵ��������,������N*2����N������� 
	while(b.size()<2*N){ 
		b.insert(rand());
	}
	end=clock(); // ��ʱ��ֹͣ 
	it=b.begin();
	for(i=0;i<N;i++){
		if(i%20==0) { cout<<endl; cout<<i+1<<"~"<<i+20<<":"<<'\t'; }
		a[i]=*(it);
		cout<<*(it++)<<'\t';
	}cout<<endl;
	
	cout<<"��ʱ"<<(double)(end-start)*1000/CLOCKS_PER_SEC<<"ms"<<endl;
	cout<<"����ҪѰ�ҵ���:";
	cin>>x;
	cout<<"������λ��:";
	local=BinarySearch(a,x,0,N-1)+1;
	if(local==0) cout<<"�޴���"<<endl;
	else cout<<local<<endl; 
	}
	return 0;
}
//rand()%n���[0,n-1]�����������ȱ��: 
//(1)��n����2�����ɴ���ʱ,��������������ǵȸ��ʵ�
//(2)rand()����������,ֻ������[0,32767]��α�����,����n<=RAND_MAX+1=32768
//ͨ����������ƴ������������ɽ����������
// ����[0,n-1]֮������� 
//long long Rand(long long n){
//	long long result=0;
//	// ����������������1e18,����ʱ��Ч�������ݷ�Χѡ��ÿ������10λ
//	for(int i=0;i<6;i++){
//		result=((result<<10)+rand()%1024)%n;
//	}
//	return result;
//} 

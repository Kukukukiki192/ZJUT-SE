#include<iostream>
using namespace std;
void Perm(int list[],int k,int m){//ȫ���� 
	if(k==m){
		for(int i=0;i<=m;i++)
			cout<<list[i]<<" ";
		cout<<endl;
	}
	else{
		for(int i=k;i<=m;i++){
			std::swap(list[k],list[i]);
			Perm(list,k+1,m);
			std::swap(list[k],list[i]);
		}
	}
}
long long F(int n){//�׳� �ݹ� 
	if(n==0) return 1;
	return n*F(n-1);
}
//long long F(int n){//�׳� �ǵݹ� 
//	if(n==0) return 1;
//	long long sum=1;
//	for(int i=n;i>1;i--){
//		sum*=i;
//	} 
//	return sum;
//}
int main(){
	int i,n,x,list[100];
	cout<<"�����С:";
	cin>>n;
	cout<<"��������:";
	for(i=0;i<n;i++){
		cin>>x;
		list[i]=x;
	}
	cout<<"�������ȫ��������"<<F(n)<<"��(����1��ʼ����):"; 
	cin>>x;
	if(x==1) Perm(list,0,n-1);
	
	n=20;
	for(i=0;i<n;i++){
		list[i]=2*i+1;
	}
	cout<<"ǰ20��������ȫ��������"<<F(n)<<"��(����1��ʼ����):"; //20!=2.4..*10^18
	cin>>x;
	if(x==1) Perm(list,0,n-1);
	
	return 0;
}

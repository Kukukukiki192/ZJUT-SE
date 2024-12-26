#include<iostream>
using namespace std;
void Perm(int list[],int k,int m){//全排列 
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
long long F(int n){//阶乘 递归 
	if(n==0) return 1;
	return n*F(n-1);
}
//long long F(int n){//阶乘 非递归 
//	if(n==0) return 1;
//	long long sum=1;
//	for(int i=n;i>1;i--){
//		sum*=i;
//	} 
//	return sum;
//}
int main(){
	int i,n,x,list[100];
	cout<<"数组大小:";
	cin>>n;
	cout<<"输入数组:";
	for(i=0;i<n;i++){
		cin>>x;
		list[i]=x;
	}
	cout<<"该数组的全排列数有"<<F(n)<<"组(输入1开始排列):"; 
	cin>>x;
	if(x==1) Perm(list,0,n-1);
	
	n=20;
	for(i=0;i<n;i++){
		list[i]=2*i+1;
	}
	cout<<"前20个奇数的全排列数有"<<F(n)<<"组(输入1开始排列):"; //20!=2.4..*10^18
	cin>>x;
	if(x==1) Perm(list,0,n-1);
	
	return 0;
}

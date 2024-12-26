#include <iostream>
#include <fstream> 
#include <string>
#include <map>
using namespace std;
const int n=6,N=297;
double Maxsub(double a[],int n){//T(N)=O(N)在线处理 
	double sum=0,maxsum=0;
    for(int i=0;i<n;i++){ 
    	sum+=a[i];
        if(sum<0) sum = 0;//当a[j]+...+a[k]<0,则舍弃k之前的所有序列,从k后继续累加          
        if(sum>maxsum) maxsum=sum;//求出当前序列的最大子序列和           
    }
    return maxsum;
}
int main(){
	double a[n]; 
	int i,k=0;
	cout<<"输入序列a[6]:";
	for(i=0;i<n;i++){
		cin>>a[i];
	}
	cout<<"最大子段和:"<<Maxsub(a,n)<<endl;
	//读取文件 
	ifstream fin("C:/Users/E470/Desktop/大二下/算法/实验3/太阳黑子.txt");
	if (!fin.is_open()) cout <<"未成功打开文件"<<endl; 
    map<string,double> data;
    string year;
	double value;
	string s; getline(fin,s);//读掉第一行 不存入map 
    while(!fin.eof()){
    	fin>>year>>value;
    	data[year]=value;
    	k++;//累计序列总数 
    	cout<<year<<'\t'<<value<<endl;
	} fin.close();
	string key[N];
	double val[N]; 
	i=0; 
	for(map<string,double>::iterator t=data.begin();t!=data.end();t++){
        key[i]=t->first;
        val[i++]=t->second;
    }
	double sum=0,maxsum=0; 
	int begin,end;//记录最大爆发期的始终 
	for(i=0;i<k-1;i++){
		sum+=val[i]; 
		if(sum>maxsum) { maxsum=sum; end=i;}
		if(val[i]>val[i+1]) sum=0;
	}
	for(i=end;val[i]>val[i-1];i--){} begin=i;
	cout<<"太阳黑子value序列增长最多的子段之和："<<maxsum<<endl;
	cout<<"其最大爆发期为"<<key[begin]<<"年到"<<key[end]<<"年."<<endl; 
	return 0;
}

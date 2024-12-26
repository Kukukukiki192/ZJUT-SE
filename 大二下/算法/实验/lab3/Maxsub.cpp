#include <iostream>
#include <fstream> 
#include <string>
#include <map>
using namespace std;
const int n=6,N=297;
double Maxsub(double a[],int n){//T(N)=O(N)���ߴ��� 
	double sum=0,maxsum=0;
    for(int i=0;i<n;i++){ 
    	sum+=a[i];
        if(sum<0) sum = 0;//��a[j]+...+a[k]<0,������k֮ǰ����������,��k������ۼ�          
        if(sum>maxsum) maxsum=sum;//�����ǰ���е���������к�           
    }
    return maxsum;
}
int main(){
	double a[n]; 
	int i,k=0;
	cout<<"��������a[6]:";
	for(i=0;i<n;i++){
		cin>>a[i];
	}
	cout<<"����Ӷκ�:"<<Maxsub(a,n)<<endl;
	//��ȡ�ļ� 
	ifstream fin("C:/Users/E470/Desktop/�����/�㷨/ʵ��3/̫������.txt");
	if (!fin.is_open()) cout <<"δ�ɹ����ļ�"<<endl; 
    map<string,double> data;
    string year;
	double value;
	string s; getline(fin,s);//������һ�� ������map 
    while(!fin.eof()){
    	fin>>year>>value;
    	data[year]=value;
    	k++;//�ۼ��������� 
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
	int begin,end;//��¼��󱬷��ڵ�ʼ�� 
	for(i=0;i<k-1;i++){
		sum+=val[i]; 
		if(sum>maxsum) { maxsum=sum; end=i;}
		if(val[i]>val[i+1]) sum=0;
	}
	for(i=end;val[i]>val[i-1];i--){} begin=i;
	cout<<"̫������value�������������Ӷ�֮�ͣ�"<<maxsum<<endl;
	cout<<"����󱬷���Ϊ"<<key[begin]<<"�굽"<<key[end]<<"��."<<endl; 
	return 0;
}

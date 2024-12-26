#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#define num 100
using namespace std;
void Merge(const vector<int> &v1,const vector<int> &v2,const vector<int> &v3){
	int i=0,j=0,k=0;
	while(i<=v1.size()-1&&j<=v2.size()-1){
		if(v1[i]<v2[j]) v[k++]=v[i++];
		else if(v1[i]>v2[j]) v[k++]=v[j++];
		else{v[k++]=v[i++]; j++;}//去掉重复 
	}
	while(i<=v1.size()-1){
		v[k++]=v[i++];
	}
	while(j<=v2.size()-1){
		v[k++]=v[j++];
	}
}
void MergeSort(vector<int> &v){
	Merge(v,1,m);
	Merge(v,m+1,v.size());
}



int main(){
	vector<int> a(num),b(num),c(num*2); 
	//有效数据从1开始，也可以设计从0开始，自行根据需要调整
    int i;
    srand(time(0));//随机数种子初始化
	for(i=0;i<=num;i++)
	{	a[i]=rand()%10000+1; //随机生成1-10000内的数值作为排序对象
	    b[i]=a[i];
	}
	clock_t start,finish,duration[7]; 
	//排序前显示数据
	cout<<"排序前"<<endl;
    Display(a);
    
    //归并排序
	 
    
    return 0;
}

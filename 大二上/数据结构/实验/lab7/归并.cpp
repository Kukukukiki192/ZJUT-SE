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
		else{v[k++]=v[i++]; j++;}//ȥ���ظ� 
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
	//��Ч���ݴ�1��ʼ��Ҳ������ƴ�0��ʼ�����и�����Ҫ����
    int i;
    srand(time(0));//��������ӳ�ʼ��
	for(i=0;i<=num;i++)
	{	a[i]=rand()%10000+1; //�������1-10000�ڵ���ֵ��Ϊ�������
	    b[i]=a[i];
	}
	clock_t start,finish,duration[7]; 
	//����ǰ��ʾ����
	cout<<"����ǰ"<<endl;
    Display(a);
    
    //�鲢����
	 
    
    return 0;
}

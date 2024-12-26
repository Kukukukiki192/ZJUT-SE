#include <iostream>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#define N 10000
using namespace std;
//�鲢-�ǵݹ� nlogn
void Merge(int c[],int d[],int l,int m,int r){
  int i=l,j=m+1,k=l,q;
  while( i<=m && j<=r ){
    if(c[i]<=c[j])
      d[k++]=c[i++];
    else
      d[k++]=c[j++];
  }
  if(i>m)
     for(q=j;q<=r;q++)
        d[k++]=c[q];
  else
     for(q=i;q<=m;q++)
        d[k++]=c[q];
}
void MergePass(int x[],int y[],int s,int n){
  int i=0,j;
  while(i<=n-2*s){//�ϲ���СΪs�������Ӷε�y
     Merge(x,y,i,i+s-1,i+2*s-1);
     i+=2*s;
  }
  if(i+s<n) //����ʣ�µ�Ԫ��(����s��������2s��)
    Merge(x,y,i,i+s-1,n-1);
  else //����ʣ�µ�Ԫ��(����s��)
    for(j=i;j<=n-1;j++)
       y[j]=x[j];
}
void MergeSort(int a[],int n){
  int s=1;
  int *b=new int[n];
  while(s<n){
    MergePass(a,b,s,n);//�ϲ�����ʱ�洢����b
    s+=s;
    MergePass(b,a,s,n);//�ϲ�������a
    s+=s;
  }
  delete []b;
}

//����-�ݹ� nlogn
void Swap(int& a,int& b){int t=a; a=b; b=t;}
int Partition (int a[], int l, int r){
        int i = l, j = r,x=a[l]; 
        //��<x�Ľ������������>x�Ľ������ұ�����
        while (i<j) {
           while (a[j]>x && i<r)j--; 
           if(i<j) {
           	Swap(a[i++], a[j]);
		   }
           while (a[i] <=x&&i<j)i++;
           if (i<j){
		   Swap(a[i], a[j--]);
		   }
        }
       return i;
}
void QuickSort(int a[], int l, int r)
{
      if (l<r) {
        int q=Partition(a,l,r); //��a[p]�ֻ�׼Ϊ��������
        QuickSort (a,l,q-1); //����������
        QuickSort (a,q+1,r); //���Ұ������
        }
}

void Display(int x[],int n){    
	for(int i=0;i<n;i++){	
		if(i%20==0) cout<<endl;
		cout<<setw(5)<<x[i]<<" ";
	}cout<<endl;
}
void ResetData(int x[],int y[],int n){//ʹ��y����x
	for(int i=0;i<n;i++) x[i]=y[i];
}

int main(){
	int n,x,i,a[N],b[N]; 
	cout<<"�����С:";
	cin>>n;
	cout<<"��������:";
	for(i=0;i<n;i++){
		cin>>a[i];
		b[i]=a[i];
	}
	cout<<endl;
	cout<<"�鲢�����:"<<endl;
	MergeSort(a,n);
	Display(a,n);
	cout<<"����:"<<endl;
	ResetData(a,b,n);
	Display(a,n);
	cout<<"���������:"<<endl;
	QuickSort(a,0,n-1);//ԭ��д��n�����˺ܾã������������n-1ָ�������һ�� 
	Display(a,n);
	
    srand(time(0));//��������ӳ�ʼ��
	for(i=0;i<N;i++)
	{	a[i]=rand()%10000; //�������0-10000�ڵ���ֵ��Ϊ�������
	    b[i]=a[i];
	}
	clock_t start,end,duration[2]; 
	//����ǰ��ʾ����
	cout<<"����ǰ���������10000������������1��ʼ���:";
    cin>>x; 
	if(x==1){
	Display(a,N);
    
    //�鲢����
  	start=clock();
  	MergeSort(a,N);
  	end=clock(); 
  	duration[0]=end-start;
  	cout<<"�鲢�����:"<<endl;
	Display(a,N);
	cout<<"��ʱ"<<duration[0]<<"ms"<<endl;
  	
    //��������
  	ResetData(a,b,N);
  	start=clock();
  	QuickSort(a,0,N);
  	end=clock(); 
  	duration[1]=end-start;
  	cout<<"���������:"<<endl;
	Display(a,N);
	cout<<"��ʱ"<<duration[1]<<"ms"<<endl;
    }
    return 0;
}

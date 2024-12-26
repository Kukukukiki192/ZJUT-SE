//���ݷ�-���������� 
#include <iostream>
#include <algorithm>
using namespace std;
const int NoEdge=1e4;//�ޱ߱��-�����
const int N=10;

class Traveling{
public:
	void TSP(int **,int);
	void print();
private:		
   	void Backtrack(int);  	 
   	int n,    //ͼG�Ķ�����   
    *x,       //��ǰ��
    *bestx,   //��ǰ���Ž�
   	**g,  	  //ͼG���ڽӾ���
    l,        //��ǰ����
    bestl;    //��ǰ����ֵ
};
void Traveling::TSP(int **g1,int n1){//��ʼ�� 
	n=n1;
	x=new int [n+1];
	bestx=new int [n+1]; 
	for(int i=0;i<=n1;i++){
        x[i]=i;
        bestx[i]=0;
    }
	g=g1; 	
	l=0;  
    bestl=NoEdge;		
    Backtrack(2); //����x[2:n]��ȫ����    
}
void Traveling::print(){//��ӡ·��
    cout<<"���·��:  ";
    for(int i=1;i<=n;i++)
        cout<<bestx[i]<<"->";
    cout<<"1"<<endl;//�ص������� 
    cout<<"���·�����ȣ�"<<bestl;
}
//���ĺ��� �㷨���Ӷ�Ϊ��O(n!)
void Traveling::Backtrack(int i){
	if(i>n){ //���н���   
		if(g[x[n]][1]!=NoEdge && (l+g[x[n]][1]<bestl)) {
		 	for(int j=1;j<=n;j++) bestx[j]=x[j];     
			bestl=l+g[x[n]][1];
		}
	}else{
		for(int j=i;j<=n;j++){//�ɷ����x[j]����,������������
			if(g[x[i-1]][x[j]]!=NoEdge && (l+g[x[i-1]][x[j]]<bestl)){
				swap(x[i],x[j]);  
				l+=g[x[i-1]][x[i]];   
             	Backtrack(i+1);       
				l-=g[x[i-1]][x[i]]; 
				swap(x[i],x[j]);
			}
		}
	}
}

int main(){	
    int u,v,w,n,m;//u,v������ w��u��v���м��·��
    cout<<"���뾰���� n(�����):";
    cin>>n;
    cout<<"���뾰����������(����):";
    cin>>m;
    cout<<"��������2������u��v֮��ľ���w(��ʽ:����u ����v ����w):"<<endl;
    
    int **g;
    g=new int *[N];//��ʼһ��N��N�еľ��� 
    for(int i=0;i<N;i++){
    	g[i]=new int[N];
    }//ע���άָ��ĳ�ʼ�������� 
    for(int i=1;i<=n;i++)//��ʼ��Gͼ 
       for(int j=i;j<=n;j++)
          g[i][j]=g[j][i]=NoEdge;//��ʾ·�����ɴ�
	for(int i=1;i<=m;i++){//����Gͼ 
        cin>>u>>v>>w;
        g[u][v]=g[v][u]=w;
    }
    
    Traveling Y;
    Y.TSP(g,n);
    Y.print();
    return 0;
}

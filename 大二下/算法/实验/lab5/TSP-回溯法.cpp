//回溯法-旅行商问题 
#include <iostream>
#include <algorithm>
using namespace std;
const int NoEdge=1e4;//无边标记-无穷大
const int N=10;

class Traveling{
public:
	void TSP(int **,int);
	void print();
private:		
   	void Backtrack(int);  	 
   	int n,    //图G的顶点数   
    *x,       //当前解
    *bestx,   //当前最优解
   	**g,  	  //图G的邻接矩阵
    l,        //当前费用
    bestl;    //当前最优值
};
void Traveling::TSP(int **g1,int n1){//初始化 
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
    Backtrack(2); //搜索x[2:n]的全排列    
}
void Traveling::print(){//打印路径
    cout<<"最短路径:  ";
    for(int i=1;i<=n;i++)
        cout<<bestx[i]<<"->";
    cout<<"1"<<endl;//回到起点结束 
    cout<<"最短路径长度："<<bestl;
}
//核心函数 算法复杂度为：O(n!)
void Traveling::Backtrack(int i){
	if(i>n){ //排列结束   
		if(g[x[n]][1]!=NoEdge && (l+g[x[n]][1]<bestl)) {
		 	for(int j=1;j<=n;j++) bestx[j]=x[j];     
			bestl=l+g[x[n]][1];
		}
	}else{
		for(int j=i;j<=n;j++){//可否进入x[j]子树,可则搜索子树
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
    int u,v,w,n,m;//u,v：城市 w：u和v城市间的路长
    cout<<"输入景点数 n(结点数):";
    cin>>n;
    cout<<"输入景点间的连线数(边数):";
    cin>>m;
    cout<<"依次输入2个景点u和v之间的距离w(格式:景点u 景点v 距离w):"<<endl;
    
    int **g;
    g=new int *[N];//初始一个N行N列的矩阵 
    for(int i=0;i<N;i++){
    	g[i]=new int[N];
    }//注意二维指针的初始化！！！ 
    for(int i=1;i<=n;i++)//初始化G图 
       for(int j=i;j<=n;j++)
          g[i][j]=g[j][i]=NoEdge;//表示路径不可达
	for(int i=1;i<=m;i++){//更新G图 
        cin>>u>>v>>w;
        g[u][v]=g[v][u]=w;
    }
    
    Traveling Y;
    Y.TSP(g,n);
    Y.print();
    return 0;
}

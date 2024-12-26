//分支限界法-旅行商问题 
#include <iostream>
#include <algorithm>//swap(a,b)
#include <queue>
using namespace std;
const int NoEdge=1e4;//无边标记-无穷大
const int N=10;

class Node{	//定义结点,记录当前结点的解信息
public: 
    int l, 	//当前已走过的路径长度
    id,		//景点序号
    *x;		//记录当前路径
    Node() {}
    Node(int l1,int id1){ l=l1; id=id1; }
};
class Traveling{
public:
	void BBTSP(int **,int);
	void print();
private:	
	void Bfs();		 
   	int n,    //图G的顶点数 
   	**g,  	  //图G的邻接矩阵
   	*bestx,   //当前最优解
    bestl;    //当前最优值
};
//定义队列的优先级.以l为优先级,l值越小,越优先
bool operator<(const Node &a, const Node &b){
    return a.l>b.l;
}
void Traveling::BBTSP(int **g1,int n1){//初始化
	n=n1;
	g=g1; 
	bestl=NoEdge;
	bestx=new int [n+1]; 
	for(int i=0;i<=n1;i++) 
		bestx[i]=0; 	
    Bfs();
}
void Traveling::print(){//打印路径
    cout<<endl;
	cout<<"最短路径:  ";
    for(int i=1;i<=n;i++)
        cout<<bestx[i]<<"->";
    cout<<"1"<<endl;//回到起点结束 
    cout<<"最短路径长度："<<bestl;
}
//Bfs为优先队列式分支限界法搜索  核心函数 算法复杂度为：O(n!)
void Traveling::Bfs(){
    int t; //当前处理的景点序号t
    Node livenode,newnode;//当前扩展结点 新结点 
    priority_queue<Node> q; //创建一个优先队列,优先级为已经走过的路径长度l,l值越小，越优先
    newnode=Node(0,2);//创建根节点
    newnode.x=new int [n+1];//绝对不能少！！！
    for(int i=1;i<=n;i++)
    	newnode.x[i]=i;//初时化根结点的解向量     
    q.push(newnode);//根结点加入优先队列
    cout<<"按优先级出队顺序："<<endl;//用于调试
    while(!q.empty()){
        livenode=q.top();//取出队头元素作为当前扩展结点livenode
        q.pop(); //队头元素出队
        //用于调试
        cout<<"当前结点的id值:"<<livenode.id<<"	当前结点的l值:"<<livenode.l<<endl;
        cout<<"当前结点的解向量:";
        for(int i=1; i<=n; i++)
        	cout<<livenode.x[i];       
        cout<<endl;
        t=livenode.id;//当前处理的景点序号
        //搜到倒数第2个结点时不需要往下搜索
        if(t==n){  //立即判断是否更新最优解
           if(g[livenode.x[n-1]][livenode.x[n]]!=NoEdge && g[livenode.x[n]][1]!=NoEdge &&
             (livenode.l+g[livenode.x[n-1]][livenode.x[n]]+g[livenode.x[n]][1]<bestl)){
                bestl=livenode.l+g[livenode.x[n-1]][livenode.x[n]]+g[livenode.x[n]][1];
                cout<<endl;
                cout<<"当前最优的解向量:";
                for(int i=1;i<=n;i++){
                  bestx[i]=livenode.x[i];
                  cout<<bestx[i];
                }cout<<endl;cout<<endl;
            }
            continue;
        }
        //判断当前结点是否满足限界条件,不满足则不再扩展
       	if(livenode.l>=bestl) continue;
        //扩展-没有到达叶子结点
        for(int j=t; j<=n; j++){//搜索扩展结点的所有分支
            if(g[livenode.x[t-1]][livenode.x[j]]!=NoEdge){//如果x[t-1]景点与x[j]景点有边相连
                int l=livenode.l+g[livenode.x[t-1]][livenode.x[j]];
				if(l<bestl){//有可能得到更短的路线
                    newnode=Node(l,t+1);
                    newnode.x=new int [n+1];//绝对不能少！！！
                    for(int i=1;i<=n;i++)
                    	newnode.x[i]=livenode.x[i];//复制父结点的解向量
                    swap(newnode.x[t], newnode.x[j]);//交换x[t]、x[j]的值
                    q.push(newnode);//新结点入队
                }
            }
        }
    }
}

int main(){
    int u,v,w,n,m;//u,v：城市 w：u和v城市间的路长
    cout<<"输入景点数 n(结点数):";
    cin>>n;
    cout<<"输入景点之间的连线数(边数):";
    cin>>m;
    cout<<"依次输入两个景点u和v之间的距离w(格式:景点u 景点v 距离w):"<<endl;
       
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
    Y.BBTSP(g,n);
    Y.print();
    return 0;
}

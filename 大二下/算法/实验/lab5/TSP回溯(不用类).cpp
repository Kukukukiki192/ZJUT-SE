//回溯法-旅行商问题 
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
const int INF=1e7;//无穷大 
const int N=100;
int g[N][N];	//带权邻接矩阵 
int x[N];       //记录当前路径
int bestx[N];   //记录当前最优路径
int cl;         //当前路径长度
int bestl;      //当前最短路径长度
int n,m;        //城市个数n,边数m
void Traveling(int t){//得到bestx[]和bestl 
    if(t>n){//到达叶子结点
        //终点与起点有边相连且路径长<当前最优值
        //说明找到了一条更好的路径，记录相关信息
        if(g[x[n]][1]!=INF && (cl+g[x[n]][1]<bestl)){
            for(int j=1;j<=n;j++) bestx[j]=x[j];
            bestl=cl+g[x[n]][1];
        }
    }
    else{//没有到达叶子结点
        for(int j=t; j<=n; j++){
            //搜索扩展结点的所有分支
            //如果第t-1个城市与第t个城市有边相连并且有可能得到更短的路线
            if(g[x[t-1]][x[j]]!=INF&&(cl+g[x[t-1]][x[j]]<bestl)){
                //保存第t个要去的城市编号到x[t]中，进入到第t+1层
                swap(x[t], x[j]);//交换两个元素的值
                cl=cl+g[x[t-1]][x[t]];
                Traveling(t+1); //从第t+1层的扩展结点继续搜索
                //第t+1层搜索完毕，回溯到第t层
                cl=cl-g[x[t-1]][x[t]];
                swap(x[t], x[j]);
            }
        }
    }
}
void init(){//初始化
    bestl=INF;
    cl=0;
    for(int i=1;i<=n;i++)
       for(int j=i;j<=n;j++)
          g[i][j]=g[j][i]=INF;//表示路径不可达
    for(int i=0; i<=n;i++){
        x[i]=i;
        bestx[i]=0;
    }
}
void print(){//打印路径
    cout<<"最短路径:  ";
    for(int i=1;i<=n;i++)
        cout<<bestx[i]<<"->";
    cout<<"1"<<endl;//回到起点结束 
    cout<<"最短路径长度："<<bestl;
}
int main(){
    int u, v, w;//u,v：城市 w：u和v城市间的路长
    cout << "输入景点数 n(结点数):";
    cin >> n;
    init();
    cout << "输入景点间的连线数(边数):";
    cin >> m;
    cout << "依次输入2个景点u和v之间的距离w(格式:景点u 景点v 距离w):"<<endl;
    for(int i=1;i<=m;i++){
        cin>>u>>v>>w;
        g[u][v]=g[v][u]=w;
    }
    Traveling(2);//第t=1层只有1个结点 
    print();
    return 0;
}

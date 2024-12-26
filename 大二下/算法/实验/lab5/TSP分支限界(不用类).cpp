//program 6-2
#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
using namespace std;
const int INF=1e7;  //设置无穷大的值为10^7
const int N=100;
double g[N][N];  //景点地图邻接矩阵
int bestx[N];   //记录当前最优路径
double bestl;     //当前最优路径长度
int n,m;       //景点个数n,边数m
struct Node//定义结点,记录当前结点的解信息
{
    double cl; //当前已走过的路径长度
    int id; //景点序号
    int x[N];//记录当前路径
    Node() {}
    Node(double _cl,int _id)
    {
        cl = _cl;
        id = _id;
    }
};

//定义队列的优先级。 以cl为优先级，cl值越小，越优先
bool operator <(const Node &a, const Node &b)
{
    return a.cl>b.cl;
}

//Travelingbfs 为优先队列式分支限界法搜索
double Travelingbfs()
{
    int t; //当前处理的景点序号t
    Node livenode,newnode;//定义当前扩展结点livenode,生成新结点newnode
    priority_queue<Node> q; //创建一个优先队列,优先级为已经走过的路径长度cl,cl值越小，越优先
    newnode=Node(0,2);//创建根节点
    for(int i=1;i<=n;i++)
    {
       newnode.x[i]=i;//初时化根结点的解向量
    }
    q.push(newnode);//根结点加入优先队列
    cout<<"按优先级出队顺序："<<endl;//用于调试
    while(!q.empty())
    {
        livenode=q.top();//取出队头元素作为当前扩展结点livenode
        q.pop(); //队头元素出队
        //用于调试
        cout<<"当前结点的id值:"<<livenode.id<<"当前结点的cl值:"<<livenode.cl<<endl;
        cout<<"当前结点的解向量:";
        for(int i=1; i<=n; i++)
        {
            cout<<livenode.x[i];
        }
        cout<<endl;
        t=livenode.id;//当前处理的景点序号
        // 搜到倒数第2个结点时个景点的时候不需要往下搜索
        if(t==n)  //立即判断是否更新最优解，
            //例如当前找到一个路径(1243)，到达4号结点时，立即判断g[4][3]和g[3][1]是否有边相连，
            //如果有边则判断当前路径长度cl+g[4][3]+g[3][1]<bestl，满足则更新最优值和最优解
        {
           //说明找到了一条更好的路径，记录相关信息
           if(g[livenode.x[n-1]][livenode.x[n]]!=INF&&g[livenode.x[n]][1]!=INF)
             if(livenode.cl+g[livenode.x[n-1]][livenode.x[n]]+g[livenode.x[n]][1]<bestl)
             {
                bestl=livenode.cl+g[livenode.x[n-1]][livenode.x[n]]+g[livenode.x[n]][1];
                cout<<endl;
                cout<<"当前最优的解向量:";
                for(int i=1;i<=n;i++)
                {
                  bestx[i]=livenode.x[i];
                  cout<<bestx[i];
                }
                cout<<endl;
                cout<<endl;
              }
            continue;
        }
        //判断当前结点是否满足限界条件，如果不满足不再扩展
       if(livenode.cl>=bestl)
          continue;
        //扩展
        //没有到达叶子结点
        for(int j=t; j<=n; j++)//搜索扩展结点的所有分支
        {
            if(g[livenode.x[t-1]][livenode.x[j]]!=INF)//如果x[t-1]景点与x[j]景点有边相连
            {
                double cl=livenode.cl+g[livenode.x[t-1]][livenode.x[j]];
                if(cl<bestl)//有可能得到更短的路线
                {
                    newnode=Node(cl,t+1);
                    for(int i=1;i<=n;i++)
                    {
                      newnode.x[i]=livenode.x[i];//复制以前的解向量
                    }
                    swap(newnode.x[t], newnode.x[j]);//交换x[t]、x[j]两个元素的值
                    q.push(newnode);//新结点入队
                }
            }
        }
    }
    return bestl;//返回最优值。
}

void init()//初始化
{
    bestl=INF;
    for(int i=0; i<=n; i++)
    {
        bestx[i]=0;
    }
    for(int i=1;i<=n;i++)
       for(int j=i;j<=n;j++)
          g[i][j]=g[j][i]=INF;//表示路径不可达
}
void print()//打印路径
{
    cout<<endl;
    cout<<"最短路径:  ";
    for(int i=1;i<=n;i++)
        cout<<bestx[i]<<"--->";
    cout<<"1"<<endl;
    cout<<"最短路径长度："<<bestl;
}

int main()
{
    int u, v, w;//u,v代表城市，w代表u和v城市之间路的长度
    cout << "请输入景点数 n(结点数):";
    cin >> n;
    init();
    cout << "请输入景点之间的连线数(边数):";
    cin >> m;
    cout << "请依次输入两个景点u和v之间的距离w,格式:景点u 景点v 距离w:"<<endl;
    for(int i=1;i<=m;i++)
    {
        cin>>u>>v>>w;
        g[u][v]=g[v][u]=w;
    }
    Travelingbfs();
    print();
    return 0;
}

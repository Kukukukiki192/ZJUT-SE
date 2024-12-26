//优先队列式分支限界法 0-1背包问题 (不用类)
#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
using namespace std;
const int N = 10;
bool bestx[N]; //记录最优解
int w[N],v[N];//辅助数组,用于存储排序后的重量和价值

struct Node//定义结点,记录当前结点的解信息
{
    int cp; //cp装入购物车的物品价值
    double up; //价值上界
    int rw; //背包剩余容量
    int id; //物品号
    bool x[N];
    Node() {}
    Node(int _cp, double _up, int _rw, int _id)
    {
        cp = _cp;
        up = _up;
        rw = _rw;
        id = _id;
        memset(x, 0, sizeof(x));
    }
};

struct Goods //定义物品结构体，包含物品重量、价值
{
    int weight;
    int value;
}goods[N];

struct Object//定义辅助物品结构体，包含物品序号和单位重量价值,用于按单位重量价值(价值/重量比)排序
{
    int id; //物品序号
    double d;//单位重量价值
}S[N];

//定义排序优先级按照物品单位重量价值由大到小排序
bool cmp(Object a1,Object a2)
{
    return a1.d>a2.d;
}

//定义队列的优先级。 以up为优先，up值越大，也就越优先
bool operator <(const Node &a, const Node &b)
{
    return a.up<b.up;
}

int bestp,W,n,sumw,sumv;
/*
  bestv 用来记录最优解。
  W为背包的最大容量。
  n为物品的个数。
  sumw 为所有物品的总重量。
  sumv 为所有物品的总价值。
*/

double Bound(Node tnode)
{
    double maxvalue=tnode.cp;//已装入购物车物品价值
    int t=tnode.id;//排序后序号
    //cout<<"t="<<t<<endl;
    double left=tnode.rw;//剩余容量
    while(t<=n&&w[t]<=left)
    {
        maxvalue+=v[t];
       // cout<<"malvalue="<<maxvalue<<endl;
        left-=w[t];
        t++;
    }
    if(t<=n)
        maxvalue+=double(v[t])/w[t]*left;
    //cout<<"malvalue="<<maxvalue<<endl;
    return maxvalue;
}
//priorbfs 为优先队列式分支限界法搜索。
int priorbfs()
{
     int t,tcp,trw;
     double tup; //当前处理的物品序号t，当前装入购物车物品价值tcp，
    //当前装入购物车物品价值上界tup，当前剩余容量trw
    priority_queue<Node> q; //创建一个优先队列,优先级为装入购物车的物品价值上界up
    q.push(Node(0, sumv, W, 1));//初始化,根结点加入优先队列
    while(!q.empty())
    {
        Node livenode, lchild, rchild;//定义三个结点型变量
        livenode=q.top();//取出队头元素作为当前扩展结点livenode
        q.pop(); //队头元素出队
        cout<<"当前结点的id值:"<<livenode.id<<"  当前结点的up值:"<<livenode.up<<endl;
        cout<<"当前结点的解向量:";
        for(int i=1; i<=n; i++)
        {
            cout<<livenode.x[i];
        }
        cout<<endl;
        t=livenode.id;//当前处理的物品序号
        // 搜到最后一个物品的时候不需要往下搜索。
        // 如果当前的购物车没有剩余容量(已经装满)了，不再扩展。
        if(t>n||livenode.rw==0)
        {
            if(livenode.cp>=bestp)//更新最优解和最优值
            {
              cout<<"更新最优解向量:";
              for(int i=1; i<=n; i++)
              {
                bestx[i]=livenode.x[i];
                cout<<bestx[i];
              }
              cout<<endl;
              bestp=livenode.cp;
            }
            continue;
        }
        //判断当前结点是否满足限界条件，如果不满足不再扩展
        if(livenode.up<bestp)
          continue;
        //扩展左孩子
        tcp=livenode.cp; //当前购物车中的价值
        trw=livenode.rw; //购物车剩余容量
        if(trw>=w[t]) //满足约束条件，可以放入购物车
        {
            lchild.cp=tcp+v[t];
            lchild.rw=trw-w[t];
            lchild.id=t+1;
            tup=Bound(lchild); //计算左孩子上界
            lchild=Node(lchild.cp,tup,lchild.rw,lchild.id);//传递参数
            for(int i=1;i<=n;i++)
            {
              lchild.x[i]=livenode.x[i];//复制以前的解向量
            }
            lchild.x[t]=true;
            if(lchild.cp>bestp)//比最优值大才更新
               bestp=lchild.cp;
            q.push(lchild);//左孩子入队
        }
        //扩展右孩子
         rchild.cp=tcp;
         rchild.rw=trw;
         rchild.id=t+1;
         tup=Bound(rchild); //右孩子计算上界
         if(tup>=bestp)//满足限界条件，不放入购物车
         {
            rchild=Node(tcp,tup,trw,t+1);//传递参数
            for(int i=1;i<=n;i++)
            {
              rchild.x[i]=livenode.x[i];//复制以前的解向量
            }
            rchild.x[t]=false;
            q.push(rchild);//右孩子入队
          }
    }
    return bestp;//返回最优值。
}

int main()
{
    bestp=0; //bestv 用来记录最优解
    sumw=0; //sumw为所有物品的总重量。
    sumv=0;   //sum 为所有物品的总价值
    cout << "请输入物品的个数 n:";
    cin >> n;
    cout << "请输入购物车的容量W:";
    cin >> W;
    cout << "请依次输入每个物品的重量w和价值v,用空格分开:"<<endl;
    for(int i=1; i<=n; i++)
    {
        cin >> goods[i].weight >> goods[i].value;//输入第 i 件物品的体积和价值。
        sumw+= goods[i].weight;
        sumv+= goods[i].value;
        S[i-1].id=i;
        S[i-1].d=1.0*goods[i].value/goods[i].weight;
    }
    if(sumw<=W)
    {
        bestp=sumv;
        cout<<"放入购物车的物品最大价值为: "<<bestp<<endl;
        cout<<"所有的物品均放入购物车。";
        return 0;
    }
    sort(S, S+n, cmp);//按价值重量比非递增排序
    cout<<"排序后的物品重量和价值:"<<endl;
    for(int i=1;i<=n;i++)
    {
        w[i]=goods[S[i-1].id].weight;//把排序后的数据传递给辅助数组
        v[i]=goods[S[i-1].id].value;
        cout<<w[i]<<"  "<<v[i]<<endl;
    }
    priorbfs();//优先队列分支限界法搜索
    // 输出最优解
    cout<<"放入购物车的物品最大价值为: "<<bestp<<endl;
    cout<<"放入购物车的物品序号为: ";
    //输出最优解
    for(int i=1;i<=n;i++)
    {
        if(bestx[i])
           cout<<S[i-1].id<<" ";//输出原物品序号(排序前的)
    }
    return 0;
}
//优先队列式的分支限界法生成的结点数更少,能更快找到最优解 

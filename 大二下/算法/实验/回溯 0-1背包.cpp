#include <iostream>
#include <string>
#include <algorithm>
#define M 105
using namespace std;
//所有数组0号位闲置 
int i,j,n,W;//n:物品总数 W:购物车的容量
double w[M],v[M];//w[i]:第i个物品的重量 v[i]:第i个物品的价值
bool x[M]; //x[i]:第i个物品是否放入购物车
double cw;//当前重量
double cp;//当前价值
double bestp;//当前最优价值
bool bestx[M];//当前最优解

//double Bound(int i){//计算上界(已装入物品价值+剩余物品的总价值) O(n) 
//    double rp=0.0;//剩余物品为第i~n种物品
//    while(i<=n){//依次计算剩余物品的价值
//        rp+=v[i];
//        i++;
//    }
//    return cp+rp;
//}
//缩小上界,提高效率 
double Bound(int i){
	double r=W-cw;//剩余容量
	double b=0.0;//剩余物品价值
	while(i<=n&&w[i]<r){//以物品单位重量价值递减序装入物品
		r-=w[i];
		b+=v[i++];
	}
	if(i<=n){//物品没遍历完 用切割方式装满包(求解不可切割,这里只是求上界) 
		b+=v[i]/w[i]*r;
	} 
	return cp+b;
} 
void Backtrack(int t){//用于搜索空间树 t:当前扩展结点层数  *核心函数 O(n*2^n)
    if(t>n){//已到达叶子结点						//最坏情况:O(2^n)左子->约束   /趣学算法P262
        for(j=1;j<=n;j++){							//         O(2^n)右子->限界 
            bestx[j]=x[j];							//总时间复杂度: O(1*2^n+n*2^n)=O(n*2^n)
        }											//仅保留从开始节点到当前扩展节点的路径,最长n 
        bestp=cp;//保存当前最优解					//空间复杂度:O(n) 
        return ;
    }
    if(cw+w[t]<=W){//如果满足约束条件则搜索左子树     O(1)约束函数:不超出W 
        x[t]=1;
        cw+=w[t];
        cp+=v[t];
        Backtrack(t+1);//递推
        cw-=w[t];//回溯 
        cp-=v[t];
    }
    if(Bound(t+1)>bestp){//如果满足限界条件则搜索右子树  O(n)限界函数:优于最优解(可减少生成节点数,降低运行时间) 
        x[t]=0;
        Backtrack(t+1);
    }
}
//优化算法新增内容 
class Obj{
	public: int id;//物品序号 
	public: double p;//单位重量价值 
};
bool cmp(Obj a,Obj b){//以物品单位重量价值递减排序
	return a.p>b.p;
}
//
void Knapsack(double W, int n){
    //初始化
    cw=0;//初始化当前放入购物车的物品重量为0
    cp=0; //初始化当前放入购物车的物品价值为0
    bestp=0; //初始化当前最优价值为0
    double sumw=0.0; //用来统计所有物品的总重量
    double sumv=0.0; //用来统计所有物品的总价值
    //
    Obj Q[n]; 
    double w1[n+1],v1[n+1];//辅助数组,代替排序前数组 
    //
    for(i=1; i<=n; i++){
    	//
    	Q[i-1].id=i;
    	Q[i-1].p=v[i]/w[i];
    	//
        sumv+=v[i];
        sumw+=w[i];
    }
    if(sumw<=W){
        bestp=sumv;
        cout<<"放入购物车的物品最大价值为: "<<bestp<<endl;
        cout<<"所有的物品均放入购物车.";
        return ;
    }
	//sort(arr,arr+SIZE,compare)或sort(begin,end,compare)通过编写compare函数改变sort的排序规则
    sort(Q,Q+n,cmp);//以物品单位重量价值递减排序 		O(nlogn) -> <algorithm> 结构体排序 
    for(i=1;i<=n;i++){//排序后的数据传递给辅助数组 
		w1[i]=w[Q[i-1].id];
		v1[i]=v[Q[i-1].id];
	}
	for(i=1;i<=n;i++){//排序后的数据传递回原数组 
		w[i]=w1[i];
		v[i]=v1[i];
	}
    //
    Backtrack(1);//搜索空间树
    cout<<"放入购物车的物品最大价值为: "<<bestp<<endl;
    cout<<"放入购物车的物品序号为: ";
    for(i=1;i<=n;i++){ //输出最优解
        if(bestx[i]==1) 
//			cout<<i<<" ";
			cout<<Q[i-1].id<<" ";//原物品序号存在id中,排序后被打乱 
    }
    cout<<endl;
}

int main(){
    cout << "请输入物品个数n:";
    cin >> n;
    cout << "请输入购物车容量W:";
    cin >> W;
    cout << "请依次输入每个物品的重量w和价值v,用空格分开:";
    for(i=1;i<=n;i++) cin>>w[i]>>v[i];
    Knapsack(W,n);
    return 0;
}

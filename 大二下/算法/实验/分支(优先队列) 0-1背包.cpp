//优先队列式分支限界法 0-1背包问题 
#include <iostream>
#include <algorithm>
//#include <cstring>
//#include <cmath>
#include <queue>
using namespace std;
const int N = 10;

//定义 
class object{
    friend int Knapsack(int*, int*, int, int, int*)   
public:
    int operator<=(object a) const {
        return (d>=a.d);   
    }    
private:
    int ID;  
	float d; //单位重量价值
};

class bbnode{
	friend Knap<int,int>;
	friend int Knapsack(int*, int* ,int, int, int*);
private:
	bbnode *parent; //指向父结点的指针
	bool LChild; //左儿子结点标志
};

class HeapNode{
	friend Knap<Typew, Typep>;
public:
	operator Typep() const{	return uprofit; }
private:
	Typep uprofit, //结点的价值上界
	profit; //结点所对应的价值
	Typew weight; //结点所相应的重量
	int level; //活结点在子集树中所处的层次号
	bbnode *ptr; //指向活结点在子集树中相应结点的指针
};

class Knap{
	friend Typep Knapsack(Typep*,Typew*,Typew,int);
public:
	Typep MaxKnapsack(); //核心函数
private:
	MaxHeap< HeapNode<Typep,Typew> > *H;
	Typep Bound(int i); //计算结点所相应的价值上界
	void AddLiveNode(Typep up, Typep cp, Typew cw, bool ch, int level);
	bbnode *E; //指向扩展结点的指针
	Typew c;  int n; //背包容量，物品数
	Typew *w; Typep *p; //物品重量数组，物品价值数组
	Typew cw; Typep cp; //当前重量，当前价值
	int *bestx; //最优解
};

//上界函数 
Typep Knap<Typew,Typep>::Bound(int i){//计算上界
    Typew cleft=c-cw; //剩余容量
	Typep b=cp;
	while(i<=n&&w[i]<=cleft){//以物品单位重量价值递减序装入物品
		cleft-=w[i]; 
		b+=p[i];
        i++;   
	}    //采用剩余物品中单位价值最大的物品装满背包(散装)
	if(i<=n) b+=p[i]*cleft/w[i];   
	return b;
}

//核心函数
Typep Knap<Typew,Typep>::MaxKnapsack(){//优先队列式分支界限法, bestx返回最大价值
	H=new MaxHeap<HeapNode<Typep,Typew>>(1000);
	bestx=new int[n+1];
	int i=1; E=0; cw=cp=0; 
	Typep bestp=0;
	Typep up=Bound(1); //价值上界
	while(i!=n+1){//搜索子集空间树    
	//检查当前扩展结点的左儿子结点
	   	Typew wt=cw+w[i];
	   	if(wt<=c){//左儿子结点为可行结点
    		if(cp+p[i]>bestp) bestp=cp+p[i];
			AddLiveNode(up,cp+p[i],cw+w[i],true,i+1);
		}    
		up=Bound(i+1); 
	//检查当前扩展结点的右儿子结点
		if(up>=bestp) AddLiveNode(up,cp,cw,false,i+1); //取下一扩展结点
		HeapNode<Typep,Typew> N;
		H->DeleteMax(N);   
		E=N.ptr; 
      	cw=N.weight; cp=N.profit;
      	up=N.uprofit; i=N.level;
	} //搜索子集空间树while循环结束
	//构造当前最优解
	for(int j=n;j>0;j--){
		bestx[j]=E->LChild;
		E=E->parent;
	}   
	return cp;
}
 

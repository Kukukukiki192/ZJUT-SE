//���ȶ���ʽ��֧�޽編 0-1�������� 
#include <iostream>
#include <algorithm>
//#include <cstring>
//#include <cmath>
#include <queue>
using namespace std;
const int N = 10;

//���� 
class object{
    friend int Knapsack(int*, int*, int, int, int*)   
public:
    int operator<=(object a) const {
        return (d>=a.d);   
    }    
private:
    int ID;  
	float d; //��λ������ֵ
};

class bbnode{
	friend Knap<int,int>;
	friend int Knapsack(int*, int* ,int, int, int*);
private:
	bbnode *parent; //ָ�򸸽���ָ��
	bool LChild; //����ӽ���־
};

class HeapNode{
	friend Knap<Typew, Typep>;
public:
	operator Typep() const{	return uprofit; }
private:
	Typep uprofit, //���ļ�ֵ�Ͻ�
	profit; //�������Ӧ�ļ�ֵ
	Typew weight; //�������Ӧ������
	int level; //�������Ӽ����������Ĳ�κ�
	bbnode *ptr; //ָ��������Ӽ�������Ӧ����ָ��
};

class Knap{
	friend Typep Knapsack(Typep*,Typew*,Typew,int);
public:
	Typep MaxKnapsack(); //���ĺ���
private:
	MaxHeap< HeapNode<Typep,Typew> > *H;
	Typep Bound(int i); //����������Ӧ�ļ�ֵ�Ͻ�
	void AddLiveNode(Typep up, Typep cp, Typew cw, bool ch, int level);
	bbnode *E; //ָ����չ����ָ��
	Typew c;  int n; //������������Ʒ��
	Typew *w; Typep *p; //��Ʒ�������飬��Ʒ��ֵ����
	Typew cw; Typep cp; //��ǰ��������ǰ��ֵ
	int *bestx; //���Ž�
};

//�Ͻ纯�� 
Typep Knap<Typew,Typep>::Bound(int i){//�����Ͻ�
    Typew cleft=c-cw; //ʣ������
	Typep b=cp;
	while(i<=n&&w[i]<=cleft){//����Ʒ��λ������ֵ�ݼ���װ����Ʒ
		cleft-=w[i]; 
		b+=p[i];
        i++;   
	}    //����ʣ����Ʒ�е�λ��ֵ������Ʒװ������(ɢװ)
	if(i<=n) b+=p[i]*cleft/w[i];   
	return b;
}

//���ĺ���
Typep Knap<Typew,Typep>::MaxKnapsack(){//���ȶ���ʽ��֧���޷�, bestx��������ֵ
	H=new MaxHeap<HeapNode<Typep,Typew>>(1000);
	bestx=new int[n+1];
	int i=1; E=0; cw=cp=0; 
	Typep bestp=0;
	Typep up=Bound(1); //��ֵ�Ͻ�
	while(i!=n+1){//�����Ӽ��ռ���    
	//��鵱ǰ��չ��������ӽ��
	   	Typew wt=cw+w[i];
	   	if(wt<=c){//����ӽ��Ϊ���н��
    		if(cp+p[i]>bestp) bestp=cp+p[i];
			AddLiveNode(up,cp+p[i],cw+w[i],true,i+1);
		}    
		up=Bound(i+1); 
	//��鵱ǰ��չ�����Ҷ��ӽ��
		if(up>=bestp) AddLiveNode(up,cp,cw,false,i+1); //ȡ��һ��չ���
		HeapNode<Typep,Typew> N;
		H->DeleteMax(N);   
		E=N.ptr; 
      	cw=N.weight; cp=N.profit;
      	up=N.uprofit; i=N.level;
	} //�����Ӽ��ռ���whileѭ������
	//���쵱ǰ���Ž�
	for(int j=n;j>0;j--){
		bestx[j]=E->LChild;
		E=E->parent;
	}   
	return cp;
}
 

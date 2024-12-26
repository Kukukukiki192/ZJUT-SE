//��֧�޽編-���������� 
#include <iostream>
#include <algorithm>//swap(a,b)
#include <queue>
using namespace std;
const int NoEdge=1e4;//�ޱ߱��-�����
const int N=10;

class Node{	//������,��¼��ǰ���Ľ���Ϣ
public: 
    int l, 	//��ǰ���߹���·������
    id,		//�������
    *x;		//��¼��ǰ·��
    Node() {}
    Node(int l1,int id1){ l=l1; id=id1; }
};
class Traveling{
public:
	void BBTSP(int **,int);
	void print();
private:	
	void Bfs();		 
   	int n,    //ͼG�Ķ����� 
   	**g,  	  //ͼG���ڽӾ���
   	*bestx,   //��ǰ���Ž�
    bestl;    //��ǰ����ֵ
};
//������е����ȼ�.��lΪ���ȼ�,lֵԽС,Խ����
bool operator<(const Node &a, const Node &b){
    return a.l>b.l;
}
void Traveling::BBTSP(int **g1,int n1){//��ʼ��
	n=n1;
	g=g1; 
	bestl=NoEdge;
	bestx=new int [n+1]; 
	for(int i=0;i<=n1;i++) 
		bestx[i]=0; 	
    Bfs();
}
void Traveling::print(){//��ӡ·��
    cout<<endl;
	cout<<"���·��:  ";
    for(int i=1;i<=n;i++)
        cout<<bestx[i]<<"->";
    cout<<"1"<<endl;//�ص������� 
    cout<<"���·�����ȣ�"<<bestl;
}
//BfsΪ���ȶ���ʽ��֧�޽編����  ���ĺ��� �㷨���Ӷ�Ϊ��O(n!)
void Traveling::Bfs(){
    int t; //��ǰ����ľ������t
    Node livenode,newnode;//��ǰ��չ��� �½�� 
    priority_queue<Node> q; //����һ�����ȶ���,���ȼ�Ϊ�Ѿ��߹���·������l,lֵԽС��Խ����
    newnode=Node(0,2);//�������ڵ�
    newnode.x=new int [n+1];//���Բ����٣�����
    for(int i=1;i<=n;i++)
    	newnode.x[i]=i;//��ʱ�������Ľ�����     
    q.push(newnode);//�����������ȶ���
    cout<<"�����ȼ�����˳��"<<endl;//���ڵ���
    while(!q.empty()){
        livenode=q.top();//ȡ����ͷԪ����Ϊ��ǰ��չ���livenode
        q.pop(); //��ͷԪ�س���
        //���ڵ���
        cout<<"��ǰ����idֵ:"<<livenode.id<<"	��ǰ����lֵ:"<<livenode.l<<endl;
        cout<<"��ǰ���Ľ�����:";
        for(int i=1; i<=n; i++)
        	cout<<livenode.x[i];       
        cout<<endl;
        t=livenode.id;//��ǰ����ľ������
        //�ѵ�������2�����ʱ����Ҫ��������
        if(t==n){  //�����ж��Ƿ�������Ž�
           if(g[livenode.x[n-1]][livenode.x[n]]!=NoEdge && g[livenode.x[n]][1]!=NoEdge &&
             (livenode.l+g[livenode.x[n-1]][livenode.x[n]]+g[livenode.x[n]][1]<bestl)){
                bestl=livenode.l+g[livenode.x[n-1]][livenode.x[n]]+g[livenode.x[n]][1];
                cout<<endl;
                cout<<"��ǰ���ŵĽ�����:";
                for(int i=1;i<=n;i++){
                  bestx[i]=livenode.x[i];
                  cout<<bestx[i];
                }cout<<endl;cout<<endl;
            }
            continue;
        }
        //�жϵ�ǰ����Ƿ������޽�����,������������չ
       	if(livenode.l>=bestl) continue;
        //��չ-û�е���Ҷ�ӽ��
        for(int j=t; j<=n; j++){//������չ�������з�֧
            if(g[livenode.x[t-1]][livenode.x[j]]!=NoEdge){//���x[t-1]������x[j]�����б�����
                int l=livenode.l+g[livenode.x[t-1]][livenode.x[j]];
				if(l<bestl){//�п��ܵõ����̵�·��
                    newnode=Node(l,t+1);
                    newnode.x=new int [n+1];//���Բ����٣�����
                    for(int i=1;i<=n;i++)
                    	newnode.x[i]=livenode.x[i];//���Ƹ����Ľ�����
                    swap(newnode.x[t], newnode.x[j]);//����x[t]��x[j]��ֵ
                    q.push(newnode);//�½�����
                }
            }
        }
    }
}

int main(){
    int u,v,w,n,m;//u,v������ w��u��v���м��·��
    cout<<"���뾰���� n(�����):";
    cin>>n;
    cout<<"���뾰��֮���������(����):";
    cin>>m;
    cout<<"����������������u��v֮��ľ���w(��ʽ:����u ����v ����w):"<<endl;
       
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
    Y.BBTSP(g,n);
    Y.print();
    return 0;
}

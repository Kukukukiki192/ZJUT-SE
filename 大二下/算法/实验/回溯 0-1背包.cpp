#include <iostream>
#include <string>
#include <algorithm>
#define M 105
using namespace std;
//��������0��λ���� 
int i,j,n,W;//n:��Ʒ���� W:���ﳵ������
double w[M],v[M];//w[i]:��i����Ʒ������ v[i]:��i����Ʒ�ļ�ֵ
bool x[M]; //x[i]:��i����Ʒ�Ƿ���빺�ﳵ
double cw;//��ǰ����
double cp;//��ǰ��ֵ
double bestp;//��ǰ���ż�ֵ
bool bestx[M];//��ǰ���Ž�

//double Bound(int i){//�����Ͻ�(��װ����Ʒ��ֵ+ʣ����Ʒ���ܼ�ֵ) O(n) 
//    double rp=0.0;//ʣ����ƷΪ��i~n����Ʒ
//    while(i<=n){//���μ���ʣ����Ʒ�ļ�ֵ
//        rp+=v[i];
//        i++;
//    }
//    return cp+rp;
//}
//��С�Ͻ�,���Ч�� 
double Bound(int i){
	double r=W-cw;//ʣ������
	double b=0.0;//ʣ����Ʒ��ֵ
	while(i<=n&&w[i]<r){//����Ʒ��λ������ֵ�ݼ���װ����Ʒ
		r-=w[i];
		b+=v[i++];
	}
	if(i<=n){//��Ʒû������ ���иʽװ����(��ⲻ���и�,����ֻ�����Ͻ�) 
		b+=v[i]/w[i]*r;
	} 
	return cp+b;
} 
void Backtrack(int t){//���������ռ��� t:��ǰ��չ������  *���ĺ��� O(n*2^n)
    if(t>n){//�ѵ���Ҷ�ӽ��						//����:O(2^n)����->Լ��   /Ȥѧ�㷨P262
        for(j=1;j<=n;j++){							//         O(2^n)����->�޽� 
            bestx[j]=x[j];							//��ʱ�临�Ӷ�: O(1*2^n+n*2^n)=O(n*2^n)
        }											//�������ӿ�ʼ�ڵ㵽��ǰ��չ�ڵ��·��,�n 
        bestp=cp;//���浱ǰ���Ž�					//�ռ临�Ӷ�:O(n) 
        return ;
    }
    if(cw+w[t]<=W){//�������Լ������������������     O(1)Լ������:������W 
        x[t]=1;
        cw+=w[t];
        cp+=v[t];
        Backtrack(t+1);//����
        cw-=w[t];//���� 
        cp-=v[t];
    }
    if(Bound(t+1)>bestp){//��������޽�����������������  O(n)�޽纯��:�������Ž�(�ɼ������ɽڵ���,��������ʱ��) 
        x[t]=0;
        Backtrack(t+1);
    }
}
//�Ż��㷨�������� 
class Obj{
	public: int id;//��Ʒ��� 
	public: double p;//��λ������ֵ 
};
bool cmp(Obj a,Obj b){//����Ʒ��λ������ֵ�ݼ�����
	return a.p>b.p;
}
//
void Knapsack(double W, int n){
    //��ʼ��
    cw=0;//��ʼ����ǰ���빺�ﳵ����Ʒ����Ϊ0
    cp=0; //��ʼ����ǰ���빺�ﳵ����Ʒ��ֵΪ0
    bestp=0; //��ʼ����ǰ���ż�ֵΪ0
    double sumw=0.0; //����ͳ��������Ʒ��������
    double sumv=0.0; //����ͳ��������Ʒ���ܼ�ֵ
    //
    Obj Q[n]; 
    double w1[n+1],v1[n+1];//��������,��������ǰ���� 
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
        cout<<"���빺�ﳵ����Ʒ����ֵΪ: "<<bestp<<endl;
        cout<<"���е���Ʒ�����빺�ﳵ.";
        return ;
    }
	//sort(arr,arr+SIZE,compare)��sort(begin,end,compare)ͨ����дcompare�����ı�sort���������
    sort(Q,Q+n,cmp);//����Ʒ��λ������ֵ�ݼ����� 		O(nlogn) -> <algorithm> �ṹ������ 
    for(i=1;i<=n;i++){//���������ݴ��ݸ��������� 
		w1[i]=w[Q[i-1].id];
		v1[i]=v[Q[i-1].id];
	}
	for(i=1;i<=n;i++){//���������ݴ��ݻ�ԭ���� 
		w[i]=w1[i];
		v[i]=v1[i];
	}
    //
    Backtrack(1);//�����ռ���
    cout<<"���빺�ﳵ����Ʒ����ֵΪ: "<<bestp<<endl;
    cout<<"���빺�ﳵ����Ʒ���Ϊ: ";
    for(i=1;i<=n;i++){ //������Ž�
        if(bestx[i]==1) 
//			cout<<i<<" ";
			cout<<Q[i-1].id<<" ";//ԭ��Ʒ��Ŵ���id��,����󱻴��� 
    }
    cout<<endl;
}

int main(){
    cout << "��������Ʒ����n:";
    cin >> n;
    cout << "�����빺�ﳵ����W:";
    cin >> W;
    cout << "����������ÿ����Ʒ������w�ͼ�ֵv,�ÿո�ֿ�:";
    for(i=1;i<=n;i++) cin>>w[i]>>v[i];
    Knapsack(W,n);
    return 0;
}

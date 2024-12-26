#include <iostream>
using namespace std;
const int N=50,M=100;
string Rname[M];	//��Դ���� 
int resource[M];	//��Դ���� 
int available[M];	//ʣ�� 
int claim[N][M];	//���� n������ m����Դ 
int alloc[N][M];	//���� 
int need[N][M];		//����:need=claim-alloc
int finish[N];		//��ɱ�־ 
int p[N];			//��ȫ���� 
int request[N][M];	//������Դ 

//��ȫ״̬����㷨
bool safe (int n,int m){//ע����n��m!!! 
	int i,j,l=0; 
	int work[M];//ϵͳ���ṩ�ĸ�����Դ��Ŀ,���Ա���ԭ���ݽṹ�й�ֵ
	for (i=0;i<m;i++)
        work[i]=available[i];
    for (i=0;i<n;i++)
        finish[i]=0;
	for (i=0;i<n;i++){
        if (finish[i]==1) continue;
        else{//����finish[i]==0
            for (j=0;j<m;j++){
                if (need[i][j]>work[j]) break;
            }
            if (j==m){//����need<=work 
                finish[i]=1;
                for(int k=0;k<m;k++)
                    work[k]+=alloc[i][k];
                p[l++]=i;
                i=-1;//����i ��ͷ���δִ�еĽ��� 
            }else continue;
        }
        if (l==n){//��ȫ����װ�� ���н��̽��� 
            cout<<"ϵͳ�ǰ�ȫ��.��ȫ���У�"; 
            for (i=0;i<l;i++) {
                cout<<p[i];
                if (i!=l-1) cout<<"-->";
            }cout<<endl;
            return true;
        }
    }
    return false; 
}

//���м��㷨
int main(){
    int i,j,m,n,pi;
    cout<<"����n�����̺�m��������Դϵͳ����Ϣ.\n";
    cout<<"������Ŀ:\n";
    cin>>n;
    cout<<"��Դ����:\n";
    cin>>m;
    cout<<"ÿ����Դ�����ƺ�����: [resource-R]\n";
    for (i=0;i<m;i++){
    	cout<<"��Դ"<<i+1<<":";
    	cin>>Rname[i]>>resource[i];
    }
    cout<<"ÿ�����̶Ը�����Դ�����������(��"<<n<<"*"<<m<<"��������): [claim-C]\n";
    for (i=0;i<n;i++)
        for(j=0;j<m;j++)
            cin>>claim[i][j];
    cout<<"ÿ�������ѷ��䵽�ĸ�����Դ��(��"<<n<<"*"<<m<<"��������): [allocation-A]\n";
    for (i=0;i<n;i++)
        for(j=0;j<m;j++){
            cin>>alloc[i][j];
            need[i][j]=claim[i][j]-alloc[i][j];
            if (need[i][j]<0){
                cout<<"������ĵ�"<<i+1<<"��������ռ�еĵ�"<<j+1<<"����Դ��������������:\n";
                j--;
                continue;
            }
        }
    for (j=0;j<m;j++){
    	int sum=0;
        for (i=0;i<n;i++){
        	sum+=alloc[i][j];
		}
		available[j]=resource[j]-sum;
	}
    	
    cout<<endl;
    cout<<"��Դ���������[need- C-A,available-V]\n";
    cout<<"----------------------------------------------\n";
    cout<<"\t"<<"C"<<"\t"<<"A"<<"\t"<<"C-A\n";
    cout<<"Pi"<<"\t";
    for (j=0;j<3;j++){
	    for (i=0;i<m;i++)
	    	cout<<Rname[i]<<" ";
	    cout<<"\t";
	}cout<<endl;
	for (i=0;i<n;i++){
		cout<<i<<"\t";
		for(j=0;j<m;j++){
			cout<<claim[i][j]<<" ";
		}cout<<"\t";
		for(j=0;j<m;j++){
			cout<<alloc[i][j]<<" ";
		}cout<<"\t";
		for(j=0;j<m;j++){
			cout<<need[i][j]<<" ";
		}cout<<endl;
	}cout<<endl;
	cout<<"\t";
	for (i=0;i<m;i++)
	    cout<<Rname[i]<<" ";
	cout<<endl;
	cout<<"R"<<"\t";
	for (i=0;i<m;i++)
    	cout<<resource[i]<<" ";
    cout<<endl;
    cout<<"V"<<"\t";
	for (i=0;i<m;i++)
    	cout<<available[i]<<" ";
	cout<<"\n\n";

	safe(n,m);
	cout<<"----------------------------------------------"<<endl;
	cout<<"����������Դ����Ϣ.\n";
    while (1){
        cout<<"Ҫ������Դ�Ľ��̺�:\n";
        cin>>pi;
        cout<<"����������ĸ�����Դ������:\n";
        for (i=0;i<m;i++) cin>>request[pi][i];
        for (i=0;i<m;i++){
            if (request[pi][i]>need[pi][i]){
                cout<<"������Դ������������������\n";
                return 0;
            }
            if (request[pi][i]>available[i]){
                cout<<"������Դ������������Դ����\n";
                return 0;
            }
        }
        for (i=0;i<m;i++){//ϵͳ�Է��� ����ϵͳ״̬ 
            available[i]-=request[pi][i];
            alloc[pi][i]+=request[pi][i];
            need[pi][i]-=request[pi][i];
        }
        if (safe(n,m)) cout<<"����ɹ���\n";//����ԭ��д��safe(m,n)��������ȫ����ʱ�������һ�� 
        else{
            cout<<"����ʧ�ܣ�����P"<<pi<<"�ȴ�...\n";
            for (i=0;i<m;i++){//�ָ�ԭ������Դ����״̬,�ý��̵ȴ�(��������)
                available[i]+=request[pi][i];
                alloc[pi][i]-=request[pi][i];
                need[pi][i]+=request[pi][i];
            }
        }
        
        for (i=0;i<n;i++) finish[i]=0;//������ɱ�־ 
        char Flag;//��־λ
        cout<<"\n�Ƿ��ٴ�������Դ(Y/N)?";
        while (1){
            cin>>Flag;
            if (Flag=='Y'||Flag=='y'||Flag=='N'||Flag=='n') break;
            else {
                cout<<"�밴Ҫ����������.\n\n";
                continue;
            }
        }
        if (Flag=='Y'||Flag=='y') continue;
        else break;
    }
	return 0;
}

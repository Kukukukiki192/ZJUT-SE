#include <iostream>
using namespace std;
const int N=50,M=100;
string Rname[M];	//资源名称 
int resource[M];	//资源总量 
int available[M];	//剩余 
int claim[N][M];	//总需 n个进程 m种资源 
int alloc[N][M];	//分配 
int need[N][M];		//还需:need=claim-alloc
int finish[N];		//完成标志 
int p[N];			//安全序列 
int request[N][M];	//请求资源 

//安全状态检查算法
bool safe (int n,int m){//注意先n后m!!! 
	int i,j,l=0; 
	int work[M];//系统可提供的各类资源数目,用以保护原数据结构有关值
	for (i=0;i<m;i++)
        work[i]=available[i];
    for (i=0;i<n;i++)
        finish[i]=0;
	for (i=0;i<n;i++){
        if (finish[i]==1) continue;
        else{//满足finish[i]==0
            for (j=0;j<m;j++){
                if (need[i][j]>work[j]) break;
            }
            if (j==m){//满足need<=work 
                finish[i]=1;
                for(int k=0;k<m;k++)
                    work[k]+=alloc[i][k];
                p[l++]=i;
                i=-1;//重置i 从头检查未执行的进程 
            }else continue;
        }
        if (l==n){//安全序列装满 所有进程结束 
            cout<<"系统是安全的.安全序列："; 
            for (i=0;i<l;i++) {
                cout<<p[i];
                if (i!=l-1) cout<<"-->";
            }cout<<endl;
            return true;
        }
    }
    return false; 
}

//银行家算法
int main(){
    int i,j,m,n,pi;
    cout<<"输入n个进程和m种类型资源系统的信息.\n";
    cout<<"进程数目:\n";
    cin>>n;
    cout<<"资源种类:\n";
    cin>>m;
    cout<<"每种资源的名称和总量: [resource-R]\n";
    for (i=0;i<m;i++){
    	cout<<"资源"<<i+1<<":";
    	cin>>Rname[i]>>resource[i];
    }
    cout<<"每个进程对各类资源的最大需求量(按"<<n<<"*"<<m<<"矩阵输入): [claim-C]\n";
    for (i=0;i<n;i++)
        for(j=0;j<m;j++)
            cin>>claim[i][j];
    cout<<"每个进程已分配到的各类资源数(按"<<n<<"*"<<m<<"矩阵输入): [allocation-A]\n";
    for (i=0;i<n;i++)
        for(j=0;j<m;j++){
            cin>>alloc[i][j];
            need[i][j]=claim[i][j]-alloc[i][j];
            if (need[i][j]<0){
                cout<<"你输入的第"<<i+1<<"个进程所占有的第"<<j+1<<"个资源错误，请重新输入:\n";
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
    cout<<"资源分配情况：[need- C-A,available-V]\n";
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
	cout<<"输入申请资源的信息.\n";
    while (1){
        cout<<"要申请资源的进程号:\n";
        cin>>pi;
        cout<<"进程所请求的各个资源的数量:\n";
        for (i=0;i<m;i++) cin>>request[pi][i];
        for (i=0;i<m;i++){
            if (request[pi][i]>need[pi][i]){
                cout<<"请求资源数超过进程需求量！\n";
                return 0;
            }
            if (request[pi][i]>available[i]){
                cout<<"请求资源数超过可用资源数！\n";
                return 0;
            }
        }
        for (i=0;i<m;i++){//系统试分配 更新系统状态 
            available[i]-=request[pi][i];
            alloc[pi][i]+=request[pi][i];
            need[pi][i]-=request[pi][i];
        }
        if (safe(n,m)) cout<<"分配成功！\n";//这里原来写成safe(m,n)造成输出安全序列时少了最后一个 
        else{
            cout<<"分配失败！进程P"<<pi<<"等待...\n";
            for (i=0;i<m;i++){//恢复原来的资源分配状态,让进程等待(阻塞进程)
                available[i]+=request[pi][i];
                alloc[pi][i]-=request[pi][i];
                need[pi][i]+=request[pi][i];
            }
        }
        
        for (i=0;i<n;i++) finish[i]=0;//重置完成标志 
        char Flag;//标志位
        cout<<"\n是否再次请求资源(Y/N)?";
        while (1){
            cin>>Flag;
            if (Flag=='Y'||Flag=='y'||Flag=='N'||Flag=='n') break;
            else {
                cout<<"请按要求重新输入.\n\n";
                continue;
            }
        }
        if (Flag=='Y'||Flag=='y') continue;
        else break;
    }
	return 0;
}

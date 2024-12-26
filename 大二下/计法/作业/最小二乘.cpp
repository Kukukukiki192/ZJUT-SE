#include<iostream>
#include<cmath>
#include<iomanip>
using namespace std;
int main(){
    cout<<"����ڵ����:";
    int i,j,k,num,weishu;//�����ά��
    cin>>num;
    double *x=new double[num];
    double *y=new double[num];
    cout<<"��������x:";
    for(i=0;i<num;i++) cin>>x[i];
    cout<<"��������y:";
    for(i=0;i<num;i++) cin>>y[i];

	cout<<"------------------------------------------------------------"<<endl;
	cout<<"����ζ���ʽ"<<endl;
    double r1[3][4]={0};

    for(i=0;i<3;i++){
        for(j=0;j<3;j++){
            for(k=0;k<num;k++) r1[i][j]+=pow(x[k],i+j);
        }
    }
    for(i=0;i<3;i++){
        for(k=0;k<num;k++) r1[i][3]+=pow(x[k],i)*y[k];
    }

    weishu=3;
   	cout<<"ԭ����:"<<endl;
    for(i=0;i<weishu;i++){
        for(j=0; j<weishu+1;j++) cout<<setw(10)<<left<<r1[i][j]<<" ";
        cout<<endl;
    }
   	cout<<"ת��Ϊ��������ʽ:"<<endl;
    for(i=0;i<weishu;i++){
        double max=r1[i][i];
       	int index=i;
      	for(j=i+1;j<weishu;j++){
        	if(max<r1[j][i]) { max=r1[j][i]; index=j;}
       	}
        if(i!=index) swap(r1[i],r1[index]);//�б仯�������ֵ�ᵽ��ǰ��
        for(j=i+1;j<weishu;j++){//jΪ��
            double m=r1[j][i];
            for(k=i;k<weishu+1;k++) r1[j][k]=r1[j][k]-m*(r1[i][k]/r1[i][i]);//kΪ�����е�ÿ��Ԫ��
        }
    }
    for(i=0;i<weishu;i++){
         for(j=0;j<weishu+1;j++) cout<<setw(10)<<left<<r1[i][j]<< " ";
         cout<<endl;
    }
    cout<<"a0,a1,a2�Ľ⣺";
    double x1[weishu]={0};
    x1[weishu-1]=r1[weishu-1][weishu]/r1[weishu-1][weishu-1];
    for(i=weishu-2;i>=0;i--){
        double sum=0;
        for(j=0;j<=3;j++) sum+=(x1[j]*r1[i][j]);
        x1[i]=(r1[i][weishu]-sum)/r1[i][i];
    }
    for(i=0;i<weishu;i++) cout<<x1[i]<<" ";
    cout<<endl;
    cout<<"���ζ���ʽΪ��p(x)="<<x1[0]<<x1[1]<<"*x+"<<x1[2]<<"*x^2"<<endl;

	cout<<"------------------------------------------------------------"<<endl;
    cout<<"�����ζ���ʽ"<<endl;
    double r2[4][5]={0};

    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            for(k=0;k<num;k++) r2[i][j]+=pow(x[k],i+j);
        }
    }
    for(i=0;i<4;i++){
        for(k=0;k<num;k++) r2[i][4]+=pow(x[k],i)*y[k];
    }

    weishu=4;
   	cout<<"ԭ����:"<<endl;
    for(i=0;i<weishu;i++){
        for(j=0;j<weishu+1;j++){
            cout<<setw(10)<<left<<r2[i][j]<< " ";
        }cout<<endl;
    }
   	cout<<"ת��Ϊ��������ʽ:"<<endl;
    for(i=0;i<weishu;i++){
        double max=r2[i][i];
       	int index=i;
       	for(j=i+1;j<weishu;j++){
        	if(max<r2[j][i]){ max=r2[j][i]; index=j;}
       	}
        if(i!=index) swap(r2[i],r2[index]);//�б仯�������ֵ�ᵽ��ǰ��(����Ԫ��Ԫ����Ҫ����)
        for(j=i+1;j<weishu;j++){//jΪ��
            double m=r2[j][i];
            for(k=i;k<weishu+1;k++) r2[j][k]=r2[j][k]-m*(r2[i][k]/r2[i][i]);//kΪ�����е�ÿ��Ԫ��                         
        }
    }
    for(i=0;i<weishu;i++){
        for(j=0;j<weishu+1;j++) cout<<setw(10)<<left<<r2[i][j]<<" ";
        cout<<endl;
    }
    cout<<"a0,a1,a2,a3�Ľ�:";
    double x2[weishu]={0};
    x2[weishu-1]=r2[weishu-1][weishu]/r2[weishu-1][weishu-1];
    for(i=weishu-2;i>=0;i--){
        double sum=0;
        for(j=0;j<=3;j++) sum+=(x2[j]*r2[i][j]);
        x2[i]=(r2[i][weishu]-sum)/r2[i][i];
    }
    for(i =0;i<weishu;i++) cout<<x2[i]<<" ";
    cout<<endl;
    cout<<"���ζ���ʽΪ��p(x)="<<x2[0]<<x2[1]<<"*x+"<<x2[2]<<"*x^2+"<<x2[3]<<"*x^3."<<endl;
}

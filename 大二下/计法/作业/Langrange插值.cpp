#include<iostream>
using namespace std;
int main(){
	int i,k;
	double a[3]={0.15,0.37,0.47},b[3],//数组b存放计算结果 
	x[6]={0.0,0.1,0.195,0.3,0.401,0.5},
	y[6]={0.39894,0.39695,0.39142,0.38138,0.36812,0.35206};
	
	cout<<"线性插值计算结果："<<endl;
	for(k=0;k<3;k++)
		for(i=0;i<5;i++){
			if(a[k]>x[i]&&a[k]<x[i+1]){
				b[k]=y[i]+(y[i+1]-y[i])*(a[k]-x[i])/(x[i+1]-x[i]);//化简后的式子
				printf("f(%.2f)=%.5f\n",a[k],b[k]); //输出结果 
			}
		}
	
	cout<<"二次插值计算结果："<<endl;
	for(k=0;k<3;k++)
		for(i=0;i<5;i++){
			if(a[k]>x[i]&&a[k]<x[i+1]&&i<=3){
				b[k]=y[i]*(a[k]-x[i+1])*(a[k]-x[i+2])/((x[i]-x[i+1])*(x[i]-x[i+2]))
					+y[i+1]*(a[k]-x[i])*(a[k]-x[i+2])/((x[i+1]-x[i])*(x[i+1]-x[i+2]))
					+y[i+2]*(a[k]-x[i])*(a[k]-x[i+1])/((x[i+2]-x[i])*(x[i+2]-x[i+1]));
				printf("f(%.2f)=%.5f\n",a[k],b[k]);
			}
			else if(a[k]>x[i]&&a[k]<x[i+1]&&i>3){
				b[k]=y[i-1]*(a[k]-x[i])*(a[k]-x[i+1])/((x[i-1]-x[i])*(x[i-1]-x[i+1]))
					+y[i]*(a[k]-x[i-1])*(a[k]-x[i+1])/((x[i]-x[i-1])*(x[i]-x[i+1]))
					+y[i+1]*(a[k]-x[i-1])*(a[k]-x[i])/((x[i+1]-x[i-1])*(x[i+1]-x[i]));
				printf("f(%.2f)=%.5f\n",a[k],b[k]);  
			}
		}
	
	cout<<"拉格朗日插值计算结果："<<endl;
	double sum,mul; int j;
	for(k=0;k<3;k++){
		sum=0;
		for(j=0;j<6;j++){
			mul=1;
			for(i=0;i<6;i++){
				if(i!=j) mul*=(a[k]-x[i])/(x[j]-x[i]);
			}sum+=y[j]*mul;
		}b[k]=sum;
		printf("f(%.2f)=%.5f\n",a[k],b[k]); 
	}
		
	return 0;	
}

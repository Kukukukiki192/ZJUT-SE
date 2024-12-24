#include<iostream>
using namespace std;
int main()
{const int n=10;
int a[n],i,x,min,max,mid;
cout<<"输入一个有序的一维数组(10个数):";
for(i=0;i<n;i++)
cin>>a[i];
cout<<"输入要查找的数x:";
cin>>x;
min=0;
max=n-1;
while(min+1!=max)
{
	mid=(min+max)/2;
	if(x>a[mid])min=mid;
	else if(x<a[mid])max=mid;
	else{cout<<"x是数组中的第"<<mid+1<<"个数"<<endl;break;}
}
if(x==a[max])cout<<"x是数组中的第"<<max+1<<"个数"<<endl;
else if(x==a[min])cout<<"x是数组中的第"<<min+1<<"个数"<<endl;
else if(x!=a[mid])cout<<"查无此数"<<endl;
system("pause");
return 0;
}

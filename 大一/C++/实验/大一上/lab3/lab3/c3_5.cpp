#include<iostream>
using namespace std;
int main()
{const int n=10;
int a[n],i,x,min,max,mid;
cout<<"����һ�������һά����(10����):";
for(i=0;i<n;i++)
cin>>a[i];
cout<<"����Ҫ���ҵ���x:";
cin>>x;
min=0;
max=n-1;
while(min+1!=max)
{
	mid=(min+max)/2;
	if(x>a[mid])min=mid;
	else if(x<a[mid])max=mid;
	else{cout<<"x�������еĵ�"<<mid+1<<"����"<<endl;break;}
}
if(x==a[max])cout<<"x�������еĵ�"<<max+1<<"����"<<endl;
else if(x==a[min])cout<<"x�������еĵ�"<<min+1<<"����"<<endl;
else if(x!=a[mid])cout<<"���޴���"<<endl;
system("pause");
return 0;
}

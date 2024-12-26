#include<iostream>
#include<cstring>
using namespace std;
template<class T>
T max_of_array(T a[],int n)
{int i,j,k;
 T t;
 for(i=0;i<n-1;i++)
 {k=i;
  for(j=i+1;j<n;j++)
   if(a[j]<a[k])k=j;
  t=a[i];a[i]=a[k];a[k]=t;
 }
 return a[n-1];
}
int max_of_array(int a[],int n)
{int i,j,k,t;
 for(i=0;i<n-1;i++)
 {k=i;
  for(j=i+1;j<n;j++)
   if(a[j]<a[k])k=j;
  t=a[i];a[i]=a[k];a[k]=t;
 }
 return a[n-1];
}
int main()
{
 char c[]="I love c++ programming.";
 int a[20]={3,4,56,78,99,12,34,67,89,22,33,44,10,67,55,33,45,32,21,11};
 
 cout<<max_of_array(c,strlen(c))<<endl;
 cout<<max_of_array(a,20)<<endl;
    system("pause");
 return 0;
}
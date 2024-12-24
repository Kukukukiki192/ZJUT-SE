#include<iostream>
using namespace std;
int main()
{
   int n,i=0,a[10000];
   cin>>n;
   while(n)
   {a[i]=n%2;
    n/=2;
    i++;
   }
   for(n=i-1;n>=0;n--)cout<<a[n];
   cout<<endl;
   return 0;
}
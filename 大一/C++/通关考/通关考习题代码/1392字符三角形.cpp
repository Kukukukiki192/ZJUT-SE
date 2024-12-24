#include <iostream>
using namespace std;
int main()
{   int n,i,j;
	cin>>n;
    for(i=n;i>0;i--)
    {for(j=n;j>n-i;j--)
//or:for(j=1;j<=i;j++)
     {cout<<"*";
     }
      cout<<endl;
    }
    return 0;
}
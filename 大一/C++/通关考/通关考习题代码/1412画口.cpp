#include<iostream>
using namespace std;
int main()
{void paint(int,int);
	const int N=2;
	int i,m[N],n[N];
	for(i=0;i<N;i++)
     cin>>m[i]>>n[i];
    for(i=0;i<N;i++)
     paint(m[i],n[i]);
    return 0;
}
void paint(int a,int b)
{int i,j;
	for(i=0;i<a;i++)
	{
		if(i==0||i==a-1)
		{for(j=0;j<b;j++)
	     cout<<"#";
	     cout<<endl;
		}
	    else 
	    {for(j=0;j<b;j++)
	    	{if(j==0||j==b-1)
	         cout<<"#";
	         else cout<<" ";
	        }
	     cout<<endl;
	    }
	}
}
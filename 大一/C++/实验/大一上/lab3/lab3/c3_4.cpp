//4.找出一个二维数组中的"鞍点".即该位置上的元素在该行上最大，在该列上最小
#include<iostream>
using namespace std;
int main()
{int a[3][3],i,j,max,c,b,x;
cout<<"输入一个3行3列的二维数组："<<endl;
for(i=0;i<3;i++)
{for(j=0;j<3;j++)
cin>>a[i][j];
cout<<endl;
}
for(i=0;i<3;i++)
{max=a[i][0];
	for(j=0;j<3;j++)
	{if(a[i][j]>max)max=a[i][j];c=j;}
    for(x=0;x<3;x++)
	if(a[i][c]<max)continue;
	if(x==3)
	{b=1;
	cout<<"鞍点是"<<"a["<<i<<"]["<<c<<"]="<<max<<endl;
    break;
	}
}
if(!b)cout<<"无鞍点"<<endl;
system("pause");
return 0;
}

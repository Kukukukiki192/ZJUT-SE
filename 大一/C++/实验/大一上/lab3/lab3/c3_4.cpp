//4.�ҳ�һ����ά�����е�"����".����λ���ϵ�Ԫ���ڸ���������ڸ�������С
#include<iostream>
using namespace std;
int main()
{int a[3][3],i,j,max,c,b,x;
cout<<"����һ��3��3�еĶ�ά���飺"<<endl;
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
	cout<<"������"<<"a["<<i<<"]["<<c<<"]="<<max<<endl;
    break;
	}
}
if(!b)cout<<"�ް���"<<endl;
system("pause");
return 0;
}

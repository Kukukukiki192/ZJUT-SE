#include<iostream>
#include<iomanip>
using namespace std;
int main()
{int i,j;//iΪ������jΪ����
	cout<<"�žų˷���"<<endl;
    for(i=1;i<=9;i++)
    {
    	for(j=1;j<=i;j++)
        cout<<j<<"x"<<i<<"="<<j*i<<"\t"<<setiosflags(ios::left);
    	cout<<endl;
    }
    return 0;
}
#include<iostream>
#include<iomanip>
using namespace std;
int main()
{int n;
	float a=0.01,b=0.00,c,sum=0.00;
	for(n=1;n<=30;n++)
	{
	cout<<"��"<<setw(2)<<n<<"��,";    
	sum+=a;
	cout<<"İ���˵õ���Ǯ��Ϊ��"<<setiosflags(ios::fixed)<<setprecision(2)<<setw(11)<<sum<<'\t';
	a*=2;
	cout<<"��"<<setw(2)<<n<<"��,"; 
	b=100000*n;
	cout<<"����Ӯ����Ǯ��Ϊ��"<<setiosflags(ios::fixed)<<setprecision(2)<<setw(11)<<b<<endl;
	}
	cout<<'\n';
	c=sum-b;
	cout<<"30���İ���˵õ�"<<sum<<"��Ǯ"<<endl;
	cout<<"30��󣬸��̵õ�"<<b<<"��Ǯ"<<endl;
	cout<<"30��󣬸��̿���"<<c<<"��Ǯ"<<endl;
	cout<<"���̿޿޿޿޿���  �����Ǹ�ɵ��"<<endl;
    return 0;
}
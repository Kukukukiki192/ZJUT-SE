//2��(1)շת���(2)��ĳһ���ݼ���֤��Լ��
#include <iostream>
using namespace std;
int main()
{
	int n=1,N,a,b,r;
	cin>>N;
	while(n<=N)
	{
		cin>>a>>b;
		if(a<b){r=a;a=b;b=r;}
		while(r=a%b){a=b;b=r;}
	  /*int x=a;
		while(!(a%x==0&&b%x==0))x--;
		��12��,17��x���b,ɾȥ6��r */
		cout<<"case"<<n<<":"<<b<<endl;
		n++;
	}  
    return 0;
}
//1.���㡰쳲��������е�n�
#include<iostream>
using namespace std;
float F(int n)
{float c;
    if(n>2) c=F(n-1)+F(n-2);
	else c=1;
	return c;
}
int main()
{ int n;
	cout<<"�����ѯ��������";
	cin>>n;
	cout<<"F("<<n<<")="<<F(n)<<endl;
	system("pause");
}

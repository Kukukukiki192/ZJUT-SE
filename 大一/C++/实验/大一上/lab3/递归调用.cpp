//µİ¹éµ÷ÓÃ1
#include <iostream>
using namespace std;
void f(int n)
{if(n>=10)
	f(n/10);
	cout<<n<<endl;
}
void main()
{f(12345);
}
//µİ¹éµ÷ÓÃ1
#include <iostream>
using namespace std;
void func(char c)
{cout<<c;
	if(c<'5')func(c+1);
	cout<<c;
}
void main()
{func('0');
	cout<<endl;
}
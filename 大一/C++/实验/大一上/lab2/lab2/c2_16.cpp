#include <iostream>
using namespace std;
int main()
{	char a,b,c;//a VS A,b VS B,c VS C.
 	cout << "比赛名单为：" << endl;
	for (a='X';a<='Z';++a)
		{for (b='X';b<='Z';++b)
			{if(a!=b)
				for(c='X';c<='Z';++c)
					{if(a!=c && b!=c)//得到所有不重复的比赛名单
					if(a!='X' && c!='X' && c!='Z')//求最终比赛名单
					{	cout << "A" << "\t" << "VS" << "\t" << a << endl;
						cout << "B" << "\t" << "VS" << "\t" << b << endl;
						cout << "C" << "\t" << "VS" << "\t" << c << endl;
					}
					}
			}
		}
	return 0;
}
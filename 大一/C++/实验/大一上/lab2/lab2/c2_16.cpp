#include <iostream>
using namespace std;
int main()
{	char a,b,c;//a VS A,b VS B,c VS C.
 	cout << "��������Ϊ��" << endl;
	for (a='X';a<='Z';++a)
		{for (b='X';b<='Z';++b)
			{if(a!=b)
				for(c='X';c<='Z';++c)
					{if(a!=c && b!=c)//�õ����в��ظ��ı�������
					if(a!='X' && c!='X' && c!='Z')//�����ձ�������
					{	cout << "A" << "\t" << "VS" << "\t" << a << endl;
						cout << "B" << "\t" << "VS" << "\t" << b << endl;
						cout << "C" << "\t" << "VS" << "\t" << c << endl;
					}
					}
			}
		}
	return 0;
}
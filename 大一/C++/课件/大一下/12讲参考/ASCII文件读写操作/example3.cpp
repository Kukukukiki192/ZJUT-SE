#include <fstream>
#include <iostream>
using namespace std;
void save_to_file();// save_to_file�����Ӽ��̶���һ���ַ����������е���ĸ��������ļ�
void get_from_file();//�Ӵ����ļ�f2.txt������ĸ�ַ��������е�Сд��ĸ��Ϊ��д��ĸ���ٴ���f3.txt

void save_to_file( )
{
ofstream outfile("f2.txt");
//��������ļ�������outfile���������ʽ�򿪴����ļ�f2.txt
if(!outfile)
{
cerr<<"open f2.txterror!"<<endl;
exit(1);
}
char c[80];
cin.getline(c,80);//�Ӽ��̶���һ���ַ�
for(int i=0;c[i]!=0;i++) //���ַ��������ֱ����'/0 'Ϊֹ
if(c[i]>=65 && c[i]<=90||c[i]>=97 && c[i]<=122)//�������ĸ�ַ�
{
	outfile.put(c[i]); //����ĸ�ַ���������ļ�f2.txt
	cout<<c[i]; //ͬʱ����ʾ����ʾ
}
cout<<endl;
outfile.close(); //�ر�f2.txt
}

//�Ӵ����ļ�f2.txt������ĸ�ַ��������е�Сд��ĸ��Ϊ��д��ĸ���ٴ���f3.txt
void get_from_file()
{char ch;
ifstream infile("f2.txt",ios::in);//���������ļ���outfile�������뷽ʽ�򿪴����ļ�f2.txt
if(!infile)
{
cerr<<"open f2.txterror!"<<endl;
exit(1);
}
ofstream outfile("f3.txt");//��������ļ���outfile���������ʽ�򿪴����ļ�f3.txt
if(!outfile)
{
cerr<<"open f3.txterror!"<<endl;
exit(1);
}

while(infile.get(ch))//����ȡ�ַ��ɹ�ʱִ������ĸ������
{
	if(ch>=97 &&ch<=122) //�ж�ch�Ƿ�ΪСд��ĸ
		ch=ch-32; //��Сд��ĸ��Ϊ��д��ĸ
	outfile.put(ch); //���ô�д��ĸ��������ļ�f3.txt
	cout<<ch; //ͬʱ����ʾ�����
}
cout<<endl;
infile.close( ); //�رմ����ļ�f2.txt
outfile.close(); //�رմ����ļ�f3.txt
}

//������
int main( )
{
	save_to_file( );//����save_to_file( )���Ӽ��̶���һ���ַ��������е���ĸ��������ļ�f2.txt
    get_from_file( );//����get_from_file()����f2.txt������ĸ�ַ�����Ϊ��д��ĸ���ٴ���f3.txt
    return 0;
}
#include <fstream>
#include <iostream>
using namespace std;
int main( )
{
int a[10];
ofstream outfile("f1.txt",ios::out);//�����ļ������󣬴򿪴����ļ�
if(!outfile) //�����ʧ�ܣ�outfile����0ֵ
{  cerr<<"open error!"<<endl;
   exit(1);
}
cout<<"Enter 10 integer numbers:"<<endl;
for(int i=0;i<10;i++)  
{
cin>>a[i];
outfile<<a[i]<<" ";  //������ļ��������
} 
outfile.close(); //�رմ����ļ�
return 0;
}

//��������
//1 3 5 2 4 6 10 8 7 9�L
//���Գ����޸����е��﷨������߼�����ʹ������ȷ�����
//HiLan
//NeLan

#include<iostream>
using namespace std;
int main(){
char sn2[]  = "LiLan"; 
char *ps1,*ps2;//2����ַ�����ŵ� 
ps1=sn2;//LiLan
ps2=sn2+2; //Lan
ps1[0]='H';//HiLan
cout<<ps1<<endl;
*ps1='N';//*(ps1+0)=ps1[0] NiLan
ps2[-1]='e';//Ni(�Ӵ˴�)Lan:i->e
cout<<ps1<<endl;

cout<<*ps1<<" "<<*ps1+2//N-ASCII-78,N+2->80
<<" "<<*(ps1+2)<<" "<<ps1<<" "<<&ps1<<endl;
return 0;
}

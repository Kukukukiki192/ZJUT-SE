//调试程序，修改其中的语法错误和逻辑错误，使程序正确输出：
//HiLan
//NeLan

#include<iostream>

void main(){
char sn2[]  = "LiLan"; 
char *ps1,*ps2;
ps1=sn2;
ps2=sn2+2; 
ps1[0]='H';
cout<<ps1<<endl；
*ps1='N';
ps2[-1]='e';
cout<<&ps2[-5]<<endl;
}
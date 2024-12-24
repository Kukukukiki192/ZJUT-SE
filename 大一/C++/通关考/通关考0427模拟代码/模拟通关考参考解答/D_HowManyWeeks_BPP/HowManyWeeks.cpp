//===========================
// HowManyWeeks  Dif BPP
//===========================
#include<iostream>
//#include<fstream>
using namespace std;
//---------------------------
int isLeap(int y){
  return y%4==0 && y%100!=0||y%400==0;
}//--------------------------
int main() {
  //ifstream cin("in.txt");
  //ofstream cout("out.txt");
  int m[13]={ 0,31,59,90,120,151,181,212,243,273,304,334,365 };
  for(int yy,mm,dd,days; cin>>yy>>mm>>dd; ){
    if(yy<1999){
      days = (1999-yy-1)*365;       //yy+1年到1989年底的天数
      for(int j=yy+1; j<=1998; j++) //补足闰年的天数
        days += isLeap(j);
      days += m[12]-m[mm];          //生年下个月到年末的天数
      days += (isLeap(yy) && mm<=2);//生年视闰年情况补足1天
      days += m[mm]-m[mm-1]-dd+1;   //当月生日到月底的天数
    }else{
      days = (yy-1999)*365;         //1999年以来的天数
      for(int j=1999; j<yy; j++)    //补足闰年的天数
        days += isLeap(j);
      days += m[mm-1];              //生年前几月的天数
      days += (mm>2 && isLeap(yy)); //生年视闰年情况补足1天
      days += dd-1;                 //生日当月的天数
    }
    cout<<(days+6)/7<<"\n";
  }
}//--------------------------

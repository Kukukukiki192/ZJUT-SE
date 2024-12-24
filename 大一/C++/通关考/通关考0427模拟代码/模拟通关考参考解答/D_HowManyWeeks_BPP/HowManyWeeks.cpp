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
      days = (1999-yy-1)*365;       //yy+1�굽1989��׵�����
      for(int j=yy+1; j<=1998; j++) //�������������
        days += isLeap(j);
      days += m[12]-m[mm];          //�����¸��µ���ĩ������
      days += (isLeap(yy) && mm<=2);//�����������������1��
      days += m[mm]-m[mm-1]-dd+1;   //�������յ��µ׵�����
    }else{
      days = (yy-1999)*365;         //1999������������
      for(int j=1999; j<yy; j++)    //�������������
        days += isLeap(j);
      days += m[mm-1];              //����ǰ���µ�����
      days += (mm>2 && isLeap(yy)); //�����������������1��
      days += dd-1;                 //���յ��µ�����
    }
    cout<<(days+6)/7<<"\n";
  }
}//--------------------------

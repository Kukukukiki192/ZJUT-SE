//===========================
// Hunting Dif C
//===========================
#include<iostream>
//#include<fstream>
using namespace std;
//---------------------------
int main(){
  //ifstream cin("in.txt");
  //ofstream cout("out.txt");
  for(int n,h,z; cin>>n>>h>>z; ){
    int num = (z-2*h)/2;  //ÍÃ×ÓÊý
    int cnt=(num>n && n>(num-1)/2);
    cout<<(cnt ? "yes" : "no")<<"\n";
  }
}//--------------------------

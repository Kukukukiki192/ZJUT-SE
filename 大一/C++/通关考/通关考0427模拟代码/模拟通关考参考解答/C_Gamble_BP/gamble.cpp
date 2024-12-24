//===========================
// gamble  dif = B
//===========================
#include<iostream>
#include<fstream>
using namespace std;
//---------------------------
int main(){
  ifstream cin("in.txt");
  ofstream cout("out.txt");
  int n,m,sum=0;
  for(char k; cin>>m>>k>>n; )
    if(k=='b' && n>=11 && n<=17 || k=='s' && n>=4 && n<=10)
      sum += m;
    else
      sum -= m;
  cout<<sum<<"\n";
}//--------------------------

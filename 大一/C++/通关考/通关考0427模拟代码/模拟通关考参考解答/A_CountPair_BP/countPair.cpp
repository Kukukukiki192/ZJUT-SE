//===========================
// count pair Dif BP
//===========================
#include<iostream>
//#include<fstream>
using namespace std;
//---------------------------
int main(){
  //ofstream cout("out.txt");
  //ifstream cin("in.txt");
  for(int m; cin>>m && m; ){
    int num=0, i=1;
    for(char a,b,c,d; i<=m; i++){
      cin>>a>>b>>c>>d;
      if(a==b && c==d || a==c && b==d || a==d && b==c) num+=2;
      else num += (a==b || a==c || a==d || b==c || b==d || c==d);
    }
    cout<<num<<"\n";
  }
}//--------------------------





#include <iostream>
using namespace std;
class  ex2{
public:
     ex2(int v=0){
     x=new int(v);
     cout<<�幹����󣡡�<<*x<<endl;}
     void setx(int v){*x=v;}
     int  getx(){return *x;}
     ~ex2(){
    cout<<���������󣡡�<<*x<<endl;
     delete x;}
private:
    int *x;
};

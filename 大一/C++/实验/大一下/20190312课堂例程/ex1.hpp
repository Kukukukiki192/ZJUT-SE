#include <iostream>
using namespace std;
class  ex1{
public:
     ex1(int v=0){
     x=v;
     cout<<″构造对象！″<<x<<endl;}
     void setx(int v){x=v;}
     int  getx(){return x;}
     ~ex1(){
         cout<<″析构对象！″<<x<<endl;   }
private:
    int x;
};

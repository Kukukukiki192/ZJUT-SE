#include <iostream>
using namespace std;
class  ex2{
public:
     ex2(int v=0){
     x=new int(v);
     cout<<″构造对象！″<<*x<<endl;}
     void setx(int v){*x=v;}
     int  getx(){return *x;}
     ~ex2(){
    cout<<″析构对象！″<<*x<<endl;
     delete x;}
private:
    int *x;
};

class  ex2
{
public:
     ex2(int v=0){x=new int(v);cout<<"构造对象!"<<*x<<endl;}
     //拷贝构造函数的类内声明
     ex2(const ex2& r);
     void setx(int v){*x=v;}
     int  getx(){return *x;}
     ~ex2(){delete x;cout<<"析构对象!"<<*x<<endl;
}
private:
     int *x;
};
ex2::ex2(const ex2& r)
{
     x=new int;
     *x=*(r. x);
} 

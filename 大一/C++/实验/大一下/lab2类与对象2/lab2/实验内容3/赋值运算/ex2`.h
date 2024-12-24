class  ex2
{
public:
    ex2(int v=0){x=new int(v);}
    //赋值函数的类内声明
    ex2& operator=(const ex2& r);
    void setx(int v){*x=v;}
    int  getx(){return *x;}
    ~ex2(){delete x;}
private:
    int *x;
};
ex2& ex2::operator=(const ex2& r)
{
    *x=*(r.x);
    return (*this);
} 

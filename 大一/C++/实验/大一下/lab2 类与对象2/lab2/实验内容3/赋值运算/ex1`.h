class ex1{
public:
    ex1(int v=0){x=v;}
    //缺省的赋值函数
    ex1& operator=(const ex1& r)
    {x=r.x; return (*this); }
    void setx(int v){x=v;}
    int getx(){return x;}
private:
   int x;
};

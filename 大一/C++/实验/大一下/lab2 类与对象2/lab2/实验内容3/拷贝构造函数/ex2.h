class  ex2
{
public:
     ex2(int v=0){x=new int(v);cout<<"�������!"<<*x<<endl;}
     //�������캯������������
     ex2(const ex2& r);
     void setx(int v){*x=v;}
     int  getx(){return *x;}
     ~ex2(){delete x;cout<<"��������!"<<*x<<endl;
}
private:
     int *x;
};
ex2::ex2(const ex2& r)
{
     x=new int;
     *x=*(r. x);
} 

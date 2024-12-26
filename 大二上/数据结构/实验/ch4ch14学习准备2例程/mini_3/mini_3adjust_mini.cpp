class  mini{

public:
    mini(int t){ px=new int(t);   }

private:
    int * px;
};

void main()
{
mini objA(3),objB(objA),objC(4);

objB=objC;
}
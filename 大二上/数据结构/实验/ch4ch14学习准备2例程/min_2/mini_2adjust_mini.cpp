class  mini{
public:
    mini(int t):x(t){    }
private:
    int x;
};

void main()
{
mini objA(3),objB(objA),objC(4);

objB=objC;
}
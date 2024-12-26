 /* //extern the mini class,add a data member, int type
    class mini{

    };
*/

class  mini  {
private:
      int x;
};


void main()
{
mini objA(3),objB(objA),objC(4);

objB=objC;
}
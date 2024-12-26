#include <iostream.h>
#include "Time24.h" //time24 到实验0里面的time24答案中找
/*
///////////////////////////////
//方案一:定义不同名称的函数
////////////////////////////////
//判断两个整型值是否相等
int iEqual(int x,int y)
{     return (x==y);   }

//判断两个浮点值是否相等
int fEqual(double x,double y)
{     return (x==y);   }

//判断两个时间值是否相等
int sEqual(Time24 x,Time24 y)
{     return (x==y);   }
//////////////////////////////////
*/


///////////////////////////////
//方案二:重载Equal
////////////////////////////////
//判断两个整型值是否相等
int Equal(int x,int y)
{     return (x==y);   }


//判断两个浮点值是否相等
int Equal(double x,double y)
{     return (x==y);   }

//判断两个时间值是否相等
int Equal(Time24 x,Time24 y)
{     return (x==y);   }
//////////////////////////////////


/*
///////////////////////////////
//方案三:模板函数Equal
////////////////////////////////
//判断两个值是否相等
template<typename T>
int Equal(T x,T y)
{     return (x==y);   }
////////////////////////////////
*/

void main()
{
time24 aTime(5,30),bTime（15,30);
cout<<Equal(3,5)<<endl;
cout<<Equal(4.1,5.3)<<endl;
cout<<Equal(aTime,bTime)<<endl;
}


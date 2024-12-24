#include "basgraph.hpp"
extern HDC hDC;//设备场境句柄;
Point::Point(int x,int y):Location(x,y)//构造，缺省为不可见
{ 
}

void Point::Show()//显示点
{
		COLORREF rgbColor;
		rgbColor=RGB(0,255,0);//设置颜色为红色
        SetPixel(hDC,X_pos,Y_pos,rgbColor);    //画点
}

void Point::Move_to(int x,int y)//移动点到新位置（x,y)
{  
   X_pos=x;
   Y_pos=y;
   Show(); //按照新位置显示点
} 
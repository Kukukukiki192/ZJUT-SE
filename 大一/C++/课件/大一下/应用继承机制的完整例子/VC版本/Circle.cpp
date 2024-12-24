#include "basgraph.hpp"      
extern HDC hDC;//设备场境句柄;     

Circle::Circle(int x,int y,int r):Point(x,y)//构造
{  radius=r;
}

void Circle::Show()//显示圆
{ 
	 Arc(hDC,X_pos-radius,Y_pos-radius,X_pos+radius,Y_pos+radius,X_pos,Y_pos-radius,X_pos,Y_pos-radius);//画圆
}

void Circle::Move_to(int x,int y)//移动圆到新圆心位置（x,y）
{
	 X_pos=x;
	 Y_pos=y;
	 Show();
}
void Circle::Expand(int delta)//扩展圆，半径为radius+delta
{
	radius=radius+delta;
	if(radius<0) radius=0;
	Show();
}
void Circle::Contract(int delta)//收缩圆，半径为radius-delta
{ Expand(-delta);
}
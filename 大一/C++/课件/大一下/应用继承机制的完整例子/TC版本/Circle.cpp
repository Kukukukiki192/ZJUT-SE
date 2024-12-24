#include "basgraph.hpp"

Circle::Circle(int x,int y,int r)//构造
{  radius=r;
}

void Circle::Show()//显示圆
{  
   if(!is_visible())
   {
	 visible=TRUE;
	 circle(X_pos,Y_pos,radius); //画圆
   }
}

void Circle::Hide()//隐藏圆
{ unsigned int temp_color;
   
   if(is_visible())
   { temp_color=getcolor();//保存当前颜色
     setcolor(getbkcolor());//设置当前颜色为背景色
	 visible=FALSE;
	 circle(X_pos,Y_pos,radius); //用背景色画圆，擦除
	 setcolor(temp_color);//恢复原来的颜色
   }
}
void Circle::Move_to(int x,int y)//移动圆到新圆心位置（x,y）
{
	 hide();
	 X_pos=x;
	 Y_pos=y;
	 show();
}
void Circle::Expand(int delta)//扩展圆，半径为radius+delta
{
	hide();
	radius=radius+delta;
	if(radius<0) radius=0;
	show();
}
void Circle::Contract(int delta)//收缩圆，半径为radius-delta
{ expand(-delta);
}
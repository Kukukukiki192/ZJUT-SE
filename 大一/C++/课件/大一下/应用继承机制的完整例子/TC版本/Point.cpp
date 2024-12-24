#include "basgraph.hpp"

Point::Point(int x,int y):Location(x,y)//构造，缺省为不可见
{  visible=FALSE;
}
BOOLEAN Point::is_visible()//判断当前是否为可见
{  return visible;    
}
	

void Point::Show()//显示点
{
	if(!is_visible()){
		visible=TRUE;
		putpixel(X_pos,Y_pos,getcolor()); //使用缺省颜色画点
	}
}
void Point::Hide()//隐藏点
{   if(is_visible()){
		visible=FALSE;
		putpixel(X_pos,Y_pos,getbkcolor());//使用背景颜色画点，即擦除点
    }
}
void Point::Move_to(int x,int y)//移动点到新位置（x,y)
{  Hide(); //擦除当前点
   X_pos=x;
   Y_pos=y;
   show(); //按照新位置显示点
} 
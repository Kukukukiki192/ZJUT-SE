#include "basgraph.hpp"
#include <conio.h>

int main()
{  int graphdriver=DETECT,graphmode;
   Circle circle(100,200,50);

   initgraph(&graphdriver,&graphmode,"");//初始化图形系统
   //显示圆
   circle.Show();
   getch();
   //移动
   circle.Move_to(200,250);
   getch();
   //放大
   circle.Expand(50);
   getch();
   circle.Expand(50);
   getch();
   //收缩
   circle.Contact(65);
   getch();
   circle.Contact(65);
   getch();
   //关闭图形系统
   closegraph();

   return 0;
}
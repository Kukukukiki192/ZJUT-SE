#include "basgraph.hpp"
#include <conio.h>

int main()
{  int graphdriver=DETECT,graphmode;
   Circle circle(100,200,50);

   initgraph(&graphdriver,&graphmode,"");//��ʼ��ͼ��ϵͳ
   //��ʾԲ
   circle.Show();
   getch();
   //�ƶ�
   circle.Move_to(200,250);
   getch();
   //�Ŵ�
   circle.Expand(50);
   getch();
   circle.Expand(50);
   getch();
   //����
   circle.Contact(65);
   getch();
   circle.Contact(65);
   getch();
   //�ر�ͼ��ϵͳ
   closegraph();

   return 0;
}
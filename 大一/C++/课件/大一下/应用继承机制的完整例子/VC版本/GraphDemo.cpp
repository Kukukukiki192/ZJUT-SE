#include "basgraph.hpp"

HWND hWnd; //程序运行窗口的句柄;       
HDC hDC;//设备场境句柄;        
HPEN hPen; //画笔; 

int main(int argc, char* argv[])
{  
	hWnd=FindWindowA(NULL,argv[0]); //找到程序运行窗口的句柄; 
	hDC=GetDC(hWnd);//通过窗口句柄得到该窗口的设备场境句柄;

	hPen=CreatePen(PS_DASH,2,0x00ff00);//生成绿色画笔;
	SelectObject(hDC,hPen);//把画笔引入设备场境;  
    Circle circle(200,200,50);
   //显示圆
   circle.Show();
   system("pause");
   //移动
   circle.Move_to(250,250);
   system("pause");
   hPen=CreatePen(PS_DASH,2,0x0000ff);//生成红色画笔;
   SelectObject(hDC,hPen);//把画笔引入设备场境;  
   //放大
   circle.Expand(100);
   system("pause"); 
   //收缩
   hPen=CreatePen(PS_DASH,2,0xff0000);//生成蓝色画笔;
   SelectObject(hDC,hPen);//把画笔引入设备场境;  
   circle.Contract(65);
   system("pause"); 

   return 0;
}
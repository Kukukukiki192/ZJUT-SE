#include "basgraph.hpp"
extern HDC hDC;//�豸�������;
Point::Point(int x,int y):Location(x,y)//���죬ȱʡΪ���ɼ�
{ 
}

void Point::Show()//��ʾ��
{
		COLORREF rgbColor;
		rgbColor=RGB(0,255,0);//������ɫΪ��ɫ
        SetPixel(hDC,X_pos,Y_pos,rgbColor);    //����
}

void Point::Move_to(int x,int y)//�ƶ��㵽��λ�ã�x,y)
{  
   X_pos=x;
   Y_pos=y;
   Show(); //������λ����ʾ��
} 
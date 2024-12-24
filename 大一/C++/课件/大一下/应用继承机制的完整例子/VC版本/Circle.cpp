#include "basgraph.hpp"      
extern HDC hDC;//�豸�������;     

Circle::Circle(int x,int y,int r):Point(x,y)//����
{  radius=r;
}

void Circle::Show()//��ʾԲ
{ 
	 Arc(hDC,X_pos-radius,Y_pos-radius,X_pos+radius,Y_pos+radius,X_pos,Y_pos-radius,X_pos,Y_pos-radius);//��Բ
}

void Circle::Move_to(int x,int y)//�ƶ�Բ����Բ��λ�ã�x,y��
{
	 X_pos=x;
	 Y_pos=y;
	 Show();
}
void Circle::Expand(int delta)//��չԲ���뾶Ϊradius+delta
{
	radius=radius+delta;
	if(radius<0) radius=0;
	Show();
}
void Circle::Contract(int delta)//����Բ���뾶Ϊradius-delta
{ Expand(-delta);
}
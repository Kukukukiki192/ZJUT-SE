#include "basgraph.hpp"

Circle::Circle(int x,int y,int r)//����
{  radius=r;
}

void Circle::Show()//��ʾԲ
{  
   if(!is_visible())
   {
	 visible=TRUE;
	 circle(X_pos,Y_pos,radius); //��Բ
   }
}

void Circle::Hide()//����Բ
{ unsigned int temp_color;
   
   if(is_visible())
   { temp_color=getcolor();//���浱ǰ��ɫ
     setcolor(getbkcolor());//���õ�ǰ��ɫΪ����ɫ
	 visible=FALSE;
	 circle(X_pos,Y_pos,radius); //�ñ���ɫ��Բ������
	 setcolor(temp_color);//�ָ�ԭ������ɫ
   }
}
void Circle::Move_to(int x,int y)//�ƶ�Բ����Բ��λ�ã�x,y��
{
	 hide();
	 X_pos=x;
	 Y_pos=y;
	 show();
}
void Circle::Expand(int delta)//��չԲ���뾶Ϊradius+delta
{
	hide();
	radius=radius+delta;
	if(radius<0) radius=0;
	show();
}
void Circle::Contract(int delta)//����Բ���뾶Ϊradius-delta
{ expand(-delta);
}
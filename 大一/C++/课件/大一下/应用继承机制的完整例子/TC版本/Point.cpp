#include "basgraph.hpp"

Point::Point(int x,int y):Location(x,y)//���죬ȱʡΪ���ɼ�
{  visible=FALSE;
}
BOOLEAN Point::is_visible()//�жϵ�ǰ�Ƿ�Ϊ�ɼ�
{  return visible;    
}
	

void Point::Show()//��ʾ��
{
	if(!is_visible()){
		visible=TRUE;
		putpixel(X_pos,Y_pos,getcolor()); //ʹ��ȱʡ��ɫ����
	}
}
void Point::Hide()//���ص�
{   if(is_visible()){
		visible=FALSE;
		putpixel(X_pos,Y_pos,getbkcolor());//ʹ�ñ�����ɫ���㣬��������
    }
}
void Point::Move_to(int x,int y)//�ƶ��㵽��λ�ã�x,y)
{  Hide(); //������ǰ��
   X_pos=x;
   Y_pos=y;
   show(); //������λ����ʾ��
} 
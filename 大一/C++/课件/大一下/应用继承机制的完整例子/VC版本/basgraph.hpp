//BASGRAPH.HPP
//
#include <windows.h>
//

//�Ժ�x,��y���������������Ļ�ϵ�һ��λ��
class Location{
public:
	Location(int x,int y);//���캯��
	int Get_x() ;//ȡ������x
	int Get_y() ;//ȡ������y
protected:
	int X_pos,Y_pos;//λ������
};

//����ĳһ��λ�������ػ��ǿɼ���
class Point:public Location{
public:
	Point(int x,int y);//���죬ȱʡΪ���ɼ�
	//BOOLEAN is_visible();//�жϵ�ǰ�Ƿ�Ϊ�ɼ�
	void Show();//��ʾ��
	//void Hide();//���ص�
	void Move_to(int x,int y);//�ƶ��㵽��λ�ã�x,y)
protected:
	//BOOLEAN visible;//��Ŀɼ�״̬
};

//������point������Բ�࣬Բ����ĳ����(x,y),�뾶Ϊradius
class Circle:public Point{
public:
	Circle(int x=0,int y=0,int r=0);//����
	void Show();//��ʾԲ
	//void Hide();//����Բ
	void Move_to(int x,int y);//�ƶ�Բ����Բ��λ�ã�x,y��
	void Expand(int delta);//��չԲ���뾶Ϊradius+delta
	void Contract(int delta);//����Բ���뾶Ϊradius-delta
protected:
	int radius;//�뾶
};
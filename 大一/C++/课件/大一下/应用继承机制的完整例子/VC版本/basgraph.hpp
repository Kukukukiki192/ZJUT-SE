//BASGRAPH.HPP
//
#include <windows.h>
//

//以横x,纵y坐标描述计算机屏幕上的一个位置
class Location{
public:
	Location(int x,int y);//构造函数
	int Get_x() ;//取横坐标x
	int Get_y() ;//取纵坐标y
protected:
	int X_pos,Y_pos;//位置坐标
};

//描述某一个位置是隐藏还是可见的
class Point:public Location{
public:
	Point(int x,int y);//构造，缺省为不可见
	//BOOLEAN is_visible();//判断当前是否为可见
	void Show();//显示点
	//void Hide();//隐藏点
	void Move_to(int x,int y);//移动点到新位置（x,y)
protected:
	//BOOLEAN visible;//点的可见状态
};

//描述由point派生的圆类，圆心在某个点(x,y),半径为radius
class Circle:public Point{
public:
	Circle(int x=0,int y=0,int r=0);//构造
	void Show();//显示圆
	//void Hide();//隐藏圆
	void Move_to(int x,int y);//移动圆到新圆心位置（x,y）
	void Expand(int delta);//扩展圆，半径为radius+delta
	void Contract(int delta);//收缩圆，半径为radius-delta
protected:
	int radius;//半径
};
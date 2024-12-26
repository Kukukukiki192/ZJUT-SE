#include <vector>
#include <iostream>
using namespace std;
vector<int> loc(4,0);//int loc[4];
class farmerproblem{
public:
	bool safe();//检查当前状态是否安全
	int  farmer() const; //农夫所在位置
	int cabbage()const;//农夫所在位置
	int sheep()const;//羊所在位置
	int wolf()const;//狼所在位置
	void doit();//寻找移动序列
	void display() const;//输出可能的移动序列
private:
	int route[16]; //存储路径或者
};

//loc中位依次为农夫，白菜，羊，狼。也可以用位向量实现loc

//利用位与操作可以得到对应位是1或者0，表示在哪边岸上
int farmerproblem::farmer() const
{
	return  !(loc[0]==0);
}

int farmerproblem::cabbage() const
{
	return  !(loc[1]==0);
}

int farmerproblem::sheep() const
{
	return  !(loc[2]==0);
}

int farmerproblem::wolf() const
{
	return  !(loc[3]==0);
}

bool farmerproblem::safe()
{   //农夫没有看牢白菜，并且让羊和白菜在一起，危险！
	if(farmer()!=cabbage() && cabbage()==sheep()) return false;
	//农夫没有看牢羊，并且让羊和狼在一起，危险！
	if(farmer()!=sheep() && sheep()==wolf()) return false;
	//其他情况，安全！
	return true;
}

void farmerproblem::doit()
{//请编写找一个可实现序列的算法
}


void farmerproblem::display() const
{  //显示移动路径
	for(int i=15;i>0;i=route[i])
     cout<<"移动路径"<<route[i]<<"-->"<<i<<endl;
}


int main()
{//利用队列求解,可以使用STL的队列或者自己编写的队列


return 0;
}


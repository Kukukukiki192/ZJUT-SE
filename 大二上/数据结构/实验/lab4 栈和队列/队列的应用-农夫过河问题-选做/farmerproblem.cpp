#include <vector>
#include <iostream>
using namespace std;
vector<int> loc(4,0);//int loc[4];
class farmerproblem{
public:
	bool safe();//��鵱ǰ״̬�Ƿ�ȫ
	int  farmer() const; //ũ������λ��
	int cabbage()const;//ũ������λ��
	int sheep()const;//������λ��
	int wolf()const;//������λ��
	void doit();//Ѱ���ƶ�����
	void display() const;//������ܵ��ƶ�����
private:
	int route[16]; //�洢·������
};

//loc��λ����Ϊũ�򣬰ײˣ����ǡ�Ҳ������λ����ʵ��loc

//����λ��������Եõ���Ӧλ��1����0����ʾ���ı߰���
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
{   //ũ��û�п��ΰײˣ���������Ͱײ���һ��Σ�գ�
	if(farmer()!=cabbage() && cabbage()==sheep()) return false;
	//ũ��û�п����򣬲������������һ��Σ�գ�
	if(farmer()!=sheep() && sheep()==wolf()) return false;
	//�����������ȫ��
	return true;
}

void farmerproblem::doit()
{//���д��һ����ʵ�����е��㷨
}


void farmerproblem::display() const
{  //��ʾ�ƶ�·��
	for(int i=15;i>0;i=route[i])
     cout<<"�ƶ�·��"<<route[i]<<"-->"<<i<<endl;
}


int main()
{//���ö������,����ʹ��STL�Ķ��л����Լ���д�Ķ���


return 0;
}


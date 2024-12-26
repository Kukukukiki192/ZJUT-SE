#include <iostream>
using namespace std;
//#ifdef LINKEDLIST
//#define LINKEDLIST

typedef int ElementType;

class node{
public:
	node(){}
	node(ElementType d,node* n=NULL):data(d),next(n){ }
	ElementType data;
	node* next;
};

class LinkedList{
public:
	LinkedList();//构造
    ~LinkedList();//析构
	LinkedList(const LinkedList& origList);//拷贝构造
	LinkedList& operator=(const LinkedList& right);//赋值重载
    void Clear();
	bool empty() const; //判空
    void insert(ElementType item,node* pre);//在pre后插入，pre为空则插入在首
	void erase(node* pre);//删除pre后的，pre为空则删除首
	void display(ostream& out) const;//遍历输出

	node* find(ElementType item,int& success);//查找特定的值item,
	//返回包含该值结点的前驱，不存在success-1,无前驱返回NULL
private:
	int mySize;
	node *first;
};
ostream& operator<<(ostream& out,const LinkedList& aList);//输出流重载

//#endif


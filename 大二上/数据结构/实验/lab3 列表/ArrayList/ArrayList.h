#include <iostream>
using namespace std;
//#ifdef ARRAYLIST
//#define ARRAYLIST

typedef int ElementType;

class ArrayList{
public:
	ArrayList(int maxSize=1024);//构造
    ~ArrayList();//析构
	ArrayList(const ArrayList& origList);//拷贝构造
	ArrayList& operator=(const ArrayList& right);//赋值重载

	bool empty() const; //判空
    void insert(ElementType item,int pos);//插入
	void erase(int pos);//删除
	void display(ostream& out) const;//遍历输出

        int find(ElementType item);//查找item所在的位置,不存在返回-1
private:
	int mySize;
	int myCapacity;
	ElementType *myArray;
};
ostream& operator<<(ostream& out,const ArrayList& aList);//输出流重载

//#endif

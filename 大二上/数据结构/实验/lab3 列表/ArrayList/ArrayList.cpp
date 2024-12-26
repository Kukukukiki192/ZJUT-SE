#include "ArrayList.h"

#include <cassert>
#include <iostream>
using namespace std;

ArrayList::ArrayList(int maxSize)//构造
{
    myCapacity=maxSize;
	mySize=0;
	myArray=new ElementType[myCapacity];
	assert(myArray!=0);
}

ArrayList::~ArrayList()//析构
{//请补充
	delete [] myArray;
}

ArrayList::ArrayList(const ArrayList& origList)//拷贝构造
{
     myCapacity=origList.myCapacity;
	 myArray=new ElementType[myCapacity];
	 assert(myArray!=0);
	 mySize=origList.mySize;
	 for(int i=0;i<mySize;i++) myArray[i]=origList.myArray[i];
}


ArrayList& ArrayList::operator=(const ArrayList& right)//赋值重载
{ //请补充
	if(this!=&right)//确认不是自我赋值 
	{//若需要，分配一个新数组 
		if(myCapacity!=right.myCapacity)
		{
			delete[] myArray;
			myCapacity=right.myCapacity;
			myArray=new(nothrow) ElementType[myCapacity];
			if(myArray==0)//检查是否有可用内存 
			{
				cerr<<"*Inadequate memory to allocate stack ***\n";//内存已满 
				exit(1);
			}
		}
		//复制right列表元素到新数组中
		mySize=right.mySize;
		for(int i=0;i<mySize;i++)
			myArray[i]=right.myArray[i];
	}
	return *this;
}


bool ArrayList::empty() const //判空
{
   return mySize==0;
}


void ArrayList::insert(ElementType item,int pos)//插入
{ //请补充
	if(mySize==myCapacity){
		cerr<<"***No space for ArrayList element--terminating execution ***\n";
		exit(1);
	}
	if(pos<0||pos>mySize){//先处理异常情况 
		cerr<<"***Illegal location to insert--"<<pos<<".ArrayList unchanged. ***\n";
		exit(1);//return;
	}
	//首先向右移动数组为item腾出空间
	for(int i=mySize;i>pos;i--) myArray[i]=myArray[i-1];
	myArray[pos]=item;
	mySize++; 
}

void ArrayList::erase(int pos)//删除
{//请补充
	if(mySize==0){
		cerr<<"*** ArrayList is empty ***\n";
		return;
	}
	if(pos<0||pos>mySize){//先处理异常情况 
		cerr<<"***Illegal location to delete--"<<pos<<".ArrayList unchanged. ***\n";
		return;
	}
	//向左移动数组元素以消除间隔 
	for(int i=pos;i<mySize;i++) myArray[i]=myArray[i+1];
	//递减列表大小 
	mySize--; 
}


void ArrayList::display(ostream& out) const//遍历输出
{
	for(int i=0;i<mySize;i++)
		out<<i<<":"<<myArray[i]<<endl;
}

int ArrayList::find(ElementType item)
{//请补充
	for(int i=0;i<mySize;i++){
		if(myArray[i]==item) return i;
	}
	return -1;
}


ostream& operator<<(ostream& out,const ArrayList& aList)//输出流重载
{//请补充
	aList.display(out);
	return out; 
}

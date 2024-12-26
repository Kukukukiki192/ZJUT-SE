#include "ArrayList.h"

#include <cassert>
#include <iostream>
using namespace std;

ArrayList::ArrayList(int maxSize)//����
{
    myCapacity=maxSize;
	mySize=0;
	myArray=new ElementType[myCapacity];
	assert(myArray!=0);
}

ArrayList::~ArrayList()//����
{//�벹��
	delete [] myArray;
}

ArrayList::ArrayList(const ArrayList& origList)//��������
{
     myCapacity=origList.myCapacity;
	 myArray=new ElementType[myCapacity];
	 assert(myArray!=0);
	 mySize=origList.mySize;
	 for(int i=0;i<mySize;i++) myArray[i]=origList.myArray[i];
}


ArrayList& ArrayList::operator=(const ArrayList& right)//��ֵ����
{ //�벹��
	if(this!=&right)//ȷ�ϲ������Ҹ�ֵ 
	{//����Ҫ������һ�������� 
		if(myCapacity!=right.myCapacity)
		{
			delete[] myArray;
			myCapacity=right.myCapacity;
			myArray=new(nothrow) ElementType[myCapacity];
			if(myArray==0)//����Ƿ��п����ڴ� 
			{
				cerr<<"*Inadequate memory to allocate stack ***\n";//�ڴ����� 
				exit(1);
			}
		}
		//����right�б�Ԫ�ص���������
		mySize=right.mySize;
		for(int i=0;i<mySize;i++)
			myArray[i]=right.myArray[i];
	}
	return *this;
}


bool ArrayList::empty() const //�п�
{
   return mySize==0;
}


void ArrayList::insert(ElementType item,int pos)//����
{ //�벹��
	if(mySize==myCapacity){
		cerr<<"***No space for ArrayList element--terminating execution ***\n";
		exit(1);
	}
	if(pos<0||pos>mySize){//�ȴ����쳣��� 
		cerr<<"***Illegal location to insert--"<<pos<<".ArrayList unchanged. ***\n";
		exit(1);//return;
	}
	//���������ƶ�����Ϊitem�ڳ��ռ�
	for(int i=mySize;i>pos;i--) myArray[i]=myArray[i-1];
	myArray[pos]=item;
	mySize++; 
}

void ArrayList::erase(int pos)//ɾ��
{//�벹��
	if(mySize==0){
		cerr<<"*** ArrayList is empty ***\n";
		return;
	}
	if(pos<0||pos>mySize){//�ȴ����쳣��� 
		cerr<<"***Illegal location to delete--"<<pos<<".ArrayList unchanged. ***\n";
		return;
	}
	//�����ƶ�����Ԫ����������� 
	for(int i=pos;i<mySize;i++) myArray[i]=myArray[i+1];
	//�ݼ��б��С 
	mySize--; 
}


void ArrayList::display(ostream& out) const//�������
{
	for(int i=0;i<mySize;i++)
		out<<i<<":"<<myArray[i]<<endl;
}

int ArrayList::find(ElementType item)
{//�벹��
	for(int i=0;i<mySize;i++){
		if(myArray[i]==item) return i;
	}
	return -1;
}


ostream& operator<<(ostream& out,const ArrayList& aList)//���������
{//�벹��
	aList.display(out);
	return out; 
}

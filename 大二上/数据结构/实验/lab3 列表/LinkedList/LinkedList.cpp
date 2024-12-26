#include "LinkedList.h"
#include <cassert>
using namespace std;

LinkedList::LinkedList()//构造
{  mySize=0;
   first=NULL;
}

LinkedList::~LinkedList()//析构
{//请补充
	Clear();
}

void LinkedList::Clear()
{
	node *cur=first;
	while(cur)
	{
		node *del=cur;
		cur=cur->next;
		delete del;
		del=NULL;
	}
}

LinkedList::LinkedList(const LinkedList& origList)//拷贝构造
{
	mySize=origList.mySize;
	if(origList.first!=NULL)
	{
		node* p=origList.first;
		first=new node(p->data);
		p=p->next;
		node* pp=first;
		while(p){
			pp->next=new node(p->data);
			p=p->next;
            pp=pp->next;
		}
    }
	else
		first=NULL;
}



LinkedList& LinkedList::operator=(const LinkedList& right)//赋值重载
{//请补充
 if(this!=&right){
   if(mySize!=right.mySize){
   //删除this->first为表首的所有节点
   this->~LinkedList();//析构函数体的代码放在这里
   first=new node();
   node *tail=first;
   node *ptr=right.first;
   node *nptr;
   while(ptr!=NULL)
   {
        nptr=new node(ptr->data);
        tail->next=nptr;
        tail=nptr;
        ptr=ptr->next;
   }
   nptr=first;
   first=nptr->next;
   delete nptr;
  }
  mySize=right.mySize;
 }
  else{//节点值对拷
     node *ptr=new node();
     ptr=right.first;
	 node *thisPtr=new node();
	 thisPtr=first;
     while(ptr!=NULL)
    {  thisPtr->data=ptr->data;
      thisPtr=thisPtr->next;
      ptr=ptr->next;
    }
 }
 return*this; 
}
    
bool LinkedList::empty() const//判空
{
	return first==NULL;
}

void LinkedList::insert(ElementType item,node* pre)//在pre后插入，pre为空则插入在首
{//请补充
	node* newptr=new node(item);
	if(pre!=NULL){
		newptr->next=pre->next;
		pre->next=newptr;
	}
	else {
		newptr->next=first;
		first=newptr;
	}
}

void LinkedList::erase(node* pre)//删除pre后的，pre为空则删除首
{//请补充
	node* ptr;
	if(pre!=NULL){
		ptr=pre->next;
		pre->next=ptr->next;
	}
	else{
		ptr=first;
		first=ptr->next;
	}
	delete ptr;
}

void LinkedList::display(ostream& out) const//遍历输出
{
    for(node* p=first;p;p=p->next)
		out<<p->data<<endl;
}


node* LinkedList::find(ElementType item,int& success)
//查找特定的值item,存在则返回包含该值结点的前驱和查找成功的标记1，不存在则返回查找失败标记-1和NULL
{   node* pre=NULL;
    node* p=first;
	while(p&&p->data!=item)
	{
		pre=p;
		p=p->next;
	}
	if(p&&p->data==item) 
	{
		success=1;
		return pre;
	}
	else
	{
		success=-1;
		return NULL;
	}

}


ostream& operator<<(ostream& out,const LinkedList& aList)//输出流重载
{//请补充
	aList.display(out);
	return out;
}


#include "LinkedList.h"
#include <cassert>
using namespace std;

LinkedList::LinkedList()//����
{  mySize=0;
   first=NULL;
}

LinkedList::~LinkedList()//����
{//�벹��
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

LinkedList::LinkedList(const LinkedList& origList)//��������
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



LinkedList& LinkedList::operator=(const LinkedList& right)//��ֵ����
{//�벹��
 if(this!=&right){
   if(mySize!=right.mySize){
   //ɾ��this->firstΪ���׵����нڵ�
   this->~LinkedList();//����������Ĵ����������
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
  else{//�ڵ�ֵ�Կ�
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
    
bool LinkedList::empty() const//�п�
{
	return first==NULL;
}

void LinkedList::insert(ElementType item,node* pre)//��pre����룬preΪ�����������
{//�벹��
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

void LinkedList::erase(node* pre)//ɾ��pre��ģ�preΪ����ɾ����
{//�벹��
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

void LinkedList::display(ostream& out) const//�������
{
    for(node* p=first;p;p=p->next)
		out<<p->data<<endl;
}


node* LinkedList::find(ElementType item,int& success)
//�����ض���ֵitem,�����򷵻ذ�����ֵ����ǰ���Ͳ��ҳɹ��ı��1���������򷵻ز���ʧ�ܱ��-1��NULL
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


ostream& operator<<(ostream& out,const LinkedList& aList)//���������
{//�벹��
	aList.display(out);
	return out;
}


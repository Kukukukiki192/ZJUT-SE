#include <iostream>
using namespace std;
typedef int ElementType;
class  node
{public:
    node(ElementType d=0,node* n=NULL):data(d),next(n){}
    ElementType data;
    node* next;
};
//��������linklist����������ݵ���Ļ
void Traversing(node *linklist)
{
	node *p=linklist;
	while(p)
	{	cout<<p->data<<" ";
		p=p->next;
	}cout<<endl;
}
//���������m��n֮�� 
node* Addafter(ElementType m,ElementType n,node *linklist)
{
	node *p=linklist; 
	while(p&&p->data!=n) 
		p=p->next;
	node *pnew=new node(m,NULL);
	if(p){
	pnew->next=p->next;
	p->next=pnew;
	}
	else{
	pnew->next=linklist;
	linklist=pnew;
	}
	Traversing(linklist);
	return linklist;
}
//���������m��n֮ǰ 
node* Addbefore(ElementType m,ElementType n,node *linklist)
{
	node *p=linklist,*pre=NULL;
	while(p&&p->data!=n) 
		{pre=p;p=p->next;}
	node *pnew=new node(m,NULL);
	if(pre){
	pnew->next=p;
	pre->next=pnew;
	}
	else{
 	pnew->next=linklist;
	linklist=pnew;
	}
	Traversing(linklist);
	return linklist;
}
//ɾ��ֵΪn�Ľ��
node* Delete(ElementType n,node *linklist)
{
	node *pre=NULL,*p=linklist;
    while(p)
    {  if(p->data==n) break;
       pre=p;
       p=p->next;
    }
    if(pre) pre->next=p->next;
    else  linklist=p->next;
    delete p;  
    Traversing(linklist);
    return linklist;
}
//*�����������
node* ReverseNewList(node* linklist) 
{
    node* NewList=NULL,*p=linklist;
    while(p)
	{
        node* t=new node(p->data);
        t->next=NewList; 
        NewList=t;
        p=p->next;
    }
    Traversing(NewList);
    return NewList;
}
//*������������(��С����)�����[(2)ѡ������] 
node* SelectSortList(node* linklist)
{
    node* p=linklist;
    while(p)
	{ 
        node* min=p;
        node* other=p->next;
        while(other)
		{
            if(other->data<min->data) min=other;
            other=other->next;
        }
        if(min!=p) 
		{
            ElementType t=p->data;
            p->data=min->data;
            min->data=t;
        }          
        p=p->next;
    }
    Traversing(linklist);
    return linklist;
} 
int main()
{
//�½����� linklist, ��������a�е�����
	ElementType a[10]={56,34,3,67,89,55,22,43,12,9};
	node *linklist=new node(a[0],NULL),*tail=linklist;
	for(int i=1;i<10;++i) 
	{   
		node* newnode=new node(a[i],NULL);
		tail->next=newnode; 
		tail=newnode; 
	}
	
	Traversing(linklist);
	linklist=Addafter(72,89,linklist);
	linklist=Addbefore(90,22,linklist);
	linklist=Addbefore(5,linklist->data,linklist);
	linklist=Addafter(99,tail->data,linklist);	
	linklist=Delete(55,linklist);
	linklist=ReverseNewList(linklist);
	linklist=SelectSortList(linklist);
	return 0;
}

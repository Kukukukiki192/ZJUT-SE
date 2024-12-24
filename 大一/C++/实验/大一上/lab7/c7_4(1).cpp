#include <iostream>
using namespace std;
#define NULL 0
int n;//记录结点个数
struct student
{	int num;
	float score;
	student * next;
};
int main()
{student *creat(void);
	void print(student *head);
	student *del(student *head,int num);
	student *insert(student *head,student *stud);
	student *stu,*stud;
	stud=new student;//要插入的学生信息
	int x;		     //x是要删除的学生的学号
    cout<<"请输入学生的学号和成绩："<<endl;		
	stu=creat();
	cout<<"请输入您要删除的学生的学号：";		
	cin>>x;
	stu=del(stu,x);
	cout<<"以下是目前信息："<<endl;				
	print(stu);
	cout<<"请输入您要加入的学生的学号和成绩：";	
	cin>>stud->num>>stud->score;
	stu=insert(stu,stud);
	cout<<"以下是目前信息："<<endl;				
	print(stu);
	return 0;
}
student *creat(void)		//创建链表
{	student *head,*p1,*p2;
	n=0;					
	head=NULL;	
	p1=p2=new student;		
	cin>>p1->num>>p1->score;
	while (p1->num!=0)			
	{	n=n+1;
		if (n==1)	head=p1;	
		else	p2->next=p1;	
		p2=p1;					
		p1=new student;			
		cin>>p1->num>>p1->score;
	}
	p2->next=NULL;				
	delete p1,p2;
	p1=p2=NULL;
	return (head);				
}
void print(student *head)		
{	student *p;
	p=head;
	while (p!=NULL)
	{cout<<p->num<<'\t'<<p->score<<'\n';p=p->next;}
}
student *del(student *head,int num)	
{	student *p1,*p2;
	if (head==NULL)
	{cout<<"链表为空";return NULL;}
	p1=head;
	while (p1->num!=num && p1->next!=NULL)
	{p2=p1;p1=p1->next;}
	if (p1->num==num)	
	{if (num==head->num)
		head=p1->next;
	else p2->next=p1->next;
	n=n-1;
	}
	else cout<<"未找到该数字";		
	return head;
}
student *insert(student *head,student *stud)
{   student *p0,*p1,*p2;
	p0=stud; 
	p1=head;
	if (head==NULL)		
	{head=p0;p0->next=NULL;}			
	else
	{while((p0->num>p1->num)&&(p1->next!=NULL))
	{p2=p1;p1=p1->next;}
	if(p0->num <= p1->num)		
	{if (head==p1)			
	{p0->next=head;head=p0;}	
	else
	{p2->next=p0;
	 p0->next=p1;}	
	}
	else						
	{p1->next=p0;p0->next=NULL;}
	}
	n=n+1;          
	return (head);    
}

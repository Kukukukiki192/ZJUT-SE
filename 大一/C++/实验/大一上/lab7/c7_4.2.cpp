#include "header.h"
#define NULL 0
int n=0;
int main()
{	
	extern student *creat(void);
	extern void print(student *head);
	extern student *del(student *head,int num);
	extern student *insert(student *head,student *stud);
	student *stu,*stud;
	stud=new student;
	int x;
	cout<<"����ѧ��ѧ�źͳɼ���"<<endl;
	stu=creat();
	cout<<"����Ҫɾ��ѧ����ѧ�ţ�";
	cin>>x;
	stu=del(stu,x);
	cout<<"ɾ����Ϊ��"<<endl;
	print(stu);
	cout<<"����Ҫ�����ѧ����ѧ�źͳɼ���";
	cin>>stud->num>>stud->score;
	stu=insert(stu,stud);
	cout<<"�����Ϊ��"<<endl;
	print(stu);
	system("pause");
	return 0;
}

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
	cout<<"输入学生学号和成绩："<<endl;
	stu=creat();
	cout<<"输入要删除学生的学号：";
	cin>>x;
	stu=del(stu,x);
	cout<<"删除后为："<<endl;
	print(stu);
	cout<<"输入要插入的学生的学号和成绩：";
	cin>>stud->num>>stud->score;
	stu=insert(stu,stud);
	cout<<"插入后为："<<endl;
	print(stu);
	system("pause");
	return 0;
}

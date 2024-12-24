#include<iostream>
using namespace std;
struct student
{	char num[6];
	char name[20];
	int score[3];
}stu[5];
int main()
{void print(student stu[5]);
    cout<<"输入五名学生的学号、姓名、三门课的成绩:"<<endl;
	for(int i=0;i<5;i++)
		cin>>stu[i].num>>stu[i].name>>stu[i].score[0]>>stu[i].score[1]>>stu[i].score[2];
	print(stu);
	system("pause");
	return 0;
}
void print(student stu[5])
{for(int i=0;i<5;i++)
	cout<<"学号:"<<stu[i].num<<" 姓名:"<<stu[i].name<<" 三门课的成绩:"
	<<stu[i].score[0]<<" "<<stu[i].score[1]<<" "<<stu[i].score[2]<<endl;
}

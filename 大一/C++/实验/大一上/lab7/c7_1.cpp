#include<iostream>
using namespace std;
struct student
{	char num[6];
	char name[20];
	int score[3];
}stu[5];
int main()
{void print(student stu[5]);
    cout<<"��������ѧ����ѧ�š����������ſεĳɼ�:"<<endl;
	for(int i=0;i<5;i++)
		cin>>stu[i].num>>stu[i].name>>stu[i].score[0]>>stu[i].score[1]>>stu[i].score[2];
	print(stu);
	system("pause");
	return 0;
}
void print(student stu[5])
{for(int i=0;i<5;i++)
	cout<<"ѧ��:"<<stu[i].num<<" ����:"<<stu[i].name<<" ���ſεĳɼ�:"
	<<stu[i].score[0]<<" "<<stu[i].score[1]<<" "<<stu[i].score[2]<<endl;
}

#include<iostream>
using namespace std;
const int n=3;
struct student
{	char num[6];
	char name[20];
	int score[3];
	float aver;
}stu[n];
int average(student stu[n])
{int sum=0;float aver;
	for(int i=0;i<n;i++)
    {sum+=stu[i].aver;
	}aver=sum/3;
    return aver;
}
void max(student stu[n])
{int k,sum=0,max=stu[0].aver;
	for(int i=0;i<n;i++)
    if(max<stu[i].aver)
	{max=stu[i].aver;k=i;}
    sum=stu[k].score[0]+stu[k].score[1]+stu[k].score[2];
	cout<<"��һ��Ϊ:"<<stu[k].name<<",�ܷ�Ϊ:"<<sum<<endl;
}
void print(student stu[n])
{cout<<"ѧ��"<<'\t'<<"����"<<'\t'<<"����"<<'\t'<<"C++"<<'\t'<<"��Ӣ"<<'\t'<<"ƽ����"<<endl;
    for(int i=0;i<n;i++)
	cout<<stu[i].num<<'\t'<<stu[i].name<<'\t'
	<<stu[i].score[0]<<'\t'<<stu[i].score[1]<<'\t'<<stu[i].score[2]<<'\t'<<stu[i].aver<<endl;
	cout<<"��ƽ����="<<average(stu)<<endl;
	max(stu);	
}
int main()
{
	for(int i=0;i<n;i++)
	{cout<<"�������"<<i+1<<"λѧ������Ϣ:"<<endl;
	 cout<<"ѧ��:";
	 cin>>stu[i].num;
	 cout<<"����:";
	 cin>>stu[i].name;
	 cout<<"score1:";
	 cin>>stu[i].score[0];
	 cout<<"score2:";
	 cin>>stu[i].score[1];
     cout<<"score3:";
	 cin>>stu[i].score[2];
	 cout<<endl;
	}
    for(i=0;i<n;i++)
    {stu[i].aver=(stu[i].score[0]+stu[i].score[1]+stu[i].score[2])/3;}
	print(stu);
	system("pause");
	return 0;
}
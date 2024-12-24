#include<iostream>
using namespace std;
void main()
{float fun1(float score[3][4],int i);
 float fun2(float score[4],int n);	
 float score[3][4]={{65,67,70 ,60},{80,87,90,81},{90,99,100,98}};
 cout<<"aver1="<<fun1(score,3)<<endl;
 cout<<"aver2="<<fun2(*score,12)<<endl;
 system("pause");
}
float fun1(float score[3][4],int i)
{float aver1,sum=0;
	for(int k=0;k<i;k++)
    for(int j=0;j<4;j++)
		sum+=*(*(score+k)+j);
	aver1=sum/12;
	return aver1;
}
float fun2(float score[4],int n)
{float aver2,sum=0;
	for(int i=0;i<3;i++)
    {for(int j=0;j<4;j++)
		sum+=*(score+j);
	score=score+4;
	}
	aver2=sum/n;
	return aver2;
}



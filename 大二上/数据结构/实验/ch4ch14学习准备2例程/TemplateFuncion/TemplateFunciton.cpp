#include <iostream.h>
#include "Time24.h" //time24 ��ʵ��0�����time24������
/*
///////////////////////////////
//����һ:���岻ͬ���Ƶĺ���
////////////////////////////////
//�ж���������ֵ�Ƿ����
int iEqual(int x,int y)
{     return (x==y);   }

//�ж���������ֵ�Ƿ����
int fEqual(double x,double y)
{     return (x==y);   }

//�ж�����ʱ��ֵ�Ƿ����
int sEqual(Time24 x,Time24 y)
{     return (x==y);   }
//////////////////////////////////
*/


///////////////////////////////
//������:����Equal
////////////////////////////////
//�ж���������ֵ�Ƿ����
int Equal(int x,int y)
{     return (x==y);   }


//�ж���������ֵ�Ƿ����
int Equal(double x,double y)
{     return (x==y);   }

//�ж�����ʱ��ֵ�Ƿ����
int Equal(Time24 x,Time24 y)
{     return (x==y);   }
//////////////////////////////////


/*
///////////////////////////////
//������:ģ�庯��Equal
////////////////////////////////
//�ж�����ֵ�Ƿ����
template<typename T>
int Equal(T x,T y)
{     return (x==y);   }
////////////////////////////////
*/

void main()
{
time24 aTime(5,30),bTime��15,30);
cout<<Equal(3,5)<<endl;
cout<<Equal(4.1,5.3)<<endl;
cout<<Equal(aTime,bTime)<<endl;
}


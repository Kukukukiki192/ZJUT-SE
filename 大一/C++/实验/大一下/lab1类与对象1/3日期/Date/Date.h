class Date
{public:
Date(int y,int m,int d):year(y),month(m),day(d){}//1)������Ϣ����
void display();//2)��ʾ����
int weekday();//3)������������ڼ�
void m_calendar();//4)�ṩ���µ�������ʾ
int daysOfDate();//5)��������ڵ�������
private:
int year;
int month;
int day;
};

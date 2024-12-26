class Date
{public:
Date(int y,int m,int d):year(y),month(m),day(d){}//1)日期信息设置
void display();//2)显示日期
int weekday();//3)计算该日是星期几
void m_calendar();//4)提供该月的月历显示
int daysOfDate();//5)计算该日期的总天数
private:
int year;
int month;
int day;
};

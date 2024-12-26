//time24.h
#ifndef ITEM_BASE
#define ITEM_BASE
class time24
{
public:
     time24(int,int);   //初始化 小时，分钟
     void addTime(int m);      //增加m分钟到当前时间，更新时间。
                                               //Precondition: m非负
                                                //Postcondition:新时间比原来延迟m分钟
     time24 duration(const time24& t);   //返回当前时间与t之间的间隔
                                                                  //Precondition: t比当前时间晚
     void readTime();     //从键盘输入时间，格式：hh:mm
                                      //Postcondition:给时间和分钟赋值
     void writeTime() const;   //将当前时间显示在屏幕上，格式:  hh:mm
     int getHour() const;     //返回当前时间的小时部分
     int getMinute() const;  //返回当前时间的分钟部分
private:
    int Hour,Minute;
    void normalizeTime()//标准化函数,保证hour(0-23),minute(0-59)
	{
		Minute%=60;
		Hour=(Hour+Minute/60)%24;
	} 
};  
#endif
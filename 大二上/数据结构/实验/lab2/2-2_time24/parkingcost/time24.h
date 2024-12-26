//time24.h
#ifndef ITEM_BASE
#define ITEM_BASE
class time24
{
public:
     time24(int,int);   //��ʼ�� Сʱ������
     void addTime(int m);      //����m���ӵ���ǰʱ�䣬����ʱ�䡣
                                               //Precondition: m�Ǹ�
                                                //Postcondition:��ʱ���ԭ���ӳ�m����
     time24 duration(const time24& t);   //���ص�ǰʱ����t֮��ļ��
                                                                  //Precondition: t�ȵ�ǰʱ����
     void readTime();     //�Ӽ�������ʱ�䣬��ʽ��hh:mm
                                      //Postcondition:��ʱ��ͷ��Ӹ�ֵ
     void writeTime() const;   //����ǰʱ����ʾ����Ļ�ϣ���ʽ:  hh:mm
     int getHour() const;     //���ص�ǰʱ���Сʱ����
     int getMinute() const;  //���ص�ǰʱ��ķ��Ӳ���
private:
    int Hour,Minute;
    void normalizeTime()//��׼������,��֤hour(0-23),minute(0-59)
	{
		Minute%=60;
		Hour=(Hour+Minute/60)%24;
	} 
};  
#endif
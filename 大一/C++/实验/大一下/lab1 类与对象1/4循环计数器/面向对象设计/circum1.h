class circum
{public:
    void set_mode(unsigned int,unsigned int);//����ѭ��������ģ
	void set_value(int);//����ѭ���������ĵ�ǰֵ
	int get_value();//��ѯѭ���������ĵ�ǰֵ
	void increment();//ѭ����������1
	void decrement(); //ѭ����������1 
private:
	int min_val;
	int max_val;
	int current;
};
class circular_numbers{
public:
	void set_mode(int,int);//设置循环计数器模
	void set_value(int);//设置循环计数器的当前值
	int get_value();//查询循环计数器的当前值
	void increment();//循环计数器加1
	void decrement(); //循环计数器减1 
private:
	int min_val;
	int max_val;
	int current;
};
#include <iostream>
using namespace std;

class SupperArray{
public:
	//构造系列
	SupperArray(unsigned n,int value); //用指定值value初始化n个单元    
    SupperArray(const SupperArray& obj);//拷贝构造
	//赋值重载
	SupperArray& operator=(const SupperArray& right);
    //下标运算
	int& operator[](unsigned index);
    //调整容量
	void set_size(unsigned newsize); //调整容量到newsize
	//获取容量 
	int get_size()const;
    //也可以用下面两个函数代替
	//void expand(unsigned delta);//调整容量到size+delta
	//void subtract(unsigned delta);//调整容量到size-delta
 
    void sort();//升序排序
    friend ostream& operator<<(ostream & out, SupperArray& obj); 
    friend SupperArray operator+(SupperArray& left, SupperArray& right);
    ~SupperArray();//析构
private:
	int *data;
	int size;
};
SupperArray::SupperArray(unsigned n,int value)
{
	size=n;
	for(int i=0;i<size;++i){data[i]=value;}
}
SupperArray::SupperArray(const SupperArray& obj)
{
	size=obj.size;
	for(int i=0;i<size;++i){data[i]=obj.data[i];}
}
SupperArray& SupperArray::operator=(const SupperArray& right)
{
	size=right.size;
	for(int i=0;i<size;++i){data[i]=right.data[i];}
	return *this;
}
int& SupperArray::operator[ ](unsigned index)
{
    if((index<0)||(index>size-1)){
       cout<<"下标越界！"<<endl;
       exit(1);}
     return data[index];
}
void SupperArray::set_size(unsigned newsize)
{size=newsize;
}
int SupperArray::get_size()const
{return size;
}
void SupperArray::sort()
{
	int i,j,k,t;
	for(i=0;i<size-1;++i)
	{k=i;
		for(j=i+1;j<size;++j)
		if(data[k]>data[j])k=j;
		t=data[i];data[i]=data[k];data[k]=t;
	}
}
ostream& operator<<(ostream & out, SupperArray& obj)
//输出数组中的所有元素,obj这里不能设计成const，思考为什么
{
	for(int i=0;i<obj.size;++i)
	{out<<obj.data[i]<<" ";
	}out<<endl;
    return out;
}
SupperArray operator+(SupperArray& left, SupperArray& right)
 //表示求left和right的拼接结果，复杂可以求left和right的并集
{
	int n=left.size;
	SupperArray c;
	for(int i=0;i<n;++i)
	{c[i]=left.data[i];
	}
	for(int i=n;i<n*2;++i)
	{c[i]=right.data[i];
	}
	return c;
}
//SupperArray  operator-(SupperArray& left, SupperArray & right); 
//表示求left和right的差集，选做

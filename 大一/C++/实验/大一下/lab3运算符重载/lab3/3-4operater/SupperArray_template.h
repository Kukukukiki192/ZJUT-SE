#include <iostream>
using namespace std;
template<class T>
class SupperArray{
public:
	//构造系列
	SupperArray(unsigned n=10);//n个单元
	SupperArray(unsigned n,T value);//用指定值value初始化n个单元 
    SupperArray(const SupperArray& obj);//拷贝构造
	//赋值重载
	SupperArray& operator=(const SupperArray& right);
                   //下标运算
	T& operator[](unsigned index);
                  //调整容量
	void set_size(unsigned newsize); //调整容量到newsize
	
	int get_size()const;

                   //也可以用下面两个函数代替
	//void expand(unsigned delta);//调整容量到size+delta
	//void subtract(unsigned delta);//调整容量到size-delta

                  void sort();//升序排序
friend ostream& operator<<(ostream & out, SupperArray<T>& obj);
friend SupperArray<T> operator+(SupperArray<T>& left, SupperArray<T>& right);
                 //析构
				  ~SupperArray(){delete[] data;}
private:
	T *data;
	int size;
};

/*template<class T>
ostream& operator<<(ostream & out, SupperArray<T>& obj); 
//输出数组中的所有元素

template<class T>
SupperArray<T>  operator+(SupperArray<T>& left, SupperArray<T>& right);
 //表示求left和right的拼接结果，复杂可以求left和right的并集
#include"C:\Users\admin\Desktop\实验三-运算符重载\实验三-运算符重载\3-4 operator\SupperArray_template.h"*/
template<class T>
SupperArray<T>::SupperArray(unsigned n)
{
   size=n;
   data=new T [size];
   }
template<class T>
SupperArray<T>::SupperArray(unsigned n,T value)
{ 
   for(int i=0;i<n;i++)
     data[i]=value;
 }
 template<class T>
 SupperArray<T>::SupperArray(const SupperArray& obj)
 {
 size=obj.size;
 data=new T[size];
 for(int i=0;i<size;i++)
	 data[i]=obj.data[i];
 }
 template<class T>
 SupperArray<T>& SupperArray<T>::operator=(const SupperArray& right)
 {
 if(&right==this)
 {
	 return *this;
 }
 if(this->data!=NULL)
 {
	 delete[] data;
	 size=0;
 }
 this->size=right.size;
 this->data=new T[this->size];
 for(int i=0;i<this->size;i++)
	 data[i]=right.data[i];
 return *this;
 }
template<class T>
T& SupperArray<T>::operator[](unsigned index)
 {
	if(index>size)
	this->set_size(index);

	 return data[index];
 }
 template<class T>
 void SupperArray<T>::set_size(unsigned newsize)
 {
	 SupperArray<T> data1;
	 data1.size=newsize;
	 data1.data=new T[newsize];
	 for(int i=0;i<size;i++)
		 data1.data[i]=data[i];
		 (*this)=data1;
 }
 template<class T>
 int SupperArray<T>::get_size()const
 {
	 return size;
 }
 template<class T>
ostream& operator<<(ostream & out, SupperArray<T>& obj)
 {
	 for(int i=0;i<obj.size;i++)
		 out<<obj.data[i]<<" ";
	 return out;
 }
 template<class T>
 SupperArray<T> operator+(SupperArray<T>& left, SupperArray<T>& right)
 {
	 SupperArray<T> c;
	 int i,n=0;
	c.set_size(left.size+right.size);
	 c.size=left.size+right.size;
	 for(i=0;i<left.size;i++)
		 c.data[i]=left.data[i];
	 for(i=c.size-left.size;i<c.size;i++)
		 c.data[i]=right.data[n++];
	 return c;
 }
 template<class T>
 void SupperArray<T>::sort()
 {
	 T t;
	 for(int i=1;i<size;i++)
		 for(int j=0;j<size-i;j++)
			 if(data[j]>data[j+1])
			 {
				 t=data[j];data[j]=data[j+1];data[j+1]=t;
			 }
 }

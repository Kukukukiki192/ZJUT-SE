#include <iostream>
using namespace std;

class SupperArray{
public:
	//����ϵ��
	SupperArray(unsigned n,int value); //��ָ��ֵvalue��ʼ��n����Ԫ    
    SupperArray(const SupperArray& obj);//��������
	//��ֵ����
	SupperArray& operator=(const SupperArray& right);
    //�±�����
	int& operator[](unsigned index);
    //��������
	void set_size(unsigned newsize); //����������newsize
	//��ȡ���� 
	int get_size()const;
    //Ҳ����������������������
	//void expand(unsigned delta);//����������size+delta
	//void subtract(unsigned delta);//����������size-delta
 
    void sort();//��������
    friend ostream& operator<<(ostream & out, SupperArray& obj); 
    friend SupperArray operator+(SupperArray& left, SupperArray& right);
    ~SupperArray();//����
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
       cout<<"�±�Խ�磡"<<endl;
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
//��������е�����Ԫ��,obj���ﲻ����Ƴ�const��˼��Ϊʲô
{
	for(int i=0;i<obj.size;++i)
	{out<<obj.data[i]<<" ";
	}out<<endl;
    return out;
}
SupperArray operator+(SupperArray& left, SupperArray& right)
 //��ʾ��left��right��ƴ�ӽ�������ӿ�����left��right�Ĳ���
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
//��ʾ��left��right�Ĳ��ѡ��

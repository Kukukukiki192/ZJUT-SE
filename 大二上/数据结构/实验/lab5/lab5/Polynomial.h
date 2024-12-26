//一元多项式类
#ifndef POLYNOMIAL
#define POLYNOMIAL
#include<iostream>
using namespace std;
template<typename CoefType>
class Polynomial{
	private:
	class Term{
		public:
			CoefType coef;
			unsigned expo;
	};
	class Node{
		public:
			Term data;
			Node *next;
			
			Node(CoefType co=0,int ex=0,Node *ptr=0){//多项式类初始化 
				data.coef=co;
				data.expo=ex;
				next=ptr;
			}
	};		
	typedef Node *Nodepointer;//用Nodepointer表示Node结构体指针
//多项式类实际上用到的数据成员: 
	int myDegree;//阶
	Nodepointer myTerms;//一个具有头节点,元素类型为Term的链表 (Node *myTerms)
	 
	public:
	Polynomial();
	Polynomial<CoefType> create();//创建多项式
	void print();
	void clean();
	Polynomial<CoefType> sort();
	Polynomial<CoefType>& operator=(const Polynomial<CoefType>&);
	//多项式操作
	Polynomial<CoefType> operator+(const Polynomial<CoefType> &secondPoly);
		
	Polynomial<CoefType> multiply(CoefType co,unsigned ex);
	Polynomial<CoefType> operator*(const Polynomial<CoefType> &secondPoly);
	
	Polynomial<CoefType> derivation(); //求导 
};
#endif

//һԪ����ʽ��
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
			
			Node(CoefType co=0,int ex=0,Node *ptr=0){//����ʽ���ʼ�� 
				data.coef=co;
				data.expo=ex;
				next=ptr;
			}
	};		
	typedef Node *Nodepointer;//��Nodepointer��ʾNode�ṹ��ָ��
//����ʽ��ʵ�����õ������ݳ�Ա: 
	int myDegree;//��
	Nodepointer myTerms;//һ������ͷ�ڵ�,Ԫ������ΪTerm������ (Node *myTerms)
	 
	public:
	Polynomial();
	Polynomial<CoefType> create();//��������ʽ
	void print();
	void clean();
	Polynomial<CoefType> sort();
	Polynomial<CoefType>& operator=(const Polynomial<CoefType>&);
	//����ʽ����
	Polynomial<CoefType> operator+(const Polynomial<CoefType> &secondPoly);
		
	Polynomial<CoefType> multiply(CoefType co,unsigned ex);
	Polynomial<CoefType> operator*(const Polynomial<CoefType> &secondPoly);
	
	Polynomial<CoefType> derivation(); //�� 
};
#endif

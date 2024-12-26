#include"Polynomial.h"
#include<iostream>
using namespace std;

template<typename CoefType>
Polynomial<CoefType>::Polynomial()
{
    myTerms=new Node;
    myDegree=0;
}
template<typename CoefType>
Polynomial<CoefType> Polynomial<CoefType>::create(){
	Polynomial<CoefType>::Nodepointer p,q,first=myTerms;
	first->next=NULL;
	CoefType co;
	int ex;
	cout<<"����ö���ʽÿһ���ϵ����ָ����ÿ��һ�У�����0 0������"<<endl;
	while(cin>>co>>ex&&ex!=0){
		if(first->next){
			p=first;
			while(p->next&&ex<p->next->data.expo) p=p->next;
			//1 ��������С(��ʱp->next==null) 2 �����ݱ�ǰ��ĳ��Ĵ�(��ʱp->next!=0) ��Ӧ������p��
			if(p->next){
				if(ex==p->next->data.expo) {//�����ݺ�ǰ��ĳ����� 
					p->next->data.coef+=co;
					if(p->next->data.coef==0) {
						q=p->next;
						p=q->next;
						delete q;
					}
				}
				else{
					q=new Polynomial<CoefType>::Node(co,ex);
					q->next=p->next;
					p->next=q;
				}
			}
			else{
				p->next=new Polynomial<CoefType>::Node(co,ex);
				p=p->next;	
			}
		}
		else first->next=new Polynomial<CoefType>::Node(co,ex);		
	}
	myDegree=first->next->data.expo;
	return *this; 
}
template<typename CoefType>
void Polynomial<CoefType>::print(){
	Polynomial<CoefType>::Nodepointer p=myTerms->next;
	while(p->next){
		cout<<p->data.coef<<"x^"<<p->data.expo;
		p=p->next;
		if(p->data.coef>0) cout<<"+";
	}
	if(p->data.expo==0) cout<<p->data.coef;
	else cout<<p->data.coef<<"x^"<<p->data.expo;
	cout<<endl;
}
template<typename CoefType>
void Polynomial<CoefType>::clean()//�ͷ��������нڵ�
{
    Polynomial<CoefType>::Nodepointer p=myTerms,q;
    while (p){
        q = p->next;
        delete p;
        p = q;
    }
    myTerms=NULL;
    myDegree= 0;
}
template<typename CoefType>
Polynomial<CoefType>& Polynomial<CoefType>::operator=(const Polynomial<CoefType>& a)
{
    clean();
    myDegree=a.myDegree;
    myTerms=a.myTerms;
    return *this;
}
//���� �ϲ�ͬ����
template<typename CoefType>
Polynomial<CoefType> Polynomial<CoefType>::sort(){
	Polynomial<CoefType>::Nodepointer p=myTerms->next,q,tail;
	if(myTerms->next->next==NULL) return *this;

	while(p->next) p=p->next;
	tail=p;

	while(tail!=myTerms->next->next){
		for(p=myTerms->next;p->next!=tail;p=p->next){
			q=p->next;
			if(p->data.expo<q->data.expo){
				unsigned t=p->data.expo; p->data.expo=q->data.expo; q->data.expo=t;
			}
			else if(p->data.expo==q->data.expo){
				p->data.coef+=q->data.coef;
				p->next=q->next;
				delete q;
			}
		}tail=p;//p->next == tail,��tail��ǰ�ƶ�һλ����
	}
	return *this;
}
//����ʽ����
//+
template<typename CoefType>//���ϵ����д��� 
Polynomial<CoefType> Polynomial<CoefType>::operator+(const Polynomial<CoefType> &a){
	Polynomial<CoefType> sumPoly;
	
	Polynomial<CoefType>::Nodepointer//�����ص�ָ��
		ptra=myTerms->next,
		ptrb=a.myTerms->next,
		ptrc=sumPoly.myTerms;//�½��Ͷ���ʽ����û��Ԫ�أ���ʼ��ָ����ǰ�����õ�ͷ�ڵ� 
		
	int d=0;//����d�洢�Ͷ���ʽ�Ľ�
	while(ptra&&ptrb){//����������ʽ�л��нڵ�ʱ
		if(ptra->data.expo > ptrb->data.expo){//ptr->data==(*ptr).data==Node�ṹ�����.data 
			ptrc->next=new Polynomial<CoefType>::Node(ptra->data.coef,ptra->data.expo);
			d=ptra->data.expo;
			ptra=ptra->next;
			ptrc=ptrc->next;
		}
		else if(ptra->data.expo < ptrb->data.expo){
			ptrc->next=new Polynomial<CoefType>::Node(ptrb->data.coef,ptrb->data.expo);
			d=ptrb->data.expo;
			ptrb=ptrb->next;
			ptrc=ptrc->next;
		}
		else{//���� 
			CoefType sum=ptra->data.coef+ptrb->data.coef;
			if(sum){
				ptrc->next=new Polynomial<CoefType>::Node(sum,ptra->data.expo);
				d=ptra->data.expo;
				ptrc=ptrc->next;
			}
			ptra=ptra->next;
			ptrb=ptrb->next;
		}
	}
	while(ptra){
        ptrc->next=new Node(ptra->data.coef,ptra->data.expo);
        ptrc=ptrc->next;
        ptra=ptra->next;
    }
   while(ptrb){
        ptrc->next=new Node(ptrb->data.coef,ptrb->data.expo);
        ptrc=ptrc->next;
        ptrb=ptrb->next;
    }
	sumPoly.myDegree=d;
	return sumPoly;
} 

//*
template<typename CoefType>
Polynomial <CoefType> Polynomial<CoefType>::multiply(CoefType co,unsigned ex){//����ʽ*����ʽ 
	Polynomial<CoefType> multiPoly; 
	Polynomial<CoefType>::Nodepointer p=myTerms->next,q=multiPoly.myTerms;
	while(p){
		CoefType mul=co*p->data.coef;//ϵ����� 
		unsigned sum=ex+p->data.expo;//ָ�����
		q->next=new Polynomial<CoefType>::Node(mul,sum);
		p=p->next;
		q=q->next; 
	}
	multiPoly.myDegree=multiPoly.myTerms->next->data.expo;
	return multiPoly;
}
template<typename CoefType>//����ʽ*����ʽ 
Polynomial<CoefType> Polynomial<CoefType>::operator*(const Polynomial<CoefType> &a){
	Polynomial<CoefType> multiPoly;
	Polynomial<CoefType>::Nodepointer p=a.myTerms->next;
	while(p){
		multiPoly=multiPoly+multiply(p->data.coef,p->data.expo);
		p=p->next;
	} 
	multiPoly.sort();
	multiPoly.myDegree=multiPoly.myTerms->next->data.expo;
	return multiPoly;
}

//�� 
template<typename CoefType>
Polynomial<CoefType> Polynomial<CoefType>::derivation(){
	Polynomial<CoefType> Poly;
	Polynomial<CoefType>::Nodepointer pre=myTerms,p=pre->next,q=Poly.myTerms;
	while(p->next){
		CoefType co=p->data.coef*p->data.expo;
		unsigned ex=p->data.expo-1;
		q->next=new Polynomial<CoefType>::Node(co,ex);	
		pre=pre->next;
		p=p->next;
		q=q->next;
	}
	if(p->data.expo==0){}
	else {
		CoefType co=p->data.coef*p->data.expo;
		unsigned ex=p->data.expo-1;
		q->next=new Polynomial<CoefType>::Node(co,ex);
	}
	Poly.myDegree=Poly.myTerms->next->data.expo;
	return Poly;
}

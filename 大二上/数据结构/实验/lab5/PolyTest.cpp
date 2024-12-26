#include"Polynomial.h"
#include"Poly.cpp"
#include<iostream>
using namespace std;
int main(){
	Polynomial<int> a,a1,b,c,d;
	
	cout<<"创建多项式y1:"<<endl;
	a.create();
	cout<<"y1=";
	a.print();
	
	cout<<"y1求导=";
	a1=a.derivation();
	a1.print();
	
	cout<<"创建多项式y2:"<<endl;
	b.create();
	cout<<"y2=";
	b.print();
	
	cout<<"y1+y2=";
	c=a+b;
	c.print();
	
	cout<<"y1*y2=";
	d=a*b;
	d.print();
}

#include"Polynomial.h"
#include"Poly.cpp"
#include<iostream>
using namespace std;
int main(){
	Polynomial<int> a,a1,b,c,d;
	
	cout<<"��������ʽy1:"<<endl;
	a.create();
	cout<<"y1=";
	a.print();
	
	cout<<"y1��=";
	a1=a.derivation();
	a1.print();
	
	cout<<"��������ʽy2:"<<endl;
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

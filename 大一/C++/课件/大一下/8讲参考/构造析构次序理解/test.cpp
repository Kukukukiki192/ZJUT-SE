#include <iostream.h>
class A{
public:
	A(int xv):x(xv){
		cout<<x<<":����A����"<<endl;
	}
	~A(){
		cout<<x<<":����A����"<<endl;
	}
private:
	int x;
};
class C{
public:
	C(int xv):x(xv){
		cout<<x<<":����C����"<<endl;
	}
	~C(){
		cout<<x<<":����C����"<<endl;
	}
private:
  int x;
};
class B{
public:
	B(A o1,A o2,C o3,int xv):obj2(o2),obj1(o1),obj3(o3){
		x=xv;
		cout<<"����B����"<<endl;
	}
	~B(){
		cout<<"����B����"<<endl;
	}
private:
	A obj1,obj2;
	C obj3;
	int x;
};

int main()
{
	A a1(1),a2(2);
	C c1(3);
	B b1(a1,a2,c1,3);
	return 0;
}
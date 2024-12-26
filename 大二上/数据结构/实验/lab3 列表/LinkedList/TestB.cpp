//#include "ArrayList.h"
#include "LinkedList.h"
#include <iostream>
using namespace std;
int success=1;
int main()
{
	//ArrayList a;
	LinkedList a; //这条注释释放同时请注释上一条声明
	a.insert(5,0);
	a.insert(7,0);
	a.insert(9,0);
	a.insert(11,0);
	a.display(cout);
	//ArrayList b(a),c;
	LinkedList b(a),c;
	b.display(cout);
	c=a;//赋值重载不能输出 ???
	c.display(cout);
	a.erase(0);
	cout<<a;
	ElementType item=10;
    node* re=a.find(item,success);
	if(success==-1) cout<<item<<"不存在！"<<endl;
	item=9;
	re=a.find(item,success);
	if(success==1){//为什么这里不使用re!=NULL的条件判断？
		a.erase(re);
	a.display(cout);
	}
	//LinkedList段测试代码完毕
   
   return 0;

}

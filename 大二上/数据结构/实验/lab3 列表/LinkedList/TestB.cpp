//#include "ArrayList.h"
#include "LinkedList.h"
#include <iostream>
using namespace std;
int success=1;
int main()
{
	//ArrayList a;
	LinkedList a; //����ע���ͷ�ͬʱ��ע����һ������
	a.insert(5,0);
	a.insert(7,0);
	a.insert(9,0);
	a.insert(11,0);
	a.display(cout);
	//ArrayList b(a),c;
	LinkedList b(a),c;
	b.display(cout);
	c=a;//��ֵ���ز������ ???
	c.display(cout);
	a.erase(0);
	cout<<a;
	ElementType item=10;
    node* re=a.find(item,success);
	if(success==-1) cout<<item<<"�����ڣ�"<<endl;
	item=9;
	re=a.find(item,success);
	if(success==1){//Ϊʲô���ﲻʹ��re!=NULL�������жϣ�
		a.erase(re);
	a.display(cout);
	}
	//LinkedList�β��Դ������
   
   return 0;

}

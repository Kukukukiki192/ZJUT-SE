#include"BST.h"
#include<iostream>
using namespace std;
int main(){
	BST<int> intBST;
	cout<<"创建BST."<<endl;
	cout<<"判空:BST"<<(intBST.empty()?"是":"不是")<<"空树."<<endl;
	
	cout<<"请输入树结点集合,输入0时结束:";
	int number;
	while(cin>>number){
		if(number==0) break;
		intBST.insert(number);//用插入法添加数,创建的树不平衡 
	}
	cout<<"按结点集合次序建立BST,即添加到创建的空树中(横向图形):"<<endl;
	intBST.graph(cout);
	
	cout<<"中序遍历:";
	intBST.inorder();
	cout<<endl;
	
	cout<<"前序遍历:";
	intBST.preorder();
	cout<<endl;
	
	cout<<"后序遍历:";
	intBST.postorder();
	cout<<endl;
	
	cout<<"层次遍历:";
	intBST.levelorder();
	cout<<endl;
	
	cout<<"插入一个数:";
	cin>>number;
	intBST.insert(number);
	cout<<"中序遍历:";
	intBST.inorder();
	cout<<endl;
	cout<<"图形:"<<endl;
	intBST.graph(cout);
	cout<<endl;
	
	cout<<"查找一个数:";
	cin>>number;
	cout<<(intBST.search(number)?"找到.":"未找到.")<<endl;
	
	cout<<"删除一个数:";
	cin>>number;
	intBST.remove(number);
	cout<<"中序遍历:";
	intBST.inorder();
	cout<<endl;
	cout<<"图形:"<<endl;
	intBST.graph(cout);
	cout<<endl;
	//程序结束时会调用析构函数清空树 
	return 0;
}

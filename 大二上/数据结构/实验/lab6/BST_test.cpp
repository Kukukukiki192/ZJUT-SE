#include"BST.h"
#include<iostream>
using namespace std;
int main(){
	BST<int> intBST;
	cout<<"����BST."<<endl;
	cout<<"�п�:BST"<<(intBST.empty()?"��":"����")<<"����."<<endl;
	
	cout<<"����������㼯��,����0ʱ����:";
	int number;
	while(cin>>number){
		if(number==0) break;
		intBST.insert(number);//�ò��뷨�����,����������ƽ�� 
	}
	cout<<"����㼯�ϴ�����BST,����ӵ������Ŀ�����(����ͼ��):"<<endl;
	intBST.graph(cout);
	
	cout<<"�������:";
	intBST.inorder();
	cout<<endl;
	
	cout<<"ǰ�����:";
	intBST.preorder();
	cout<<endl;
	
	cout<<"�������:";
	intBST.postorder();
	cout<<endl;
	
	cout<<"��α���:";
	intBST.levelorder();
	cout<<endl;
	
	cout<<"����һ����:";
	cin>>number;
	intBST.insert(number);
	cout<<"�������:";
	intBST.inorder();
	cout<<endl;
	cout<<"ͼ��:"<<endl;
	intBST.graph(cout);
	cout<<endl;
	
	cout<<"����һ����:";
	cin>>number;
	cout<<(intBST.search(number)?"�ҵ�.":"δ�ҵ�.")<<endl;
	
	cout<<"ɾ��һ����:";
	cin>>number;
	intBST.remove(number);
	cout<<"�������:";
	intBST.inorder();
	cout<<endl;
	cout<<"ͼ��:"<<endl;
	intBST.graph(cout);
	cout<<endl;
	//�������ʱ������������������ 
	return 0;
}

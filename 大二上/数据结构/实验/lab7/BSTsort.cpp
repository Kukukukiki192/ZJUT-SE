#include<iostream>
#include <vector>
using namespace std;

template <class T>
class BST{ 
public:
    BST():myRoot(0){}
    void inorder(vector<T> &x); //�������
    void insert(const T& item);//����
private:
	class BinNode{
	public:
    BinNode():left(0),right(0){}
    BinNode(T item):data(item),left(0),right(0){}
   
    T data;//����
    BinNode*  left; //������ָ�� 
    BinNode* right; //������ָ�� 
	}; 
    BinNode* myRoot;//����ָ��
    
    //����˽�г�Ա������������
    void inorder1(BinNode*,vector<T> &x);
    void insert1(BinNode*&,const T&);//��������(�ݹ�)  
};


//���룭�ݹ� O(log2n)
template<class T> 
void BST<T>::insert(const T& item){  
	insert1(myRoot,item);  
}
template<class T> 
void BST<T>::insert1(BinNode* &root,const T& item){       
	if(!root) root=new BinNode(item);
    else if(item<=root->data) insert1(root->left,item); //���뵽������
    else insert1(root->right,item); //���뵽������
}

//�������-�ݹ�
template <class T>
void BST<T>::inorder(vector<T> &x){   
	inorder1(myRoot,x);  
}
template<class T>
void BST<T>::inorder1(BinNode* root,vector<T> &x){
	static int j=1;     
    if(root){
        inorder1(root->left,x);
        x[j++]=root->data;
        inorder1(root->right,x);
    }
}

template<class T>//�������������
void BSTSort(vector<T> &x){
	BST<T> y;
	for(int i=1;i<x.size();i++){
		y.insert(x[i]);
	}   y.inorder(x);
}

#include<iostream>
#include <vector>
using namespace std;

template <class T>
class BST{ 
public:
    BST():myRoot(0){}
    void inorder(vector<T> &x); //中序遍历
    void insert(const T& item);//插入
private:
	class BinNode{
	public:
    BinNode():left(0),right(0){}
    BinNode(T item):data(item),left(0),right(0){}
   
    T data;//数据
    BinNode*  left; //左子树指针 
    BinNode* right; //右子树指针 
	}; 
    BinNode* myRoot;//树根指针
    
    //其他私有成员函数（辅助）
    void inorder1(BinNode*,vector<T> &x);
    void insert1(BinNode*&,const T&);//辅助插入(递归)  
};


//插入－递归 O(log2n)
template<class T> 
void BST<T>::insert(const T& item){  
	insert1(myRoot,item);  
}
template<class T> 
void BST<T>::insert1(BinNode* &root,const T& item){       
	if(!root) root=new BinNode(item);
    else if(item<=root->data) insert1(root->left,item); //插入到左子树
    else insert1(root->right,item); //插入到右子树
}

//中序遍历-递归
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

template<class T>//二叉查找树排序
void BSTSort(vector<T> &x){
	BST<T> y;
	for(int i=1;i<x.size();i++){
		y.insert(x[i]);
	}   y.inorder(x);
}

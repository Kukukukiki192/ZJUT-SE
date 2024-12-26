#include<iostream>
#include<stack>
#include<deque>
#include<iomanip>
using namespace std;
//二叉树的遍历:1.深度优先遍历:前中后序遍历2.广度优先遍历:即层次遍历
template <typename DataType>
class BST{ 
public:
    BST();
    ~BST();
    bool empty();//判空
    
    //维护二叉查找树特性的函数:
    void inorder(); //中序遍历,注意比较p593~p596的复杂版
    void preorder();//前序遍历
    void postorder();//后序遍历
    void levelorder();//层次遍历 
    bool search(const DataType& item) const;//查找
    void insert(const DataType& item);//插入
    void remove(const DataType& item);//删除   
    void graph(ostream& out) const;//图形打印
private:
	class BinNode{
	public:
    BinNode():left(0),right(0){}
    BinNode(DataType item):data(item),left(0),right(0){}
   
    DataType data;//数据
    BinNode*  left; //左子树指针 
    BinNode* right; //右子树指针 
	}; 
    BinNode* myRoot;//树根指针
    
    //其他私有成员函数（辅助）
  	void clean(BinNode*&);//辅助析构 
    void inorder(BinNode*);
    void preorder(BinNode*);
    void postorder(BinNode*);
    void insertAux(BinNode*&,const DataType&);//辅助插入(递归) 
    void search2(const DataType& item,bool &found,BinNode* &p,BinNode* &parent)const;//辅助删除 
    void graphAux(ostream& out,int indent,BinNode* root) const;//辅助打印 
};

template <typename DataType>
BST<DataType>::BST():myRoot(0){}

/*	二叉树的清空操作
	容易混淆的错误声明：void clean(BinNode* p)这种声明会创建一个局部的临时对象来保存传递的指针
	虽然2个指针都执行同一块堆空间，delete局部指针 会删除二叉树结构所占用的堆内存
	但是全局传递的那个指针将会是垃圾指针,会产生不可预料的错误
	void clean(BinNode *& p)此函数的参数为全局指针的一个别名,代表全局指针myRoot本身
	这样p=NULL能达到置空指针的作用 
	可选的方案是在调用完clean方法之后,在主函数中执行myRoot=NULL操作		*/
template <typename DataType>
void BST<DataType>::clean(BinNode* &p){//!!!传递指针的引用,消毁函数，用来消毁二叉树中的各个结点
    if(p!=NULL){	
    	clean(p->left);
    	clean(p->right);
    	delete p;
/*	delete只能释放由用户通过new方式在堆中申请的内存，
    是通过变量声明的方式由系统所声明的栈内存不能使用delete删除 
    delete和free函数一样，不修改它参数对应指针指向的内容，也不修改指针本身，
    只是在堆内存管理结构中将指针指向的内容标记为可被重新分配  */  	
    	p=NULL;
/*	堆上内存释放 栈上指针并不销毁
    此时p指向的地址未知,此时执行*p=? 操作会导致不可预料的错误
    但是可以重新赋值p=&x;
    最好delete之后把P置空	*/
	}
}//删除所有节点
template <typename DataType>
BST<DataType>::~BST(){
	clean(myRoot);	
	cout<<"删除该树.判空:BST"<<(empty()?"是":"不是")<<"空树."<<endl;
}

template <typename DataType>
bool BST<DataType>::empty(){
	return myRoot==0;
}

//中序遍历的递归实现
template <typename DataType>
void BST<DataType>::inorder(){   
	inorder(myRoot);  
}
template<typename DataType>
void BST<DataType>::inorder(BinNode* root){     
    if(root){
        inorder(root->left);
        cout<<root->data<<" ";
        inorder(root->right);
    }
}

//前序遍历的递归实现
template <typename DataType>
void BST<DataType>::preorder(){
   preorder(myRoot);  
}
template<typename DataType>
void BST<DataType>::preorder(BinNode* root){     
    if(root){
        cout<<root->data<<" ";
        preorder(root->left);
        preorder(root->right);
    }
}


//后序遍历的递归实现
template <typename DataType>
void BST<DataType>::postorder(){   
	postorder(myRoot);  
}
template<typename DataType>
void BST<DataType>::postorder(BinNode* root){     
    if(root){
        postorder(root->left);
        postorder(root->right); 
        cout<<root->data<<" ";
    }
}

/*	层次遍历-队列FIFO
 	按层次遍历,首先遍历根节点,然后左子树,右子树,后左子树的左子树,左子树的右子树,
	右子树的左子树,依此类推.每遍历到一个节点,就将它存在一个数据结构里,
	先把它的前面的节点遍历完,才能遍历它,也就是一个先进先出(FIFO)的遍历方式	 */ 
template <typename DataType>
void BST<DataType>::levelorder(){
	deque<BinNode*> q;
	BinNode* root=myRoot;
	if(root) q.push_back(root);
	while(!q.empty()){
		root=q.front();
		q.pop_front();
		cout<<root->data<<" ";		
		if(root->left) q.push_back(root->left);
		if(root->right) q.push_back(root->right);
	}
}

//查找 
template <typename DataType> 
bool BST<DataType>::search(const DataType& item) const{
	BinNode* p=myRoot;
    while(p){
        if(item<p->data) p=p->left; //左子树寻找
        else if(item>p->data) p=p->right;//右子树寻找
        else return true;//找到
    }
    return  false;
} //效率 O(log2n)

//插入－递归
template<class DataType> 
void BST<DataType>::insert(const DataType& item){  
	insertAux(myRoot,item);  
}
template<class DataType> 
void BST<DataType>::insertAux(BinNode* &root,const DataType& item){ //!!!&和clean一样的道理      
	if(!root) root=new BinNode(item);
    else if(item<root->data) insertAux(root->left,item); //插入到左子树
    else if(item>root->data) insertAux(root->right,item); //插入到右子树
    else cout<<"该节点已存在!"<<endl;
}//效率 O(log2n)

//删除 
template <typename DataType>
void BST<DataType>::search2(const DataType& item,bool &found,BinNode* &p,BinNode* &parent)const{
//!!!&和clean一样的道理 
	p=myRoot;
	parent=0;
	found=false;
	while(!found&&p){
		if(item<p->data) {
			parent=p;
			p=p->left; //左子树寻找
		}
        else if(item>p->data) {
        	parent=p;
			p=p->right;//右子树寻找
		}
        else found=true;//找到item 
	}
}
template <typename DataType>
void BST<DataType>::remove(const DataType& item){
	bool found;
	BinNode *parent,*x;//x-to_delete
	search2(item,found,x,parent);//使用辅助函数定位item及其双亲节点 
	if(!found){
		cout<<"该节点不存在!"<<endl;
		return;
	}
	//节点有2子 
	if(x->left&&x->right){
		//查找x的中序后继及其双亲节点 
		BinNode* xSucc=x->right;//xSucc-x的中序后继 
		parent=x;
		while(xSucc->left){
			parent=xSucc;
			xSucc=xSucc->left;
		}
		x->data=xSucc->data;
		x=xSucc;
	}
	//节点无子或只有1子
	BinNode* subtree=x->left;
	if(!subtree) subtree==x->right;//	
	if(!parent) myRoot=subtree;
	else if(parent->left==x) parent->left=subtree;
	else parent->right=subtree;
	delete x;
}

//图形打印 
template<typename DataType>
void BST<DataType>::graph(ostream& out) const{
	graphAux(out,0,myRoot);
}
template<typename DataType>
void BST<DataType>::graphAux(ostream& out,int indent,BinNode* root) const{
	if(root){
		graphAux(out,indent+8,root->right);
		out<<setw(indent)<<" "<<root->data<<endl;
		graphAux(out,indent+8,root->left);
	}
}

//中序遍历的非递归实现-压栈 
//template <typename DataType>
//void BST<DataType>::inorder(){  
//	stack<BinNode*> s;
//    BinNode* root =myRoot;
//    while(!s.empty()||root) {
//    if(root){
//		s.push(root);
//        root=root->left; 
//	}
//    else if(!root&&s.top()){    
//		root=s.top(); 
//    	s.pop(); 
//        cout<<root->data<<" ";//访问(root->data);
//        root=root->right;     
//		}
//	else break;
//    }     
//}
//
////前序的非递归实现
//template <typename DataType>
//void BST<DataType>::preorder(){  
//	stack<BinNode*> s;
//    BinNode* root =myRoot;
//    while(!s.empty()||root){
//    	if(root){     
//			cout<<root->data<<" ";//访问(root->data);      
//           	s.push(root);
//            root=root->left; 
//		}
//       else{    
//	   		root=s.top(); 
//            s.pop();                     
//            root=root->right;     
//		}
//    }     
//}
//
////后序的非递归实现(联想后缀表达式 先输出最左下角 左边的一串数遍历2次)
////后序非递归难理解,递归好理解 
//template <typename DataType>
//void BST<DataType>::postorder(){
//    stack<BinNode*> s;
//    BinNode* root=myRoot;
//    stack<int> flag_s; //辅助的标记栈或者修改BinNode增加标志域
//    while(!s.empty( )|| root){  
//		if(root){     
//            s.push(root);  
//			flag_s.push(0);   
//			root=root->left;       
//		}
//        else if(flag_s.top( )==0){ //查看栈顶标志，第一次访问则修改标记。
//            flag_s.top( )=1;         
//			root=s.top( )->right;                 
//		}
//        else{ //第二次访问， 则访问节点值，节点出栈。 
//            root=s.top();
//			s.pop( ); 
//			flag_s.pop( ); 
//            cout<<root->data<<" ";//访问(root->data); 
//            root=0;//ppt上没有 注意！ 
//        }  
//	} 
//}

//插入-非递归 
//template <typename DataType>
//void BST<DataType>::insert(const DataType& item){
// 	BinNode* newnode=new BinNode(item);
//    if(myRoot){  //当前树不空，找一个合适的位置放入
//        BinNode  *p=myRoot,*parent=0; 
//        while(p){     
//			parent=p; //保存父节点
//            if(item<p->data){ //插入到左子树
//                p=p->left;
//                if(!p){  //无左子节点，插入
//                    parent->left=newnode;
//                    return;  
//				} //return为出口          
//			}
//            else if(item>p->data){ //插入到右子节点
//         	    p=p->right;
//                if(!p){ //无右子节点，插入
//            	    parent->right=newnode;
//                    return;        
//				}                
//			}
//            else{
//				cout<<"该节点已存在!"<<endl;  
//				return;
//			} 
//        }            
//	}
//    else myRoot=newnode;//当前树空，先构造以此为根的树。                                                     	
//}//效率 O(log2n)

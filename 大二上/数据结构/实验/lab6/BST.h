#include<iostream>
#include<stack>
#include<deque>
#include<iomanip>
using namespace std;
//�������ı���:1.������ȱ���:ǰ�к������2.������ȱ���:����α���
template <typename DataType>
class BST{ 
public:
    BST();
    ~BST();
    bool empty();//�п�
    
    //ά��������������Եĺ���:
    void inorder(); //�������,ע��Ƚ�p593~p596�ĸ��Ӱ�
    void preorder();//ǰ�����
    void postorder();//�������
    void levelorder();//��α��� 
    bool search(const DataType& item) const;//����
    void insert(const DataType& item);//����
    void remove(const DataType& item);//ɾ��   
    void graph(ostream& out) const;//ͼ�δ�ӡ
private:
	class BinNode{
	public:
    BinNode():left(0),right(0){}
    BinNode(DataType item):data(item),left(0),right(0){}
   
    DataType data;//����
    BinNode*  left; //������ָ�� 
    BinNode* right; //������ָ�� 
	}; 
    BinNode* myRoot;//����ָ��
    
    //����˽�г�Ա������������
  	void clean(BinNode*&);//�������� 
    void inorder(BinNode*);
    void preorder(BinNode*);
    void postorder(BinNode*);
    void insertAux(BinNode*&,const DataType&);//��������(�ݹ�) 
    void search2(const DataType& item,bool &found,BinNode* &p,BinNode* &parent)const;//����ɾ�� 
    void graphAux(ostream& out,int indent,BinNode* root) const;//������ӡ 
};

template <typename DataType>
BST<DataType>::BST():myRoot(0){}

/*	����������ղ���
	���׻����Ĵ���������void clean(BinNode* p)���������ᴴ��һ���ֲ�����ʱ���������洫�ݵ�ָ��
	��Ȼ2��ָ�붼ִ��ͬһ��ѿռ䣬delete�ֲ�ָ�� ��ɾ���������ṹ��ռ�õĶ��ڴ�
	����ȫ�ִ��ݵ��Ǹ�ָ�뽫��������ָ��,���������Ԥ�ϵĴ���
	void clean(BinNode *& p)�˺����Ĳ���Ϊȫ��ָ���һ������,����ȫ��ָ��myRoot����
	����p=NULL�ܴﵽ�ÿ�ָ������� 
	��ѡ�ķ������ڵ�����clean����֮��,����������ִ��myRoot=NULL����		*/
template <typename DataType>
void BST<DataType>::clean(BinNode* &p){//!!!����ָ�������,���ٺ������������ٶ������еĸ������
    if(p!=NULL){	
    	clean(p->left);
    	clean(p->right);
    	delete p;
/*	deleteֻ���ͷ����û�ͨ��new��ʽ�ڶ���������ڴ棬
    ��ͨ�����������ķ�ʽ��ϵͳ��������ջ�ڴ治��ʹ��deleteɾ�� 
    delete��free����һ�������޸���������Ӧָ��ָ������ݣ�Ҳ���޸�ָ�뱾��
    ֻ���ڶ��ڴ����ṹ�н�ָ��ָ������ݱ��Ϊ�ɱ����·���  */  	
    	p=NULL;
/*	�����ڴ��ͷ� ջ��ָ�벢������
    ��ʱpָ��ĵ�ַδ֪,��ʱִ��*p=? �����ᵼ�²���Ԥ�ϵĴ���
    ���ǿ������¸�ֵp=&x;
    ���delete֮���P�ÿ�	*/
	}
}//ɾ�����нڵ�
template <typename DataType>
BST<DataType>::~BST(){
	clean(myRoot);	
	cout<<"ɾ������.�п�:BST"<<(empty()?"��":"����")<<"����."<<endl;
}

template <typename DataType>
bool BST<DataType>::empty(){
	return myRoot==0;
}

//��������ĵݹ�ʵ��
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

//ǰ������ĵݹ�ʵ��
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


//��������ĵݹ�ʵ��
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

/*	��α���-����FIFO
 	����α���,���ȱ������ڵ�,Ȼ��������,������,����������������,��������������,
	��������������,��������.ÿ������һ���ڵ�,�ͽ�������һ�����ݽṹ��,
	�Ȱ�����ǰ��Ľڵ������,���ܱ�����,Ҳ����һ���Ƚ��ȳ�(FIFO)�ı�����ʽ	 */ 
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

//���� 
template <typename DataType> 
bool BST<DataType>::search(const DataType& item) const{
	BinNode* p=myRoot;
    while(p){
        if(item<p->data) p=p->left; //������Ѱ��
        else if(item>p->data) p=p->right;//������Ѱ��
        else return true;//�ҵ�
    }
    return  false;
} //Ч�� O(log2n)

//���룭�ݹ�
template<class DataType> 
void BST<DataType>::insert(const DataType& item){  
	insertAux(myRoot,item);  
}
template<class DataType> 
void BST<DataType>::insertAux(BinNode* &root,const DataType& item){ //!!!&��cleanһ���ĵ���      
	if(!root) root=new BinNode(item);
    else if(item<root->data) insertAux(root->left,item); //���뵽������
    else if(item>root->data) insertAux(root->right,item); //���뵽������
    else cout<<"�ýڵ��Ѵ���!"<<endl;
}//Ч�� O(log2n)

//ɾ�� 
template <typename DataType>
void BST<DataType>::search2(const DataType& item,bool &found,BinNode* &p,BinNode* &parent)const{
//!!!&��cleanһ���ĵ��� 
	p=myRoot;
	parent=0;
	found=false;
	while(!found&&p){
		if(item<p->data) {
			parent=p;
			p=p->left; //������Ѱ��
		}
        else if(item>p->data) {
        	parent=p;
			p=p->right;//������Ѱ��
		}
        else found=true;//�ҵ�item 
	}
}
template <typename DataType>
void BST<DataType>::remove(const DataType& item){
	bool found;
	BinNode *parent,*x;//x-to_delete
	search2(item,found,x,parent);//ʹ�ø���������λitem����˫�׽ڵ� 
	if(!found){
		cout<<"�ýڵ㲻����!"<<endl;
		return;
	}
	//�ڵ���2�� 
	if(x->left&&x->right){
		//����x�������̼���˫�׽ڵ� 
		BinNode* xSucc=x->right;//xSucc-x�������� 
		parent=x;
		while(xSucc->left){
			parent=xSucc;
			xSucc=xSucc->left;
		}
		x->data=xSucc->data;
		x=xSucc;
	}
	//�ڵ����ӻ�ֻ��1��
	BinNode* subtree=x->left;
	if(!subtree) subtree==x->right;//	
	if(!parent) myRoot=subtree;
	else if(parent->left==x) parent->left=subtree;
	else parent->right=subtree;
	delete x;
}

//ͼ�δ�ӡ 
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

//��������ķǵݹ�ʵ��-ѹջ 
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
//        cout<<root->data<<" ";//����(root->data);
//        root=root->right;     
//		}
//	else break;
//    }     
//}
//
////ǰ��ķǵݹ�ʵ��
//template <typename DataType>
//void BST<DataType>::preorder(){  
//	stack<BinNode*> s;
//    BinNode* root =myRoot;
//    while(!s.empty()||root){
//    	if(root){     
//			cout<<root->data<<" ";//����(root->data);      
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
////����ķǵݹ�ʵ��(�����׺���ʽ ����������½� ��ߵ�һ��������2��)
////����ǵݹ������,�ݹ����� 
//template <typename DataType>
//void BST<DataType>::postorder(){
//    stack<BinNode*> s;
//    BinNode* root=myRoot;
//    stack<int> flag_s; //�����ı��ջ�����޸�BinNode���ӱ�־��
//    while(!s.empty( )|| root){  
//		if(root){     
//            s.push(root);  
//			flag_s.push(0);   
//			root=root->left;       
//		}
//        else if(flag_s.top( )==0){ //�鿴ջ����־����һ�η������޸ı�ǡ�
//            flag_s.top( )=1;         
//			root=s.top( )->right;                 
//		}
//        else{ //�ڶ��η��ʣ� ����ʽڵ�ֵ���ڵ��ջ�� 
//            root=s.top();
//			s.pop( ); 
//			flag_s.pop( ); 
//            cout<<root->data<<" ";//����(root->data); 
//            root=0;//ppt��û�� ע�⣡ 
//        }  
//	} 
//}

//����-�ǵݹ� 
//template <typename DataType>
//void BST<DataType>::insert(const DataType& item){
// 	BinNode* newnode=new BinNode(item);
//    if(myRoot){  //��ǰ�����գ���һ�����ʵ�λ�÷���
//        BinNode  *p=myRoot,*parent=0; 
//        while(p){     
//			parent=p; //���游�ڵ�
//            if(item<p->data){ //���뵽������
//                p=p->left;
//                if(!p){  //�����ӽڵ㣬����
//                    parent->left=newnode;
//                    return;  
//				} //returnΪ����          
//			}
//            else if(item>p->data){ //���뵽���ӽڵ�
//         	    p=p->right;
//                if(!p){ //�����ӽڵ㣬����
//            	    parent->right=newnode;
//                    return;        
//				}                
//			}
//            else{
//				cout<<"�ýڵ��Ѵ���!"<<endl;  
//				return;
//			} 
//        }            
//	}
//    else myRoot=newnode;//��ǰ���գ��ȹ����Դ�Ϊ��������                                                     	
//}//Ч�� O(log2n)

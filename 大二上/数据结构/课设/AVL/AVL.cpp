#include"AVL.h"
#include<iomanip>
#include<fstream>
#include<iostream>
using namespace std;
//图形打印 
void AVL::graph(ostream& out) const{
	graph1(out,0,root);
}
void AVL::graph1(ostream& out,int indent,node p) const{
	if(p){
		graph1(out,indent+8,p->right);
		out<<setw(indent)<<" "<<p->name<<endl;
		graph1(out,indent+8,p->left);
	}
}
//获取h
int AVL::H(node& p){
	if(!p) return 0;
	else return p->h;
} 
//平衡操作 
void AVL::L(node& p){
	node l=p->right;
	p->right=l->left;
	l->left=p;
	p->h=max(H(p->left),H(p->right))+1;
    l->h=max(H(l->left),H(l->right))+1;
    p=l;
}
void AVL::R(node& p){
	node l=p->left;
	p->left=l->right;
	l->right=p;
	p->h=max(H(p->left),H(p->right))+1;
    l->h=max(H(l->left),H(l->right))+1;
	p=l;
}
void AVL::LR(node& p){
	L(p->left);
	R(p);
}
void AVL::RL(node& p){
	R(p->right);
	L(p);
}
//析构 
AVL::~AVL(){
	clean(root);	
}
void AVL::clean(node &p){
    if(p){//删除所有节点
    	clean(p->left);
    	clean(p->right);
    	delete p;	
    	p=0;
	}
}
//建立树 
void AVL::add(const string& a,const string& b){  
	add1(root,a,b);  
} 
void AVL::add1(node &p,const string& a,const string& b){ 
	if(!p) p=new Node(a,b);
    else if(a<p->name) {
		add1(p->left,a,b);	
		if(H(p->left)-H(p->right)==2){
			if(a<p->left->name) R(p);
			else LR(p);
		}
	} 
    else{add1(p->right,a,b);	
		if(H(p->left)-H(p->right)==-2){
			if(a>p->right->name) L(p);
			else RL(p);
		}	
	} 
    p->h=max(H(p->left),H(p->right))+1;
}
//插入
void AVL::insert(const string& a,const string& b){
	insert1(root,a,b);  
} 
void AVL::insert1(node &p,const string& a,const string& b){    
	if(!p) {p=new Node(a,b); cout<<"注册成功!"<<endl;}
    else if(a<p->name) {
		insert1(p->left,a,b);	
		if(H(p->left)-H(p->right)==2){
			if(a<p->left->name) R(p);
			else LR(p);
		}
	} 
    else if(a>p->name) {
		insert1(p->right,a,b);	
		if(H(p->left)-H(p->right)==-2){
			if(a>p->right->name) L(p);
			else RL(p);
		}
	} 
    else cout<<"该用户已被注册"<<endl;
    p->h=max(H(p->left),H(p->right))+1;
}
//查找 
bool AVL::search(const string& a,const string& b){
	node p=root;
    while(p){
        if(a<p->name) p=p->left; //左子树寻找
        else if(a>p->name) p=p->right;//右子树寻找
        else {if(b==p->password) return true; break;}//找到		
    }
    return  false;
}
//删除 
void AVL::search1(const string& a,bool &found,node &p,node &parent)const{
	p=root;
	parent=0;
	found=false;
	while(!found&&p){
		if(a<p->name) {
			parent=p;
			p=p->left; //左子树寻找
		}
        else if(a>p->name) {
        	parent=p;
			p=p->right;//右子树寻找
		}
        else found=true;//找到 
	}
}
void AVL::remove(const string& a){
	bool found;
	node parent,x;//x-to_delete
	search1(a,found,x,parent);//使用辅助函数定位a及其双亲节点 
//系统中执行删除操作时已确认用户存在 
	//节点有2子 
	if(x->left&&x->right){
		//查找x的中序后继及其双亲节点 
		node xSucc=x->right;//xSucc-x的中序后继 
		parent=x;
		while(xSucc->left){
			parent=xSucc;
			xSucc=xSucc->left;
		}
		x->name=xSucc->name;
		x->password=xSucc->password;
		x=xSucc;
	}
	//节点无子或只有1子
	node subtree=x->left;
	if(!subtree) subtree=x->right;//	
	if(!parent) root=subtree;
	else if(parent->left==x) parent->left=subtree;
	else parent->right=subtree;
	delete x;
	
	if(H(parent->left)-H(parent->right)==2){
		if(parent->left->left) R(parent);
		else LR(parent);
	}
	else if(H(parent->left)-H(parent->right)==-2){
		if(parent->right->right) L(parent);
		else RL(parent);
	}
	parent->h=max(H(parent->left),H(parent->right))+1;
}
//修改密码 
void AVL::modify(const string& a,const string& a1){
	bool found;
	node parent,x;//x-to_modify
	search1(a,found,x,parent);//找到a所在节点x
	x->password=a1;	
}
//保存 
void AVL::save(ostream& fout){   
	inorder(root,fout);
}
void AVL::inorder(node p,ostream& fout){     
    if(p){
        inorder(p->left,fout);
        fout<<p->name<<"\t"<<p->password<<endl;
        inorder(p->right,fout);
    }
}
//检查输入合法性 
bool AVL::check(const string& a,const string& b){
	int i;
	if(a.length()>10||b.length()<6||b.length()>10) return false;
	for(i=0;i<a.length();i++)
		if(!isalnum(a[i])) return false;
	for(i=0;i<b.length();i++)
		if(!isalnum(b[i])) return false;	
	return true;
} 

#include<fstream>
#include<string>
#include<iostream> 
using namespace std;
class AVL{ 
public:
    AVL():root(0){}
    ~AVL();
    void add(const string&,const string&);//建立 
    void insert(const string&,const string&);//注册(插入 添加用户)
    bool search(const string&,const string&);//登录验证(查找用户) 
    void remove(const string&);//删除  
    void modify(const string&,const string&);//修改密码 
    void save(ostream&);//存入文件      
 	bool check(const string&,const string&);//检查用户名和密码的合法性
 	void graph(ostream& out) const;//图形打印
private:
	class Node{
	public:
	string name;
    string password;
    Node*  left; //左子树指针 
    Node* right; //右子树指针 
    int h;//以该节点为根节点的树总深度
//当节点左右子的树深度差>1时,就会对它进行平衡化旋转操作
    Node():h(0),left(0),right(0){}
    Node(string n,string p):name(n),password(p),h(0),left(0),right(0){}
	}; 
    typedef Node *node;
	
	node root;//树根指针
//其他私有成员函数(辅助)
    int H(node&);//获取平衡因子 
    void L(node&);//左旋操作
 	void R(node&);//右旋操作
 	void LR(node&);//左右旋转 
 	void RL(node&);//右左旋转 
	int max(int a,int b){return (a>b)?a:b;} 
    void clean(node &);//辅助析构   
	void add1(node&,const string&,const string&);//辅助建立  
	void insert1(node&,const string&,const string&);//辅助插入
	void search1(const string&,bool&,node&,node&)const;//辅助删除
    void inorder(node,ostream&); //辅助保存(中序遍历输出到文件)  
	void graph1(ostream& out,int indent,node root) const;//辅助打印    	       
}; 

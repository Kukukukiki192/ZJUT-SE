#include<fstream>
#include<string>
#include<iostream> 
using namespace std;
class AVL{ 
public:
    AVL():root(0){}
    ~AVL();
    void add(const string&,const string&);//���� 
    void insert(const string&,const string&);//ע��(���� ����û�)
    bool search(const string&,const string&);//��¼��֤(�����û�) 
    void remove(const string&);//ɾ��  
    void modify(const string&,const string&);//�޸����� 
    void save(ostream&);//�����ļ�      
 	bool check(const string&,const string&);//����û���������ĺϷ���
 	void graph(ostream& out) const;//ͼ�δ�ӡ
private:
	class Node{
	public:
	string name;
    string password;
    Node*  left; //������ָ�� 
    Node* right; //������ָ�� 
    int h;//�Ըýڵ�Ϊ���ڵ���������
//���ڵ������ӵ�����Ȳ�>1ʱ,�ͻ��������ƽ�⻯��ת����
    Node():h(0),left(0),right(0){}
    Node(string n,string p):name(n),password(p),h(0),left(0),right(0){}
	}; 
    typedef Node *node;
	
	node root;//����ָ��
//����˽�г�Ա����(����)
    int H(node&);//��ȡƽ������ 
    void L(node&);//��������
 	void R(node&);//��������
 	void LR(node&);//������ת 
 	void RL(node&);//������ת 
	int max(int a,int b){return (a>b)?a:b;} 
    void clean(node &);//��������   
	void add1(node&,const string&,const string&);//��������  
	void insert1(node&,const string&,const string&);//��������
	void search1(const string&,bool&,node&,node&)const;//����ɾ��
    void inorder(node,ostream&); //��������(�������������ļ�)  
	void graph1(ostream& out,int indent,node root) const;//������ӡ    	       
}; 

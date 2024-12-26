//Huffman
#include<iostream>
using namespace std;
#define MAXBIT    10
#define MAXVALUE  100
class Node{/* 结点结构体 */
public:
	double w;//weight
    int p;//parent
    int l;//lchild
    int r;//rchild
    char v;//value
};      
class Code{/* 编码结构体 */
public:
	int code[MAXBIT];
    int start;	
};
/* 构造哈夫曼树 */
void HuffmanTree (Node Node[],int n){
    /* w1、w2：构造哈夫曼树不同过程中两个最小权值结点的权值
       i1、i2：构造哈夫曼树不同过程中两个最小权值结点在数组中的序号*/
    int i, j, i1, i2;
    double w1,w2;
    /* 初始化存Node[]中的结点 */
    for (i=0; i<2*n-1;i++){
        Node[i].w=0;
        Node[i].p=-1;
        Node[i].l=-1;
        Node[i].r=-1;
    }   
	
	cout<<"依次输入n个叶子结点的字符和权值(以空格隔开)："<<endl;
    for (i=0; i<n; i++){
        cout<<"结点"<<i+1<<": ";
        cin>>Node[i].v>>Node[i].w;
    }
    cout<<"两个最小权值结点的权值(测试)："<<endl;
    /* 构造 Huffman 树 */
    for (i=0; i<n-1; i++){//执行n-1次合并
        w1=w2=MAXVALUE;
        /* w1、w2中存放两个无父结点且结点权值最小的两个结点 */
        i1=i2=0;
        /* 找出所有结点中权值最小、无父结点的两个结点,合并之为一棵二叉树 */
        for (j=0;j<n+i;j++){
            if (Node[j].w<w1&&Node[j].p==-1){
                w2=w1;
                i2=i1;
                w1=Node[j].w;
                i1=j;
            }
            else if(Node[j].w<w2&&Node[j].p==-1){
                w2=Node[j].w;
                i2=j;
            }
        }
        /* 设置找到的两个子结点 i1、i2的父结点信息 */
        Node[i1].p=n+i;
        Node[i2].p=n+i;
        Node[n+i].w=w1+w2;
        Node[n+i].l=i1;
        Node[n+i].r=i2;
        cout<<"round"<<i+1<<"\t"<<Node[i1].w<<"\t"<<Node[i2].w<<endl; /* 用于测试 */
    }
}
/* 哈夫曼树编码 */Code cd;//为什么这个放函数里面就会编译错误 放外面反而对？？ 
void HuffmanCode(Code Code[],Node Node[],int n){
    //Code cd;/* 定义一个临时变量来存放求解编码时的信息 */
    int i,j,c,p;
    for(i=0;i<n;i++){
        cd.start=n-1;
        c=i;
        p=Node[c].p;
        while(p!=-1){
            if(c==Node[p].l) cd.code[cd.start]=0;
            else cd.code[cd.start]=1;
            cd.start--;        /*前移一位 */
            c=p;
            p=Node[c].p;    /* 设置下一循环条件 */
        }
        /* 把叶子结点的编码信息从临时编码cd中复制出来，放入编码结构体数组 */
        for (j=cd.start+1; j<n; j++) Code[i].code[j]=cd.code[j];
        Code[i].start=cd.start;
    }
}
int main(){	
    int i,j,k,n;
    cout<<"输入结点数量n:";
    cin>>n;
	Node Node[2*n-1]; 
	Code Code[n];
    HuffmanTree(Node,n);//构造哈夫曼树
    HuffmanCode(Code,Node,n);//编码  
    cout<<"译码后："<<endl;
    for(i=0;i<n;i++){//译码 
        cout<<Node[i].v<<"\t";
        for(j=Code[i].start+1;j<n;j++) cout<<Code[i].code[j];
        cout<<endl;
    }
    return 0;
}
/*
#include<algorithm>
#include<cstring>
cout<<"输入测试数据：";
    string s;
	getline(cin,s);
	cout<<s<<endl;
    char c,cc[MAXVALUE];
	i=0; j=0;
    while((c=s[i])!='\n'){
    	if(c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9'){
    		cc[j]=c; j++;
		}i++;
	}
	cout<<"Haffman编码："<<endl;
	for(i=0;i<strlen(cc);i++){
		for(j=0;j<n;j++){
			if(cc[i]==Node[i].v){
				for(k=Code[i].start+1;k<n;k++) cout<<Code[j].code[k];
			}cout<<"\t";
		}		
	}
*/

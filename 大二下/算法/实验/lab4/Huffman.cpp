//Huffman
#include<iostream>
using namespace std;
#define MAXBIT    10
#define MAXVALUE  100
class Node{/* ���ṹ�� */
public:
	double w;//weight
    int p;//parent
    int l;//lchild
    int r;//rchild
    char v;//value
};      
class Code{/* ����ṹ�� */
public:
	int code[MAXBIT];
    int start;	
};
/* ����������� */
void HuffmanTree (Node Node[],int n){
    /* w1��w2���������������ͬ������������СȨֵ����Ȩֵ
       i1��i2���������������ͬ������������СȨֵ����������е����*/
    int i, j, i1, i2;
    double w1,w2;
    /* ��ʼ����Node[]�еĽ�� */
    for (i=0; i<2*n-1;i++){
        Node[i].w=0;
        Node[i].p=-1;
        Node[i].l=-1;
        Node[i].r=-1;
    }   
	
	cout<<"��������n��Ҷ�ӽ����ַ���Ȩֵ(�Կո����)��"<<endl;
    for (i=0; i<n; i++){
        cout<<"���"<<i+1<<": ";
        cin>>Node[i].v>>Node[i].w;
    }
    cout<<"������СȨֵ����Ȩֵ(����)��"<<endl;
    /* ���� Huffman �� */
    for (i=0; i<n-1; i++){//ִ��n-1�κϲ�
        w1=w2=MAXVALUE;
        /* w1��w2�д�������޸�����ҽ��Ȩֵ��С��������� */
        i1=i2=0;
        /* �ҳ����н����Ȩֵ��С���޸������������,�ϲ�֮Ϊһ�ö����� */
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
        /* �����ҵ��������ӽ�� i1��i2�ĸ������Ϣ */
        Node[i1].p=n+i;
        Node[i2].p=n+i;
        Node[n+i].w=w1+w2;
        Node[n+i].l=i1;
        Node[n+i].r=i2;
        cout<<"round"<<i+1<<"\t"<<Node[i1].w<<"\t"<<Node[i2].w<<endl; /* ���ڲ��� */
    }
}
/* ������������ */Code cd;//Ϊʲô����ź�������ͻ������� �����淴���ԣ��� 
void HuffmanCode(Code Code[],Node Node[],int n){
    //Code cd;/* ����һ����ʱ���������������ʱ����Ϣ */
    int i,j,c,p;
    for(i=0;i<n;i++){
        cd.start=n-1;
        c=i;
        p=Node[c].p;
        while(p!=-1){
            if(c==Node[p].l) cd.code[cd.start]=0;
            else cd.code[cd.start]=1;
            cd.start--;        /*ǰ��һλ */
            c=p;
            p=Node[c].p;    /* ������һѭ������ */
        }
        /* ��Ҷ�ӽ��ı�����Ϣ����ʱ����cd�и��Ƴ������������ṹ������ */
        for (j=cd.start+1; j<n; j++) Code[i].code[j]=cd.code[j];
        Code[i].start=cd.start;
    }
}
int main(){	
    int i,j,k,n;
    cout<<"����������n:";
    cin>>n;
	Node Node[2*n-1]; 
	Code Code[n];
    HuffmanTree(Node,n);//�����������
    HuffmanCode(Code,Node,n);//����  
    cout<<"�����"<<endl;
    for(i=0;i<n;i++){//���� 
        cout<<Node[i].v<<"\t";
        for(j=Code[i].start+1;j<n;j++) cout<<Code[i].code[j];
        cout<<endl;
    }
    return 0;
}
/*
#include<algorithm>
#include<cstring>
cout<<"����������ݣ�";
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
	cout<<"Haffman���룺"<<endl;
	for(i=0;i<strlen(cc);i++){
		for(j=0;j<n;j++){
			if(cc[i]==Node[i].v){
				for(k=Code[i].start+1;k<n;k++) cout<<Code[j].code[k];
			}cout<<"\t";
		}		
	}
*/

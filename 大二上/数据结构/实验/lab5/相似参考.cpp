#include<iostream>
using namespace std;

//Լ��ϡ�����ʽ������������
template<class T>class Polynomial;
template<class T>ostream& operator<<(ostream& out, Polynomial<T>&a);

template<class T>
class Polynomial
{
private:
    class Term
    {
    public:
        T xishu;
        int mi;
    };
    class Node
    {
    public:
        Term data;
        Node* next;
        Node(T x = 0, unsigned y = 0, Node* p = 0)
        {
            data.xishu = x;
            data.mi = y;
            next = p;//�޸�
        }
    };
public:
    Polynomial();
    void myfree();//�ͷ��������и��ڵ�
    Polynomial<T>& operator=(const Polynomial<T>&);
    Polynomial<T> operator+(const Polynomial<T>&);
    Polynomial<T> operator*(const Polynomial<T>&);
    void initial();
    friend ostream& operator<< <T> (ostream& out, Polynomial<T>& a);

private:
    int highestdigit;
    Node* first;
    int num;//�����ж϶���ʽ�м���,������ڵ���,�ڳ˷�������ҲҪ�õ�
};
template<class T>
Polynomial<T>::Polynomial()
{
    first = new Node;
    num = 0;
    highestdigit = 0;
}

template<class T>
void Polynomial<T>::myfree()    //�ͷ��������нڵ�
{
    Node* p = first, *q;
    while (p)
    {
        q = p->next;
        delete p;
        p = q;
    }
    first=NULL;//�޸�
    num = 0; highestdigit = 0;//�޸�
}

template<class T>
Polynomial<T>& Polynomial<T>::operator=(const Polynomial<T>& second)
{
    myfree();
    highestdigit = second.highestdigit;
    num = second.num;
    first = second.first;

    return *this;
}

template<class T>
Polynomial<T> Polynomial<T>::operator+(const Polynomial<T>& second)
{
    Polynomial<T> sum;
    Node* pa = first->next, *pb = second.first->next, *pc = sum.first;
    while (pa&&pb)
    {
        if (pa->data.mi == pb->data.mi)  // ָ�����ʱ  
        {
            T x = pa->data.xishu + pb->data.xishu;
            if (x)     // ������ϵ����Ϊ0ʱ  
            {
                pc->next = new Node(x, pa->data.mi);
                pc = pc->next;
                ++sum.num;
                if(sum.highestdigit<pa->data.mi) sum.highestdigit = pa->data.mi;
            }
            pa = pa->next;
            pb = pb->next;
        }
        else if (pa->data.mi > pb->data.mi){
            pc->next = new Node(pa->data.xishu, pa->data.mi);
            if(sum.highestdigit<pa->data.mi) sum.highestdigit = pa->data.mi;
            ++sum.num;
            pc = pc->next;
            pa = pa->next;
        }
        else{
            pc->next = new Node(pb->data.xishu, pb->data.mi);
            ++sum.num;
            if(sum.highestdigit<pb->data.mi) sum.highestdigit = pb->data.mi;
            pc = pc->next;
            pb = pb->next;
        }
    }
    while (pa){
        pc->next = new Node(pa->data.xishu, pa->data.mi);
        ++sum.num;
        if(sum.highestdigit<pa->data.mi) sum.highestdigit = pa->data.mi;
        pc = pc->next;
        pa = pa->next;
    }
    while (pb){
        pc->next = new Node(pb->data.xishu, pb->data.mi);
        ++sum.num;
        if(sum.highestdigit<pb->data.mi) sum.highestdigit = pb->data.mi;
        pc = pc->next;
        pb = pb->next;
    }
    return sum;
}
template<class T>
Polynomial<T> Polynomial<T>::operator*(const Polynomial<T>& second){
    Polynomial<T> multi, temp;
    Node* pa = first->next, *pb = second.first->next, * pt;

    if (num >= second.num){ //����������Ǹ�������������ٵ��Ǹ�
        while(pb){          //pb�������ٵ��Ǹ���
            pt = temp.first;
            while (pa){     //������Ŀ�ʼ����  
                pt->next = new Node(pa->data.xishu*pb->data.xishu, pa->data.mi+pb->data.mi);//�޸�
                temp.num++;//�޸�
                if( temp.highestdigit<pt->next->data.mi ) temp.highestdigit=pt->next->data.mi;//�޸�
                pt = pt->next;
                pa = pa->next;
            }
            multi= temp+multi;
            temp.myfree();
            temp.first = new Node();
            pa = first->next;
            pb = pb->next;
        }
    }
    else{
        while(pa){
            pt = temp.first;
            while (pb){
                pt->next = new Node(pa->data.xishu*pb->data.xishu, pa->data.mi+pb->data.mi);//�޸�
                temp.num++;//�޸�
                if( temp.highestdigit<pt->next->data.mi ) temp.highestdigit=pt->next->data.mi;//�޸�
                pt = pt->next;
                pb = pb->next;
            }
            multi = temp+multi;
            temp.myfree();
            temp.first = new Node();
            pb = second.first->next;//�޸�
            pa = pa->next;
        }
    }
    return multi;
}
template<class T>
void Polynomial<T>::initial()
{
    //�ͷ���������ͷ�ڵ�
    Node* p = first->next, *q;
    while (p)
    {
        q = p->next;
        delete p;
        p = q;
    }
    first->next=NULL;//�޸�
    p = first;

    T a;
    int b;
    num = 0; highestdigit = 0;//�޸�
    while (cin >> a&&a != 0 && cin >> b){   //����a=0ʱ��������
        if (b >= highestdigit) highestdigit = b;
        ++num;
        p->next = new Node(a, b);
        p = p->next;
    }
    fflush(stdin);//�޸�
}

template<class T>
ostream& operator<<(ostream& out, Polynomial<T>& a)
{
    Polynomial<T>::Node *p = a.first->next;

    if (p == NULL) return out;//�޸�

    if (p->data.xishu == 0)cout << endl;//�޸�
    else{
        if (p->data.xishu != 1)
            out << p->data.xishu << "x^" << p->data.mi;
        else    out << "x^" << p->data.mi;
    }
    p = p->next;
    while (p)
    {
        out << '+';
        if (p->data.xishu != 1)
            out << p->data.xishu << "x^" << p->data.mi;
        else    out << "x^" << p->data.mi;
        p = p->next;
    }
    return out;
}

int main(){
    Polynomial<int> a, b, c,d;
    a.initial();
    cout << "a= " << a << endl;
    b.initial();
    cout << "b=" << b << endl;
    c = a + b;
    cout << "c=" << c << endl;
    d=a*b;
    cout<<"d="<<d<<endl;
    a.myfree();
    b.myfree();
    c.myfree();
    d.myfree();
    return 0;
} 



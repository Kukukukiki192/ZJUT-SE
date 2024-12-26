//链表实现一元多项式的+-*求导运算 
#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    float coef;   //系数
    int expn;     //指数
    struct node *next;
}PolyNode;      //多项式节点 polynomial node(是node创建的一个对象)
typedef PolyNode* Polynomial;//用Polynomial表示PolyNode结构体指针 
Polynomial createPolynomial() {  //创建多项式
    PolyNode *p, *q, *head = (PolyNode *)malloc(sizeof(PolyNode));   //头节点    ???
    head->next = NULL;
    float coef;
    int expn;
    printf("输入该多项式每一项的系数和指数，每项一行，输入0 0结束！\n");
    while (scanf("%f %d", &coef, &expn) && coef) {   // 默认，按指数递减排列
        if (head->next) {
            p = head;
            while (p->next && expn < p->next->expn)
                p = p->next;
            if (p->next) {
                if (expn == p->next->expn) { //有相同指数的直接把系数加到原多项式
                    p->next->coef += coef;
                    if (p->next->coef > -0.000001 && p->next->coef < 0.000001) { //若是相加后系数为0，则舍弃该节点
                        q = p->next;
                        p->next = q->next;
                        free(q);
                    }
                } else {
                    q = (PolyNode*)malloc(sizeof(PolyNode));
                    q->coef = coef;
                    q->expn = expn;
                    q->next = p->next;
                    p->next = q;
                }
            } else {
                p->next = (PolyNode*)malloc(sizeof(PolyNode));
                p = p->next;
                p->coef = coef;
                p->expn = expn;
                p->next = NULL;
            }
        } else {
            head->next = (PolyNode*)malloc(sizeof(PolyNode));
            head->next->coef = coef;
            head->next->expn = expn;
            head->next->next = NULL;
        }
    }
    return head;
}
Polynomial multiply(Polynomial poly, float coef, int expn) {  //多项式与指定单项式相乘，该单项式为 coefx^expn
    PolyNode *p, *q, *Poly = (PolyNode*)malloc(sizeof(PolyNode));
    p = Poly;
    q = poly->next;
    while (q) {
        p->next = (PolyNode*)malloc(sizeof(PolyNode));
        p = p->next;
        p->coef = (q->coef*coef);
        p->expn = (q->expn + expn);
        q = q->next;
    }
    p->next = NULL;
    return Poly;
}
void add(Polynomial poly1, Polynomial poly2) {  //把 poly2 加到 poly1 上
    PolyNode *p, *q, *r;
    r = poly1;
    p = poly1->next;  //指向第一个节点
    q = poly2->next;
    poly2->next = NULL;
    while (p && q) {
        if (p->expn > q->expn) {
            r->next = p;
            p = p->next;
            r = r->next;
        } else if (p->expn < q->expn) {
            r->next = q;
            q = q->next;
            r = r->next;
        } else {
            PolyNode *t;
            p->coef += q->coef;
            if (!(p->coef > -0.000001 && p->coef < 0.000001)) //系数不为0
            {
                r->next = p;
                r = r->next;
                p = p->next;
            } else {
                t = p;
                p = p->next;
                free(t);
            }
            t = q;
            q = q->next;
            free(t);
        }
    }
    if (p)
        r->next = p;
    if (q)
        r->next = q;
}
Polynomial polySubtract(Polynomial poly1, Polynomial poly2) {  //多项式减法 poly1-poly2形成一个新的多项式
    //把poly2的系数取相反数，形成一个新的多项式
    Polynomial poly = (PolyNode*)malloc(sizeof(PolyNode)); //构造头节点
    PolyNode *p, *q;
    p = poly;
    q = poly2->next;
    while (q) {
        p->next = (PolyNode*)malloc(sizeof(PolyNode));
        p = p->next;
        p->coef = -(q->coef);  //系数取反
        p->expn = q->expn;
        q = q->next;
    }
    p->next = NULL;
    add(poly, poly1);  //利用加法
    return poly;
}
Polynomial polyAdd(Polynomial poly1, Polynomial poly2) { //多项式相加 poly1+poly2形成一个新的多项式
    Polynomial poly = (PolyNode*)malloc(sizeof(PolyNode));  //和多项式的头节点
    poly->next = NULL;
    PolyNode *p, *q, *r;
    r = poly;
    p = poly1->next;
    q = poly2->next;
    while (p&&q) {
        if (p->expn > q->expn) {
            r->next = (PolyNode*)malloc(sizeof(PolyNode));
            r = r->next;
            r->coef = p->coef;
            r->expn = p->expn;
            p = p->next;
        } else if (p->expn < q->expn) {
            r->next = (PolyNode*)malloc(sizeof(PolyNode));
            r = r->next;
            r->coef = q->coef;
            r->expn = q->expn;
            q = q->next;
        } else {
            float m = p->coef + q->coef;
            if (!(m > -0.000001 && m < 0.000001)) {
                r->next = (PolyNode*)malloc(sizeof(PolyNode));
                r = r->next;
                r->coef = m;
                r->expn = p->expn;
            }
            q = q->next;
            p = p->next;
        }
    }
    while (p) {
        r->next = (PolyNode*)malloc(sizeof(PolyNode));
        r = r->next;
        r->coef = p->coef;
        r->expn = p->expn;
        p = p->next;
    }
    while (q) {
        r->next = (PolyNode*)malloc(sizeof(PolyNode));
        r = r->next;
        r->coef = q->coef;
        r->expn = q->expn;
        q = q->next;
    }
    r->next = NULL;
    return poly;
}
Polynomial polyMultiply(Polynomial poly1, Polynomial poly2) {  //多项式相乘
    Polynomial poly = (PolyNode*)malloc(sizeof(PolyNode));  //创建多项式和的头节点
    poly->next = NULL;
    PolyNode *p;
    p = poly2->next;
    while (p) {
        add(poly, multiply(poly1, p->coef, p->expn));
        p = p->next;
    }
    return poly;
}
void printPoly(Polynomial poly) {  //打印多项式
    if (poly && poly->next) {
        PolyNode *p = poly->next;  //p指向第一个节点
        while (p->next) {
            printf("%gx^%d", p->coef, p->expn);
            p = p->next;
            if (p && (p->coef > 0))
                printf("+");
        }
        if (p->expn == 0)
            printf("%g", p->coef);   //打印常数项
        else
            printf("%gx^%d", p->coef, p->expn);
        printf("\n");
    }
}
void freePoly(Polynomial poly) {  //释放内存
    if (poly && poly->next) {
        PolyNode *p, *q;
        p = poly;
        while (p) {
            q = p->next;
            free(p);
            p = q;
        }
    }
    poly = NULL;
}
int main() {
    printf("用链表实现多项式的加减法\n");
    Polynomial poly1, poly2, poly3;
    printf("创建多项式一\n");
    poly1 = createPolynomial();
    printf("多项式一：\n");
    printPoly(poly1);
    printf("创建多项式二\n");
    poly2 = createPolynomial();
    printf("多项式二：\n");
    printPoly(poly2);
    printf("两多项式相加，和为：\n");
    poly3 = polyAdd(poly1, poly2);
    printPoly(poly3);
    freePoly(poly3);
    printf("两个多项式相乘，积为：\n");
    poly3 = polyMultiply(poly1, poly2);
    printPoly(poly3);
    freePoly(poly3);
    printf("两多项式相减，差为：\n");
    poly3 = polySubtract(poly1, poly2);
    printPoly(poly3);
    freePoly(poly1);
    freePoly(poly2);
    freePoly(poly3);
    system("pause");
    return 0;
}

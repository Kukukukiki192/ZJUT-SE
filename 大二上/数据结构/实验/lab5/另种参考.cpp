//����ʵ��һԪ����ʽ��+-*������ 
#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    float coef;   //ϵ��
    int expn;     //ָ��
    struct node *next;
}PolyNode;      //����ʽ�ڵ� polynomial node(��node������һ������)
typedef PolyNode* Polynomial;//��Polynomial��ʾPolyNode�ṹ��ָ�� 
Polynomial createPolynomial() {  //��������ʽ
    PolyNode *p, *q, *head = (PolyNode *)malloc(sizeof(PolyNode));   //ͷ�ڵ�    ???
    head->next = NULL;
    float coef;
    int expn;
    printf("����ö���ʽÿһ���ϵ����ָ����ÿ��һ�У�����0 0������\n");
    while (scanf("%f %d", &coef, &expn) && coef) {   // Ĭ�ϣ���ָ���ݼ�����
        if (head->next) {
            p = head;
            while (p->next && expn < p->next->expn)
                p = p->next;
            if (p->next) {
                if (expn == p->next->expn) { //����ָͬ����ֱ�Ӱ�ϵ���ӵ�ԭ����ʽ
                    p->next->coef += coef;
                    if (p->next->coef > -0.000001 && p->next->coef < 0.000001) { //������Ӻ�ϵ��Ϊ0���������ýڵ�
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
Polynomial multiply(Polynomial poly, float coef, int expn) {  //����ʽ��ָ������ʽ��ˣ��õ���ʽΪ coefx^expn
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
void add(Polynomial poly1, Polynomial poly2) {  //�� poly2 �ӵ� poly1 ��
    PolyNode *p, *q, *r;
    r = poly1;
    p = poly1->next;  //ָ���һ���ڵ�
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
            if (!(p->coef > -0.000001 && p->coef < 0.000001)) //ϵ����Ϊ0
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
Polynomial polySubtract(Polynomial poly1, Polynomial poly2) {  //����ʽ���� poly1-poly2�γ�һ���µĶ���ʽ
    //��poly2��ϵ��ȡ�෴�����γ�һ���µĶ���ʽ
    Polynomial poly = (PolyNode*)malloc(sizeof(PolyNode)); //����ͷ�ڵ�
    PolyNode *p, *q;
    p = poly;
    q = poly2->next;
    while (q) {
        p->next = (PolyNode*)malloc(sizeof(PolyNode));
        p = p->next;
        p->coef = -(q->coef);  //ϵ��ȡ��
        p->expn = q->expn;
        q = q->next;
    }
    p->next = NULL;
    add(poly, poly1);  //���üӷ�
    return poly;
}
Polynomial polyAdd(Polynomial poly1, Polynomial poly2) { //����ʽ��� poly1+poly2�γ�һ���µĶ���ʽ
    Polynomial poly = (PolyNode*)malloc(sizeof(PolyNode));  //�Ͷ���ʽ��ͷ�ڵ�
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
Polynomial polyMultiply(Polynomial poly1, Polynomial poly2) {  //����ʽ���
    Polynomial poly = (PolyNode*)malloc(sizeof(PolyNode));  //��������ʽ�͵�ͷ�ڵ�
    poly->next = NULL;
    PolyNode *p;
    p = poly2->next;
    while (p) {
        add(poly, multiply(poly1, p->coef, p->expn));
        p = p->next;
    }
    return poly;
}
void printPoly(Polynomial poly) {  //��ӡ����ʽ
    if (poly && poly->next) {
        PolyNode *p = poly->next;  //pָ���һ���ڵ�
        while (p->next) {
            printf("%gx^%d", p->coef, p->expn);
            p = p->next;
            if (p && (p->coef > 0))
                printf("+");
        }
        if (p->expn == 0)
            printf("%g", p->coef);   //��ӡ������
        else
            printf("%gx^%d", p->coef, p->expn);
        printf("\n");
    }
}
void freePoly(Polynomial poly) {  //�ͷ��ڴ�
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
    printf("������ʵ�ֶ���ʽ�ļӼ���\n");
    Polynomial poly1, poly2, poly3;
    printf("��������ʽһ\n");
    poly1 = createPolynomial();
    printf("����ʽһ��\n");
    printPoly(poly1);
    printf("��������ʽ��\n");
    poly2 = createPolynomial();
    printf("����ʽ����\n");
    printPoly(poly2);
    printf("������ʽ��ӣ���Ϊ��\n");
    poly3 = polyAdd(poly1, poly2);
    printPoly(poly3);
    freePoly(poly3);
    printf("��������ʽ��ˣ���Ϊ��\n");
    poly3 = polyMultiply(poly1, poly2);
    printPoly(poly3);
    freePoly(poly3);
    printf("������ʽ�������Ϊ��\n");
    poly3 = polySubtract(poly1, poly2);
    printPoly(poly3);
    freePoly(poly1);
    freePoly(poly2);
    freePoly(poly3);
    system("pause");
    return 0;
}

#ifndef ITEM_BASE
#define ITEM_BASE

class Student {
public:
 Student();//��������Ϊʲô��ȱʡ�޲ι���?
 //��ΪStudentApp.cpp���д���δ��ʼ���Ķ���
 Student(char * n);
 char  *GetName();
 void  ChangeName(char *n);
private:
 char name[20];
};
#endif
#ifndef ITEM_BASE
#define ITEM_BASE

class Student {
public:
 Student();//考虑这里为什么不缺省无参构造?
 //因为StudentApp.cpp中有创建未初始化的对象
 Student(char * n);
 char  *GetName();
 void  ChangeName(char *n);
private:
 char name[20];
};
#endif
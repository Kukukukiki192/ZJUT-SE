class Student 
{
 public:
 Student();
 //考虑这里为什么不缺省无参构造?
 //答:作为被赋值的对象,对比赋值前后的变化
 Student(char * n);
 /*Student(const Student & o);
   void operator=(const Student& o); 
   ~Student( ); 与"student2.h"作对比*/
 char  *GetName();
 void  ChangeName(char *n);
 private:
 char name[20];
};

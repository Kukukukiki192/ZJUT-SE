class Student 
{
 public:
 Student();
 //��������Ϊʲô��ȱʡ�޲ι���?
 //��:��Ϊ����ֵ�Ķ���,�Աȸ�ֵǰ��ı仯
 Student(char * n);
 /*Student(const Student & o);
   void operator=(const Student& o); 
   ~Student( ); ��"student2.h"���Ա�*/
 char  *GetName();
 void  ChangeName(char *n);
 private:
 char name[20];
};

//student1.h
class Student {
public:
 Student();//考虑这里为什么不缺省无参构造?
 Student(char * n);
 //Student(const Student & o);
 //void operator=(const Student& o); 
 //~Student( );
 char  *GetName();
 void  ChangeName(char *n);
private:
 char name[20];
};

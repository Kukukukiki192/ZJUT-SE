//student1.h
class Student {
public:
 Student();//��������Ϊʲô��ȱʡ�޲ι���?
 Student(char * n);
 //Student(const Student & o);
 //void operator=(const Student& o); 
 //~Student( );
 char  *GetName();
 void  ChangeName(char *n);
private:
 char name[20];
};

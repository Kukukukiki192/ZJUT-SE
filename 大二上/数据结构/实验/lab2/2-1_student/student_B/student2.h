#ifndef ITEM_BASE
#define ITEM_BASE
class Student {
public:
Student();
Student(char * n);
Student(const Student & o);
Student& operator=(const Student& o);
~Student( ){delete name;}
char  *GetName();
void  ChangeName(char *n);
private:
char *name;
};
#endif
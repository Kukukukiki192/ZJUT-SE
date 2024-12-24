class Student 
{	
public:
Student();
Student(char * n);
Student(const Student & o);
void operator=(const Student& o);
~Student( );
char  *GetName();
void  ChangeName(char *n);
private:
char *name;
};

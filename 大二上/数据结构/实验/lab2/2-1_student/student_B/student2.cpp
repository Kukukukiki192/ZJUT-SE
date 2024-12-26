#include "student2.h"

Student::Student(){
	name=new char[100];
   name[0]='\0';
}

Student::Student(char *n)
{name=new char[100];
	int i;
    for( i=0;n[i]!='\0';i++)
		name[i]=n[i];
	name[i]='\0';
}

Student::Student(const Student & o)
{name=new char[100];
	int i;
    for( i=0;o.name[i]!='\0';i++)
		name[i]=o.name[i];
	name[i]='\0';
}

Student& Student::operator=(const Student& o)
{
	int i;
    for( i=0;o.name[i]!='\0';i++)
		name[i]=o.name[i];
	name[i]='\0';
	return *this;
}

char* Student::GetName()
{
   return name;
}

void Student::ChangeName(char *n)
{
    int i;
    for(i=0;n[i]!='\0';i++)
		name[i]=n[i];
    name[i]='\0';
}

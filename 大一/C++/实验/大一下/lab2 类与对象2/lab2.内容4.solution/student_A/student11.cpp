#include "Student1.h"

Student::Student(){
   name[0]='\0';
}

Student::Student(char *n)
{
	int i;
        for( i=0;n[i]!='\0';i++)
		name[i]=n[i];
	name[i]='\0';
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

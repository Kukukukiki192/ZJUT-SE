#include <iostream>
#include "SupperArray_int.h"
using namespace std;
int main()
{
	int a[10]={45,36,78,81,12,7,66,35,27,9},b[10]={23,16,76,98,43,88,26,90,41,8};
	int loop;
	SupperArray aArray,bArray;
	aArray(10,0);
	bArray(10,0); 
	for(loop=0;loop<aArray.get_size();++loop)
	{	aArray[loop]=a[loop];
	    bArray[loop]=b[loop]; 
	}
	cout<<aArray;	
	aArray.sort();
	cout<<aArray;
	
	SupperArray cArray(aArray+bArray);
	cout<<cArray;

    return 0;
}


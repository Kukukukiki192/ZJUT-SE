#include <iostream>
#include "SupperArray_template.h"
using namespace std;

int main()
{
	int a[10]={45,36,78,81,12,7,66,35,27,9},b[10]={23,16,76,98,43,88,26,90,41,8};
	char ac[10]={'a','f','c','j','e','b','i','h','g','d'},bc[10]={'t','l','z','o','m','k','n','y','u','v'};
	int loop;
	SupperArray<int> aArray,bArray;
	for(loop=0;loop<aArray.get_size();++loop)
	{	aArray[loop]=a[loop];
	    bArray[loop]=b[loop]; 
	}
	cout<<aArray;	
	aArray.sort();
	cout<<aArray;
	
	SupperArray<int>  cArray(aArray+bArray);
	cout<<cArray;
    
	SupperArray<char> acArray,bcArray;
	for(loop=0;loop<aArray.get_size();++loop)
	{	acArray[loop]=ac[loop];
	    bcArray[loop]=bc[loop]; 
	}
	cout<<acArray;	
	acArray.sort();
	cout<<acArray;
	
	SupperArray<char>  ccArray(acArray+bcArray);
	cout<<ccArray;

    return 0;
}

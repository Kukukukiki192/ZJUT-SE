#include <iostream>
using namespace std;
int main()     
{	static int a[10][10];
	int i, j;
	a[0][0]=1;
	for(i=1;i<10;++i)  
	      for(j=0;j<=i;++j)    
	            a[i][j]=a[i-1][j-1]+a[i-1][j];   //Ô½½ç
	for (i=0;i<10;++i)
	     {   for(j=0;j<=i;++j)
	               cout<<a[i][j]<<" ";
	          cout<<endl;   }
	system("pause");
	return 0;         
}

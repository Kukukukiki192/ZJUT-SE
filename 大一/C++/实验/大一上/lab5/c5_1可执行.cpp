#include <iostream>
using namespace std;
int main()
{ void sort (char *p,int m);
  int i,n=3;
  char *p,num[20];
  cout<<"please enter 3 integers:";
  for (i=0;i<n;i++)
   cin>>num[i];

	cout<<"the original number is:";
for(i=0;i<n;i++)cout<<num[i]<<" ";
	cout<<endl;
  p=&num[0];
  sort(p,n);
  cout<<"the inverted number sequence is :";
  for (i=0;i<n;i++)
    cout<<num[i]<<" ";
  cout<<endl;
system("pause");
  return 0;
 } 
 void sort (char *p,int m)   
 {int i;
  char temp, *p1,*p2;
  for (i=0;i<m/2;i++)
  {p1=p+i;
   p2=p+(m-1-i);
   temp=*p1;
   *p1=*p2;
   *p2=temp;
  }
 }

#include <string>
#include <iostream>
using namespace std;
int main(){
	string str;
	cout<<"�����������ַ���:";
	cin>>str;
	int len=str.length();
	int ans=1;                            //��С����������1 
	for(int i=1;i<len;){
		while(i<len && str[i]!=str[0]){   //Ѱ����һ��str[0] 
			ans++; 
			i++;
		}
		if(i<len){                        //����str[i]==str[0]
		    int count=0,j=i,start=0;
			for(;j<len;j++,start++){      //�͵�ǰ��С��������Ƚ� 
				if(str[j]!=str[start]) break;
				count++;
				if(count==ans) break;
			}
			if(count==ans){
				if(j==len-1) break;       //��ֹ�������Խ�� 
				if(str[j+1]!=str[0]){     //���ֺ�һλ����str[0] һ��Ҫ��ʱ������С���� 
					ans=j+2;
					i=j+2;
				}
				else i=j+1;
			}
			else{                         //count��=ans 
				if(j==len){
					ans=j;
					break;
				}
				ans=j+1;
				i=j+1;
			}
		}
	}
	cout<<"�ַ�������С����:"<<ans<<endl;
	return 0;
}

#include <iostream>
#include <string>
using namespace std;
int main(){
	string s;
	cout<<"�����������ַ���:";
	cin>>s;
	int i,j,len=s.length();
	for(i=1;i<=len;i++){//ö���Ӵ��ĳ��� 
		if(len%i == 0){//����Ӵ����Ȳ��ܱ��ܳ���������ֱ���˳�
			bool is = true;
			for(j=i;j<len;j++){
				if(s[j]!=s[j%i]){
					is = false;
					break;
				}
			}if(is){
				cout<<"�ַ�������С����:"<<i<<endl;
				break;
			}
		}
	}
	return 0;
}

#include <iostream>
#include <string>
using namespace std;
int main(){
	string s;
	cout<<"输入周期性字符串:";
	cin>>s;
	int i,j,len=s.length();
	for(i=1;i<=len;i++){//枚举子串的长度 
		if(len%i == 0){//如果子串长度不能被总长度整除则直接退出
			bool is = true;
			for(j=i;j<len;j++){
				if(s[j]!=s[j%i]){
					is = false;
					break;
				}
			}if(is){
				cout<<"字符串的最小周期:"<<i<<endl;
				break;
			}
		}
	}
	return 0;
}

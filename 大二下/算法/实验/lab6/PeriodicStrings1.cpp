#include <string>
#include <iostream>
using namespace std;
int main(){
	string str;
	cout<<"输入周期性字符串:";
	cin>>str;
	int len=str.length();
	int ans=1;                            //最小周期至少是1 
	for(int i=1;i<len;){
		while(i<len && str[i]!=str[0]){   //寻找下一个str[0] 
			ans++; 
			i++;
		}
		if(i<len){                        //必有str[i]==str[0]
		    int count=0,j=i,start=0;
			for(;j<len;j++,start++){      //和当前最小周期逐个比较 
				if(str[j]!=str[start]) break;
				count++;
				if(count==ans) break;
			}
			if(count==ans){
				if(j==len-1) break;       //防止数组访问越界 
				if(str[j+1]!=str[0]){     //发现后一位不是str[0] 一定要及时更新最小周期 
					ans=j+2;
					i=j+2;
				}
				else i=j+1;
			}
			else{                         //count！=ans 
				if(j==len){
					ans=j;
					break;
				}
				ans=j+1;
				i=j+1;
			}
		}
	}
	cout<<"字符串的最小周期:"<<ans<<endl;
	return 0;
}

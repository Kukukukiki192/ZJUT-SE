#include <iostream>
#include<cstring>
using namespace std;
const int N=1002;
int c[N][N],b[N][N];
char s1[N],s2[N];
int len1,len2;

void LCSL()
{
    int i,j;
    for(i = 1;i <= len1;i++)//控制s1序列不同的子问题
      for(j = 1;j <= len2;j++)//控制s2序列不同的子问题
      {
        if(s1[i-1]==s2[j-1])
        {
            c[i][j] = c[i-1][j-1]+1;//如果当前字符相同，则公共子序列的长度为该字符前的最长公共序列+1
            b[i][j] = 1;
        }
        else
        {
             if(c[i][j-1]>=c[i-1][j])
            {
                c[i][j] = c[i][j-1];
                b[i][j] = 2;
            }
            else
            {
                c[i][j] = c[i-1][j];
                b[i][j] = 3;
            }
        }
     }
}

void print(int i, int j)//根据记录下来的信息构造最长公共子序列（从b[i][j]开始递推）
{
    if(i==0 || j==0) return;
    if(b[i][j]==1){
        print(i-1,j-1);
        cout<<s1[i-1];
    }
    else if(b[i][j]==2)
            print(i,j-1);
         else
            print(i-1,j);
}

int main(){
    int i,j;
    cout << "输入字符串s1:"<<endl;
	gets(s1);;//整行读入字符数组
    cout << "输入字符串s2:"<<endl;
	gets(s2);
    len1 = strlen(s1);//计算两个字符串的长度
    len2 = strlen(s2);
    for(i = 0;i <= len1;i++)
    {
        c[i][0]=0;//初始化第一列为0
    }
    for(j = 0;j<= len2;j++)
    {
        c[0][j]=0;//初始化第一行为0
    }
    LCSL();
    cout << "s1和s2的最长公共子序列长度是:"<<c[len1][len2]<<endl;
    cout << "s1和s2的最长公共子序列是:";
    print(len1,len2);
    cout<<endl;
    //用于测试
    cout<<"c[i][j]数组："<<endl;
    for(i = 0;i <= len1;i++)
    {
        for(j = 0;j <= len2;j++)
          cout <<"  "<<c[i][j];
        cout<<endl;
    }
    cout<<"b[i][j]数组："<<endl;
    for(i = 0;i <= len1;i++)
    {
        for(j = 0;j <= len2;j++)
          cout <<"  "<<b[i][j];
        cout<<endl;
    }
    return 0;
}

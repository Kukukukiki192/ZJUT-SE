#include<iostream>
#include<fstream>
#include<cstring>
#include<cstdio>
#include<algorithm>
#include<stack>
using namespace std;

///表格数组                a       b        c       d       #      E      A       B
char LR0[50][50][100] = {{"S2"   ,"S3"   ,"null", "null" ,"null" ,"1"    ,"null" ,"null"},///   0
                         {"null" ,"null" ,"null", "null" ,"acc " ,"null" ,"null" ,"null"},///   1
                         {"null" ,"null" ,"S4"  , "S10"  ,"null" ,"null" ,"6"    ,"null"},///   2
                         {"null" ,"null" ,"S5"  , "S11"  ,"null" ,"null" ,"null" ,"7"   },///   3
                         {"null" ,"null" ,"S4"  , "S10"  ,"null" ,"null" ,"8"    ,"null"},///   4
                         {"null" ,"null" ,"S5"  , "S11"  ,"null" ,"null" ,"null" ,"9"   },///   5
                         {"r1"   ,"r1"   ,"r1"  , "r1"   ,"r1"   ,"null" ,"null" ,"null"},///   6
                         {"r2"   ,"r2"   ,"r2"  , "r2"   ,"r2"   ,"null" ,"null" ,"null"},///   7
                         {"r3"   ,"r3"   ,"r3"  , "r3"   ,"r3"   ,"null" ,"null" ,"null"},///   8
                         {"r5"   ,"r5"   ,"r5"  , "r5"   ,"r5"   ,"null" ,"null" ,"null"},///   9
                         {"r4"   ,"r4"   ,"r4"  , "r4"   ,"r4"   ,"null" ,"null" ,"null"},///   10
                         {"r6"   ,"r6"   ,"r6"  , "r6"   ,"r6"   ,"null" ,"null" ,"null"},///   11
                          };
char L[200]="abcd#EAB";    ///列判断依据
int  del[10]={0,2,2,2,1,2,1};//0-6号文法每个文法长度
char head[20]={'S','E','E','A','A','B','B'};
stack<int>con;    ///状态栈
stack<char>cmp;   ///符号栈
char cod[300]="0";///初始状态栈对应输出数组
int cindex = 0;
char sti[300]="#";///初始符号栈对应输出数组
int sindex = 0;
int findL(char b)///对应列寻找
{
    for(int i = 0; i <= 7; i++)
    {
        if(b==L[i])
        {
            return i;
        }
    }
    return -1;
}
void error(int x, int y)       ///报错输出
{
    printf("第%d行%c列为空!",x,L[y]);
}
 
int calculate(int l, char s[])
{
    int num = 0;
    for(int i = 1; i < l; i ++)
    {
        num =  num*10+(s[i]-'0');
    }
    return num;
}
void analyze(char str[],int len)///分析主体过程
{
    int cnt = 1;
    printf("步骤      状态栈    符号栈    输入串    ACTION    GOTO\n");
    int LR = 0;
    while(LR<=len)
    {
        printf("(%d)       %-10s%-10s",cnt,cod,sti);///步骤，状态栈，符号栈输出
        cnt++;
        for(int i = LR; i < len; i++)///输入串输出
        {
            printf("%c",str[i]);
        }
        for(int i = len-LR; i<10;i++)printf(" ");
 
        int x = con.top();///状态栈栈顶
        int y = findL(str[LR]);///待判断串串首
 
        if(strcmp(LR0[x][y],"null")!=0)
        {
            int l = strlen(LR0[x][y]);///当前Ri或Si的长度
 
            if(LR0[x][y][0]=='a')///acc
            {
                printf("acc        \n");///ACTION与GOTO
                return ;
            }
            else if(LR0[x][y][0]=='S')///Si
            {
                printf("%-10s \n",LR0[x][y]);///ACTION与GOTO
                int t = calculate(l,LR0[x][y]);///整数
                con.push(t);
                sindex++;
                sti[sindex] = str[LR];
                cmp.push(str[LR]);
                if(t<10)
                {
                    cindex++;
                    cod[cindex] = LR0[x][y][1];
                }
                else
                {
                    int k = 1;
                    cindex++;
                    cod[cindex] = '(';
                    while(k<l)
                    {
                        cindex++;
                        cod[cindex] = LR0[x][y][k];
                        k++;
                    }
                    cindex++;
                    cod[cindex] = ')';
                }
                LR++;
            }
            else if(LR0[x][y][0]=='r')///ri,退栈，ACTION和GOTO
            {
                printf("%-10s",LR0[x][y]);
                int t = calculate(l,LR0[x][y]);
                int g = del[t];
                while(g--)
                {
                    con.pop();
                    cmp.pop();
                    sti[sindex] = '\0';
                    sindex--;
                }
                g = del[t];
                while(g>0)
                {
                    if(cod[cindex]==')')
                    {
                        cod[cindex]='\0';
                        cindex--;
                        for(;;)
                        {
                            if(cod[cindex]=='(')
                            {
                                cod[cindex]='\0';
                                cindex--;
                                break;
                            }else
                            {
                                cod[cindex]='\0';
                                cindex--;
                            }
                        }
                        g--;
                    }else
                    {
                        cod[cindex] = '\0';
                        cindex--;
                        g--;
                    }
                }///
                cmp.push(head[t]);
                sindex++;
                sti[sindex] = head[t];
                x = con.top();
                y = findL(cmp.top());
                t = LR0[x][y][0]-'0';
                con.push(t);
                cindex++;
                cod[cindex] = LR0[x][y][0];
                printf("%-10d\n",t);
            }else
            {
                int t = LR0[x][y][0]-'0';
                char ch = ' ';
                printf("%-10c%-10d\n",ch,t);
                con.push(t);
                cindex++;
                cod[cindex] = LR0[x][y][0];
                sindex++;
                sti[sindex] = 'E';
                LR++;
            }
        }else
        {
            error(x,y);
            return ;
            ///报错
        }
    }
 
}
void chart()///测试表函数
{
    printf("-\ta\tb\tc\td\t#\tE\tA\tB\n");
    ofstream out("output.txt");
    out<<"-\ta\tb\tc\td\t#\tE\tA\tB\n";
    for(int i = 0; i <= 11; i++)
    {
        printf("%d",i);
        out<<i;
        for(int j = 0 ; j <= 8; j++)
		{
			printf("\t%s",LR0[i][j]);
            out<<"\t"<<LR0[i][j]; }
            cout<<endl;
            out<<endl;
    }
    cout<<endl;
    out<<endl;
    out.close();
}
int main()
{	
    chart();
    con.push(0);
    cmp.push('#');
    char str[200];///输入串
    cout<<"请输入字符串（带#）："<<endl;
    cin>>str;
    int len = strlen(str);
    analyze(str,len);
    
    return 0;
}

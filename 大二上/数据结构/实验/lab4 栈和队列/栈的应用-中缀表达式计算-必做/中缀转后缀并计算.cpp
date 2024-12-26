#include<iostream>
#include<stack>
#include<string>
#include<sstream>
#include<iomanip>
using namespace std;

//获取优先级
int getPriority(char c)  {  
    if(c == '#') return 1;
    else if (c == '(') return 2;  
    else if (c == '+' || c == '-') return 3;  
    else if (c == '*' || c == '/' ) return 4;  
    else return 5;  // )
}  
 
//中缀转后缀 
string MidToBack(string str) {
	string t= "";   //后缀表达式 
	stack <char> s;   //运算符栈
	s.push('#');
 
	for (int i = 0; i < str.length(); i++) {
		switch (str[i]) {//str[i]:中缀表达式中的字符
		case ' ':break;
		case '(':s.push('('); break;
		case ')':
			while (!s.empty() && s.top() != '(') {
				t= t+ s.top();  //添加进入后缀表达式
				s.pop(); //出栈
			}
			s.pop();  //将(出栈
			break;
		default:
			if (isalpha(str[i])) {  //如果是字母
				t= t+ str[i];
			}
			else if(str[i]>='0'&&str[i]<='9'||str[i]=='.'){//如果是数字或小数点 			
				while(str[i]>='0'&&str[i]<='9'||str[i]=='.'){
					t= t+ str[i++];
				}   i--; t= t+' ';//!!!别忘了i--,不然会跳过一个字符 数字后加空格 
			}
			else {//运算符 
				if ((s.top() == '(') ||(s.top()!='(' && 
					getPriority(str[i])>getPriority(s.top()))) { //当栈顶字符为'('时
					//或者优先级大于栈顶的字符优先级
					s.push(str[i]); //进栈
				}
				else {
					while (getPriority(str[i])<=getPriority(s.top())) {
						//如果该字符优先级小于栈顶字符优先级
						t= t+s.top(); //添加进入后缀表达式
						s.pop();  //出栈
					}
					s.push(str[i]);//进栈
				}
			}
			break;
		}
	}
	while (!s.empty()&&s.top()!='#') {  
		t= t+ s.top();//将剩下的依次添加到后缀表达式
		s.pop();//弹出栈中剩余运算符 
	}
	return t;
}
double cal(double a, char c, double b){
	if(c == '+') return a + b;
	if(c == '-') return a - b;
	if(c == '*') return a * b;
	return a / b;
}

//计算后缀表达式 
double calBack(string str){
	int i=0;
	stack<double> n;
	while(i< str.length()){
		if(str[i]>='0'&&str[i]<='9')//小数 
        {
            double x=0;
            int y=0;//计算小数位数 
            while(str[i]>='0'&&str[i]<='9')
            {
                x=x*10+(str[i]-'0');
                i++;
            }
            if(str[i]=='.')
            {
                i++;
                while(str[i]>='0'&&str[i]<='9')
                {
                    x=x*10+(str[i]-'0');
                    i++;
                    y++;
                }
            }
            while(y)
            {
                x/=10;
                y--;
            }
            n.push(x);
        }
		else if(str[i]>='a'&&str[i]<='z'){//字母 
            cout<<"给"<<str[i]<<"赋值:"<<endl;
            double x;
            cin>>x;
            n.push(x);
        }
		else if(str[i]==' '){}//空格 
		else{                 //运算符 
			double n1 = n.top();
			n.pop();
			double n2 = n.top();
			n.pop();
			n.push(cal(n2,str[i],n1));
		}
		i++;
	}
 	return n.top();//结果 
}
 
int main() {
	string str;
	getline(cin,str);		
	cout << "中缀表达式转后缀表达式:"<<MidToBack(str) << endl;
	cout << "计算结果:"<<calBack(MidToBack(str))<<endl;
	
	system("pause");
	return 0; 
}

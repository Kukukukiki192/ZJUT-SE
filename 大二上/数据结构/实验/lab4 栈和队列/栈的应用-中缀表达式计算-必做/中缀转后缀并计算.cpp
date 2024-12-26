#include<iostream>
#include<stack>
#include<string>
#include<sstream>
#include<iomanip>
using namespace std;

//��ȡ���ȼ�
int getPriority(char c)  {  
    if(c == '#') return 1;
    else if (c == '(') return 2;  
    else if (c == '+' || c == '-') return 3;  
    else if (c == '*' || c == '/' ) return 4;  
    else return 5;  // )
}  
 
//��׺ת��׺ 
string MidToBack(string str) {
	string t= "";   //��׺���ʽ 
	stack <char> s;   //�����ջ
	s.push('#');
 
	for (int i = 0; i < str.length(); i++) {
		switch (str[i]) {//str[i]:��׺���ʽ�е��ַ�
		case ' ':break;
		case '(':s.push('('); break;
		case ')':
			while (!s.empty() && s.top() != '(') {
				t= t+ s.top();  //��ӽ����׺���ʽ
				s.pop(); //��ջ
			}
			s.pop();  //��(��ջ
			break;
		default:
			if (isalpha(str[i])) {  //�������ĸ
				t= t+ str[i];
			}
			else if(str[i]>='0'&&str[i]<='9'||str[i]=='.'){//��������ֻ�С���� 			
				while(str[i]>='0'&&str[i]<='9'||str[i]=='.'){
					t= t+ str[i++];
				}   i--; t= t+' ';//!!!������i--,��Ȼ������һ���ַ� ���ֺ�ӿո� 
			}
			else {//����� 
				if ((s.top() == '(') ||(s.top()!='(' && 
					getPriority(str[i])>getPriority(s.top()))) { //��ջ���ַ�Ϊ'('ʱ
					//�������ȼ�����ջ�����ַ����ȼ�
					s.push(str[i]); //��ջ
				}
				else {
					while (getPriority(str[i])<=getPriority(s.top())) {
						//������ַ����ȼ�С��ջ���ַ����ȼ�
						t= t+s.top(); //��ӽ����׺���ʽ
						s.pop();  //��ջ
					}
					s.push(str[i]);//��ջ
				}
			}
			break;
		}
	}
	while (!s.empty()&&s.top()!='#') {  
		t= t+ s.top();//��ʣ�µ�������ӵ���׺���ʽ
		s.pop();//����ջ��ʣ������� 
	}
	return t;
}
double cal(double a, char c, double b){
	if(c == '+') return a + b;
	if(c == '-') return a - b;
	if(c == '*') return a * b;
	return a / b;
}

//�����׺���ʽ 
double calBack(string str){
	int i=0;
	stack<double> n;
	while(i< str.length()){
		if(str[i]>='0'&&str[i]<='9')//С�� 
        {
            double x=0;
            int y=0;//����С��λ�� 
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
		else if(str[i]>='a'&&str[i]<='z'){//��ĸ 
            cout<<"��"<<str[i]<<"��ֵ:"<<endl;
            double x;
            cin>>x;
            n.push(x);
        }
		else if(str[i]==' '){}//�ո� 
		else{                 //����� 
			double n1 = n.top();
			n.pop();
			double n2 = n.top();
			n.pop();
			n.push(cal(n2,str[i],n1));
		}
		i++;
	}
 	return n.top();//��� 
}
 
int main() {
	string str;
	getline(cin,str);		
	cout << "��׺���ʽת��׺���ʽ:"<<MidToBack(str) << endl;
	cout << "������:"<<calBack(MidToBack(str))<<endl;
	
	system("pause");
	return 0; 
}

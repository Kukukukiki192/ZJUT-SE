#include <windows.h>
#include <iostream>
using namespace std;
HANDLE m_hPro;

void startProcess(){//��������
	STARTUPINFO si;//�ر��Ĳ�������
	int n=1;
 	memset(&si,0,sizeof(STARTUPINFO));
 	si.cb=sizeof(STARTUPINFO);
	si.dwFlags=STARTF_USESHOWWINDOW;
	si.wShowWindow=SW_SHOW;
	PROCESS_INFORMATION pi;
	//����QQ���ֽ��� 
	if(!CreateProcess(NULL,"C://Program Files (x86)//Tencent//QQMusic//QQMusic.exe",NULL,NULL,false,0,NULL,NULL,&si,&pi)){ 
		cout <<"��������ʧ��!" <<endl;
		exit(1);
	}else{
		cout <<"�������̳ɹ�!" <<endl; 
		m_hPro=pi.hProcess;
	}cout<<endl;
}

void stopProcess(){
	if(m_hPro){
		if(!TerminateProcess(m_hPro,0)){//��ֹ���ִ�����ʾ������Ϣ
			LPVOID lpMsgBuf;
			FormatMessage(FORMAT_MESSAGE_ALLOCATE_BUFFER |FORMAT_MESSAGE_FROM_SYSTEM |FORMAT_MESSAGE_IGNORE_INSERTS,
				NULL,GetLastError(),MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),(LPTSTR) &lpMsgBuf, 0,NULL );
		}else cout<<"��ֹ���̳ɹ�!"<<endl;	
		m_hPro=NULL;
	}else cout<<"��ǰ�޽���"<<endl;
	cout<<endl;
}

int main(){
	cout<<"���̵Ĵ�������ֹ"<<endl;
	cout<<"--------------------------------"<<endl;
	cout<<"1 ��������  2 ��ֹ����  3 �˳�"<<endl;
	cout<<"--------------------------------"<<endl;
	cout<<"���������ѡ�����:"<<endl;
	while(1){		
		int i;
		cin>>i;
		switch(i){
			case 1:startProcess();break;
			case 2:stopProcess();break;
			case 3:exit(1);
		}
	}
	return(0);
}

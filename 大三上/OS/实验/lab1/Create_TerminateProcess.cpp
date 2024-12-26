#include <windows.h>
#include <iostream>
using namespace std;
HANDLE m_hPro;

void startProcess(){//创建进程
	STARTUPINFO si;//必备的参数设置
	int n=1;
 	memset(&si,0,sizeof(STARTUPINFO));
 	si.cb=sizeof(STARTUPINFO);
	si.dwFlags=STARTF_USESHOWWINDOW;
	si.wShowWindow=SW_SHOW;
	PROCESS_INFORMATION pi;
	//启动QQ音乐进程 
	if(!CreateProcess(NULL,"C://Program Files (x86)//Tencent//QQMusic//QQMusic.exe",NULL,NULL,false,0,NULL,NULL,&si,&pi)){ 
		cout <<"创建进程失败!" <<endl;
		exit(1);
	}else{
		cout <<"创建进程成功!" <<endl; 
		m_hPro=pi.hProcess;
	}cout<<endl;
}

void stopProcess(){
	if(m_hPro){
		if(!TerminateProcess(m_hPro,0)){//终止出现错误，显示错误信息
			LPVOID lpMsgBuf;
			FormatMessage(FORMAT_MESSAGE_ALLOCATE_BUFFER |FORMAT_MESSAGE_FROM_SYSTEM |FORMAT_MESSAGE_IGNORE_INSERTS,
				NULL,GetLastError(),MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),(LPTSTR) &lpMsgBuf, 0,NULL );
		}else cout<<"终止进程成功!"<<endl;	
		m_hPro=NULL;
	}else cout<<"当前无进程"<<endl;
	cout<<endl;
}

int main(){
	cout<<"进程的创建与终止"<<endl;
	cout<<"--------------------------------"<<endl;
	cout<<"1 创建进程  2 终止进程  3 退出"<<endl;
	cout<<"--------------------------------"<<endl;
	cout<<"请输入序号选择操作:"<<endl;
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

#include<Windows.h>
#include<iostream>
#include<cstdlib>
#include<queue>
#include<time.h>
#define N 10//��󻺳����� 
#define GETMYRAND() (int)(((double)rand()/(double)RAND_MAX)*300)
using namespace std;
//�����ź���
HANDLE m_S_Empty;//������Semaphore
HANDLE m_S_Full;//������Semaphore
HANDLE m_M_Mutex;//����
queue<int> buffer;//���干������
int i=0,n=0;//n-��ǰ���������� 

DWORD WINAPI Producer(PVOID pParam){	 
	while(true){
		srand((int)time(0));//�������� time(0)-�õ���ǰʱ��ֵ-Ϊ��ÿ������һ����һ��������
		int t=rand()%100;//���������	
        /*����һ����Ʒ*/	
        if (WaitForSingleObject(m_S_Empty,INFINITE) == WAIT_OBJECT_0){//ȡ��� 
			if (WaitForSingleObject(m_M_Mutex,INFINITE) == WAIT_OBJECT_0){//���� 
				/*������������Ʒ�ŵ�ָ���Ļ�������*/
				i++; n++;
				if (i == 20)system("PAUSE");//��������ִ��20���Ժ�ϵͳ��ͣ,�۲�������
				buffer.push(t+i);//ÿ��i��һ�� ����� 
				cout<<"Producer->"<<t+i<<endl;//��ʾ������ÿ���򻺳�������һ������ 
				cout<<endl;
				cout<<"Buffer("<<n<<"):";//��ʾ�������м������ֲ���� 
				//���������������
				for (int j = 0; j < buffer.size(); j++) {
					int x = buffer.front();
					buffer.pop();
					cout<<x<<"\t";
					buffer.push(x);
				}cout<<endl; cout<<endl;
				
				ReleaseMutex(m_M_Mutex);//���� 
               	ReleaseSemaphore(m_S_Full, 1, NULL);//����ȡ 
            }
        }
        Sleep(GETMYRAND());
	}
}

DWORD WINAPI Consumer(PVOID pParam) {
	while(true){
        if (WaitForSingleObject(m_S_Full,INFINITE) == WAIT_OBJECT_0){//����ȡ
			if (WaitForSingleObject(m_M_Mutex,INFINITE) == WAIT_OBJECT_0){
				/*ȡ��һ����Ʒ*/
				n--;
				int t = buffer.front();
				buffer.pop();
				cout<<"Consumer<-"<<t<<endl;
				cout<<endl;
				cout<<"Buffer("<<n<<"):";
				for (int j = 0; j < buffer.size(); j++) {
					int x = buffer.front();
					buffer.pop();
					cout<<x<<"\t";
					buffer.push(x);
				}cout<<endl; cout<<endl;

				ReleaseMutex(m_M_Mutex);
           		ReleaseSemaphore(m_S_Empty, 1, NULL);//ȡ���
			}
		}
		Sleep(GETMYRAND());
	}
}

int main(){  
	//���������ߺ��������߳�
   	CreateThread(NULL,0,Producer,NULL,0,NULL);
   	Sleep(2000);
    CreateThread(NULL,0,Consumer,NULL,0,NULL);

   	m_S_Empty = CreateSemaphore(NULL, N, N, NULL);
    //��ʼ����ΪN
	m_S_Full = CreateSemaphore(NULL, 0, N, NULL);
	//��ʼ����Ϊ0
	m_M_Mutex = CreateMutex(NULL, FALSE, NULL);
	Sleep(INFINITE);//���޵ȴ� ֵΪ0xFFFFFFFF 
	return 0;
}


#include<Windows.h>
#include<iostream>
#include<cstdlib>
#include<queue>
#include<time.h>
#define N 10//最大缓冲区数 
#define GETMYRAND() (int)(((double)rand()/(double)RAND_MAX)*300)
using namespace std;
//定义信号量
HANDLE m_S_Empty;//生产者Semaphore
HANDLE m_S_Full;//消费者Semaphore
HANDLE m_M_Mutex;//互斥
queue<int> buffer;//定义共享缓冲区
int i=0,n=0;//n-当前缓冲区数量 

DWORD WINAPI Producer(PVOID pParam){	 
	while(true){
		srand((int)time(0));//设置种子 time(0)-得到当前时间值-为了每回种下一个不一样的种子
		int t=rand()%100;//产生随机数	
        /*生产一个物品*/	
        if (WaitForSingleObject(m_S_Empty,INFINITE) == WAIT_OBJECT_0){//取完存 
			if (WaitForSingleObject(m_M_Mutex,INFINITE) == WAIT_OBJECT_0){//加锁 
				/*将所生产的物品放到指定的缓冲区中*/
				i++; n++;
				if (i == 20)system("PAUSE");//当生产者执行20次以后系统暂停,观察输出情况
				buffer.push(t+i);//每次i不一样 更随机 
				cout<<"Producer->"<<t+i<<endl;//表示生产者每次向缓冲区放入一个数字 
				cout<<endl;
				cout<<"Buffer("<<n<<"):";//表示缓冲区有几个数字并输出 
				//遍历输出队列内容
				for (int j = 0; j < buffer.size(); j++) {
					int x = buffer.front();
					buffer.pop();
					cout<<x<<"\t";
					buffer.push(x);
				}cout<<endl; cout<<endl;
				
				ReleaseMutex(m_M_Mutex);//解锁 
               	ReleaseSemaphore(m_S_Full, 1, NULL);//存完取 
            }
        }
        Sleep(GETMYRAND());
	}
}

DWORD WINAPI Consumer(PVOID pParam) {
	while(true){
        if (WaitForSingleObject(m_S_Full,INFINITE) == WAIT_OBJECT_0){//存完取
			if (WaitForSingleObject(m_M_Mutex,INFINITE) == WAIT_OBJECT_0){
				/*取出一个物品*/
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
           		ReleaseSemaphore(m_S_Empty, 1, NULL);//取完存
			}
		}
		Sleep(GETMYRAND());
	}
}

int main(){  
	//创建生产者和消费者线程
   	CreateThread(NULL,0,Producer,NULL,0,NULL);
   	Sleep(2000);
    CreateThread(NULL,0,Consumer,NULL,0,NULL);

   	m_S_Empty = CreateSemaphore(NULL, N, N, NULL);
    //初始计数为N
	m_S_Full = CreateSemaphore(NULL, 0, N, NULL);
	//初始计数为0
	m_M_Mutex = CreateMutex(NULL, FALSE, NULL);
	Sleep(INFINITE);//无限等待 值为0xFFFFFFFF 
	return 0;
}


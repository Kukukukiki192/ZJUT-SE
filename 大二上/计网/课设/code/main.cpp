#define _CRT_SECURE_NO_WARNINGS //使用不安全函数
#define _WINSOCK_DEPRECATED_NO_WARNINGS//inet_addr 该函数在新的MFC中被替换，可以在vs的属性中设置预处理宏来使用该函数，防止报错
#include <iostream>
#include <winsock2.h>//socket通信，系统头文件
#include <windows.h>
#include <string.h>
#include "mstcpip.h"//网络编程需要用到的头文件
#pragma comment(lib,"Ws2_32.lib")//静态加入一个库文件
using namespace std;
//IP首部
typedef struct tIPPackHead
{
	BYTE ver_hlen;        //IP协议版本和IP首部长度。高4位为版本，低4位为首部的长度(单位为4bytes)
	BYTE byTOS;          //服务类型
	WORD wPacketLen;    //IP包总长度。包括首部，单位为byte。
	WORD wSequence;    //标识
	union
	{
		WORD Flags;     //标志
		WORD FragOf;    //分段偏移
	};
	BYTE byTTL;          //生存时间 
	BYTE byProtocolType;  //协议类型
	WORD wHeadCheckSum;    //IP首部校验和
	DWORD dwIPSrc;          //源地址
	DWORD dwIPDes;          //目的地址
	BYTE Options;             //选项
} IP_HEAD;
int cnt;
int DecodeIP(char *buf, int len)
{
	int n = len;
	if (n >= sizeof(IP_HEAD))
	{
		IP_HEAD iphead;
		iphead = *(IP_HEAD*)buf;
		cout << "第 " << cnt++ << " 个IP数据包信息：" << endl;
		cout << "协议版本:" << (iphead.ver_hlen >> 4) << endl;
		cout << "首部长度:" << ((iphead.ver_hlen & 0x0F) << 2) << endl;//单位为4字节
		cout << "服务类型:Priority: " << (iphead.byTOS >> 5) << ",Service: " << ((iphead.byTOS >> 1) & 0x0f) << endl;
		cout << "IP包总长度:" << ntohs(iphead.wPacketLen) << endl; //网络字节序转为主机字节序
		cout << "标识:" << ntohs(iphead.wSequence) << endl;
		cout << "标志位:" << "DF=" << ((iphead.Flags >> 14) & 0x01) << ",MF=" << ((iphead.Flags >> 13) & 0x01) << endl;
		cout << "片偏移:" << (iphead.FragOf & 0x1fff) << endl;
		cout << "生存周期:" << (int)iphead.byTTL << endl;
		cout << "协议类型:" << int(iphead.byProtocolType) << endl;
		cout << "首部校验和:" << ntohs(iphead.wHeadCheckSum) << endl;
		cout << "源地址:" << inet_ntoa(*(in_addr*)&iphead.dwIPSrc) << endl;
		cout << "目的地址:" << inet_ntoa(*(in_addr*)&iphead.dwIPDes) << endl;
		cout << "==============================================================" << endl << endl;
	}system("pause");
	return 0;
}
//在一个多线程的环境下，WSACleanup（）中止了Windows Sockets在所有线程上的操作
void AutoWSACleanup()
{
	::WSACleanup();//每一次WSAStartup（）调用，必须有一个WSACleanup（）调用
}
int main()
{
	int n;
	WSADATA wd;//这个结构被用来存储被WSAStartup函数调用后返回的Windows Sockets数据
	n = WSAStartup(MAKEWORD(2, 2), &wd);
	//使用Socket的程序在使用Socket之前必须调用WSAStartup函数。该函数的第一个参数指明程序请求使用的Socket版本，其中高位字节指明副版本、低位字节指明主版本；操作系统利用第二个参数返回请求的Socket的版本信息。           
	//返回值为0则是正常的
	if (n)
	{
		cout << "WSAStartup函数错误！" << endl;
		system("pause");
		return -1;
	}
	atexit(AutoWSACleanup);
	SOCKET sock = socket(AF_INET, SOCK_RAW, IPPROTO_IP);//创建原始套接字，其原型为int socket(int domain, int type, int protocol)，参数protocol用来指明所要接收的协议包， IPPROTO_IP代表IP协议， AF_INET表示这是IPv4网络协议的套接字，SOCK_RAW指的就是套接字类型为原始套接字。
	if (sock == INVALID_SOCKET)//若创建出来的套接字为无效套接字
	{
		cout << WSAGetLastError();//输出对应的错误代码
		system("pause");
		return 0;
	}
	/*获取主机名*/
	char  hostName[128];
	if (-1 == gethostname(hostName, sizeof(hostName))) //，获取主机名，并判断是否获取成功
	{
		closesocket(sock); //关闭socket句柄，并释放相关资源。
		cout << WSAGetLastError();//输出相应错误代码
		system("pause");
		return 0;
	}
	/*获取本机IP地址*/
	struct hostent * pHostent;
	pHostent = gethostbyname(hostName);

	//填充SOCKADDR_IN结构的内容
	sockaddr_in addr;
	addr.sin_family = AF_INET; //代表TCP/IP协议族。
	addr.sin_addr = *(in_addr*)pHostent->h_addr_list[0]; //IP
	addr.sin_port = 8888; //端口，IP层端口可随意填
	/*绑定socket*/
	if (SOCKET_ERROR == bind(sock, (sockaddr *)&addr, sizeof(addr)))
		//socket名称包含"协议， ip地址,  端口号"这三个要素， 而命名就是通过调用bind函数把socket与这三个要素绑定一起来
		//0表示绑定成功
	{
		closesocket(sock);
		cout << WSAGetLastError();
		system("pause");
		return 0;
	}
	//设置该SOCKET为接收所有流经绑定的IP的网卡的所有数据，包括接收和发送的数据包
	u_long sioarg = 1;
	DWORD wt = 0;//
	if (SOCKET_ERROR == WSAIoctl(sock, SIO_RCVALL, &sioarg, sizeof(sioarg), NULL, 0, &wt, NULL, NULL))
		//WSAIoctl(sock,IO_RCVALL,&dwBufferInLen,sizeof(dwBufferInLen),&dwBufferLen,sizeof(dwBufferLen),&dwBytesReturned,NULL,NULL)用来把网卡设置为混杂模式
	{
		closesocket(sock);
		cout << WSAGetLastError();
		system("pause");
		return 0;
	}

	//我们只需要接收数据，因此设置为阻塞IO，使用最简单的IO模型
	//(阻塞IO： 资源不可用时，IO请求一直阻塞，直到反馈结果（有数据或超时）)
		u_long bioarg = 0;
	if (SOCKET_ERROR == ioctlsocket(sock, FIONBIO, &bioarg))
	{
		closesocket(sock);
		cout << WSAGetLastError();
		system("pause");
		return 0;
	}
//接收经过的IP包
	//开始接收数据
	//因为前面已经设置为阻塞IO，recv在接收到数据前不会返回。
	cnt = 1;
	char buf[65535];
	int len = 0;
	do
	{
		len = recv(sock, buf, sizeof(buf), 0);
		//recv(sock, buffer, 65535, 0) 函数用来接收经过的IP包，参数分别为套接字描述符，缓冲区的地址，缓冲区的大小
		if (len > 0)
		{
			DecodeIP(buf, len);//解析接收的数据包
		}
	} while (len > 0);
	closesocket(sock);
	system("pause");
	return 0;
}
#define _CRT_SECURE_NO_WARNINGS //ʹ�ò���ȫ����
#define _WINSOCK_DEPRECATED_NO_WARNINGS//inet_addr �ú������µ�MFC�б��滻��������vs������������Ԥ�������ʹ�øú�������ֹ����
#include <iostream>
#include <winsock2.h>//socketͨ�ţ�ϵͳͷ�ļ�
#include <windows.h>
#include <string.h>
#include "mstcpip.h"//��������Ҫ�õ���ͷ�ļ�
#pragma comment(lib,"Ws2_32.lib")//��̬����һ�����ļ�
using namespace std;
//IP�ײ�
typedef struct tIPPackHead
{
	BYTE ver_hlen;        //IPЭ��汾��IP�ײ����ȡ���4λΪ�汾����4λΪ�ײ��ĳ���(��λΪ4bytes)
	BYTE byTOS;          //��������
	WORD wPacketLen;    //IP���ܳ��ȡ������ײ�����λΪbyte��
	WORD wSequence;    //��ʶ
	union
	{
		WORD Flags;     //��־
		WORD FragOf;    //�ֶ�ƫ��
	};
	BYTE byTTL;          //����ʱ�� 
	BYTE byProtocolType;  //Э������
	WORD wHeadCheckSum;    //IP�ײ�У���
	DWORD dwIPSrc;          //Դ��ַ
	DWORD dwIPDes;          //Ŀ�ĵ�ַ
	BYTE Options;             //ѡ��
} IP_HEAD;
int cnt;
int DecodeIP(char *buf, int len)
{
	int n = len;
	if (n >= sizeof(IP_HEAD))
	{
		IP_HEAD iphead;
		iphead = *(IP_HEAD*)buf;
		cout << "�� " << cnt++ << " ��IP���ݰ���Ϣ��" << endl;
		cout << "Э��汾:" << (iphead.ver_hlen >> 4) << endl;
		cout << "�ײ�����:" << ((iphead.ver_hlen & 0x0F) << 2) << endl;//��λΪ4�ֽ�
		cout << "��������:Priority: " << (iphead.byTOS >> 5) << ",Service: " << ((iphead.byTOS >> 1) & 0x0f) << endl;
		cout << "IP���ܳ���:" << ntohs(iphead.wPacketLen) << endl; //�����ֽ���תΪ�����ֽ���
		cout << "��ʶ:" << ntohs(iphead.wSequence) << endl;
		cout << "��־λ:" << "DF=" << ((iphead.Flags >> 14) & 0x01) << ",MF=" << ((iphead.Flags >> 13) & 0x01) << endl;
		cout << "Ƭƫ��:" << (iphead.FragOf & 0x1fff) << endl;
		cout << "��������:" << (int)iphead.byTTL << endl;
		cout << "Э������:" << int(iphead.byProtocolType) << endl;
		cout << "�ײ�У���:" << ntohs(iphead.wHeadCheckSum) << endl;
		cout << "Դ��ַ:" << inet_ntoa(*(in_addr*)&iphead.dwIPSrc) << endl;
		cout << "Ŀ�ĵ�ַ:" << inet_ntoa(*(in_addr*)&iphead.dwIPDes) << endl;
		cout << "==============================================================" << endl << endl;
	}system("pause");
	return 0;
}
//��һ�����̵߳Ļ����£�WSACleanup������ֹ��Windows Sockets�������߳��ϵĲ���
void AutoWSACleanup()
{
	::WSACleanup();//ÿһ��WSAStartup�������ã�������һ��WSACleanup��������
}
int main()
{
	int n;
	WSADATA wd;//����ṹ�������洢��WSAStartup�������ú󷵻ص�Windows Sockets����
	n = WSAStartup(MAKEWORD(2, 2), &wd);
	//ʹ��Socket�ĳ�����ʹ��Socket֮ǰ�������WSAStartup�������ú����ĵ�һ������ָ����������ʹ�õ�Socket�汾�����и�λ�ֽ�ָ�����汾����λ�ֽ�ָ�����汾������ϵͳ���õڶ����������������Socket�İ汾��Ϣ��           
	//����ֵΪ0����������
	if (n)
	{
		cout << "WSAStartup��������" << endl;
		system("pause");
		return -1;
	}
	atexit(AutoWSACleanup);
	SOCKET sock = socket(AF_INET, SOCK_RAW, IPPROTO_IP);//����ԭʼ�׽��֣���ԭ��Ϊint socket(int domain, int type, int protocol)������protocol����ָ����Ҫ���յ�Э����� IPPROTO_IP����IPЭ�飬 AF_INET��ʾ����IPv4����Э����׽��֣�SOCK_RAWָ�ľ����׽�������Ϊԭʼ�׽��֡�
	if (sock == INVALID_SOCKET)//�������������׽���Ϊ��Ч�׽���
	{
		cout << WSAGetLastError();//�����Ӧ�Ĵ������
		system("pause");
		return 0;
	}
	/*��ȡ������*/
	char  hostName[128];
	if (-1 == gethostname(hostName, sizeof(hostName))) //����ȡ�����������ж��Ƿ��ȡ�ɹ�
	{
		closesocket(sock); //�ر�socket��������ͷ������Դ��
		cout << WSAGetLastError();//�����Ӧ�������
		system("pause");
		return 0;
	}
	/*��ȡ����IP��ַ*/
	struct hostent * pHostent;
	pHostent = gethostbyname(hostName);

	//���SOCKADDR_IN�ṹ������
	sockaddr_in addr;
	addr.sin_family = AF_INET; //����TCP/IPЭ���塣
	addr.sin_addr = *(in_addr*)pHostent->h_addr_list[0]; //IP
	addr.sin_port = 8888; //�˿ڣ�IP��˿ڿ�������
	/*��socket*/
	if (SOCKET_ERROR == bind(sock, (sockaddr *)&addr, sizeof(addr)))
		//socket���ư���"Э�飬 ip��ַ,  �˿ں�"������Ҫ�أ� ����������ͨ������bind������socket��������Ҫ�ذ�һ����
		//0��ʾ�󶨳ɹ�
	{
		closesocket(sock);
		cout << WSAGetLastError();
		system("pause");
		return 0;
	}
	//���ø�SOCKETΪ�������������󶨵�IP���������������ݣ��������պͷ��͵����ݰ�
	u_long sioarg = 1;
	DWORD wt = 0;//
	if (SOCKET_ERROR == WSAIoctl(sock, SIO_RCVALL, &sioarg, sizeof(sioarg), NULL, 0, &wt, NULL, NULL))
		//WSAIoctl(sock,IO_RCVALL,&dwBufferInLen,sizeof(dwBufferInLen),&dwBufferLen,sizeof(dwBufferLen),&dwBytesReturned,NULL,NULL)��������������Ϊ����ģʽ
	{
		closesocket(sock);
		cout << WSAGetLastError();
		system("pause");
		return 0;
	}

	//����ֻ��Ҫ�������ݣ��������Ϊ����IO��ʹ����򵥵�IOģ��
	//(����IO�� ��Դ������ʱ��IO����һֱ������ֱ����������������ݻ�ʱ��)
		u_long bioarg = 0;
	if (SOCKET_ERROR == ioctlsocket(sock, FIONBIO, &bioarg))
	{
		closesocket(sock);
		cout << WSAGetLastError();
		system("pause");
		return 0;
	}
//���վ�����IP��
	//��ʼ��������
	//��Ϊǰ���Ѿ�����Ϊ����IO��recv�ڽ��յ�����ǰ���᷵�ء�
	cnt = 1;
	char buf[65535];
	int len = 0;
	do
	{
		len = recv(sock, buf, sizeof(buf), 0);
		//recv(sock, buffer, 65535, 0) �����������վ�����IP���������ֱ�Ϊ�׽������������������ĵ�ַ���������Ĵ�С
		if (len > 0)
		{
			DecodeIP(buf, len);//�������յ����ݰ�
		}
	} while (len > 0);
	closesocket(sock);
	system("pause");
	return 0;
}
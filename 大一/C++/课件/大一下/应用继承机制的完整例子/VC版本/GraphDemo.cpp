#include "basgraph.hpp"

HWND hWnd; //�������д��ڵľ��;       
HDC hDC;//�豸�������;        
HPEN hPen; //����; 

int main(int argc, char* argv[])
{  
	hWnd=FindWindowA(NULL,argv[0]); //�ҵ��������д��ڵľ��; 
	hDC=GetDC(hWnd);//ͨ�����ھ���õ��ô��ڵ��豸�������;

	hPen=CreatePen(PS_DASH,2,0x00ff00);//������ɫ����;
	SelectObject(hDC,hPen);//�ѻ��������豸����;  
    Circle circle(200,200,50);
   //��ʾԲ
   circle.Show();
   system("pause");
   //�ƶ�
   circle.Move_to(250,250);
   system("pause");
   hPen=CreatePen(PS_DASH,2,0x0000ff);//���ɺ�ɫ����;
   SelectObject(hDC,hPen);//�ѻ��������豸����;  
   //�Ŵ�
   circle.Expand(100);
   system("pause"); 
   //����
   hPen=CreatePen(PS_DASH,2,0xff0000);//������ɫ����;
   SelectObject(hDC,hPen);//�ѻ��������豸����;  
   circle.Contract(65);
   system("pause"); 

   return 0;
}
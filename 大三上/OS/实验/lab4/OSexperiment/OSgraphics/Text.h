// Text.h: interface for the CText class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_TEXT_H__ACE670F8_DEFD_4154_9336_E9906CCFCBDF__INCLUDED_)
#define AFX_TEXT_H__ACE670F8_DEFD_4154_9336_E9906CCFCBDF__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#if !defined pi
#define pi 3.1415926535
#endif

#include "Feature.h"

class CText : public CFeature  
{
protected:
	int m_StartX;					//标注文本起点横坐标
	int m_StartY;					//标注文本起点纵坐标
	float m_Angle1;					//标注角度
	float m_Angle2;					//字体旋转角度
	int m_TextHeight;				//字体高度
	int m_TextWide;					//字体宽度
	int m_OffWide;					//字体标注间隔
	unsigned char m_TextFont;		//字体
	CString c_Text;					//标注文本内容
	int m_TextLong;					//标注文本的字符长度 
	

public:
	CText();
	virtual ~CText();
	CText(COLORREF ColorPen,short LineWide,short LineType,int StartX,int StartY,float Angle1,float Angle2,int TextHeight,
		int TextWide,int OffWide,CString Text)
		:CFeature (ColorPen,LineWide,LineType)
	{
		m_StartX = StartX;
		m_StartY = StartY;
		m_Angle1 = Angle1;
		m_Angle2 = Angle2;
		m_TextHeight = TextHeight;
		m_TextWide = TextWide;
		m_OffWide = OffWide;
		m_TextLong = Text.GetLength();		//计算字符的长度
		c_Text = Text;
	}
public:
	virtual void Draw(CDC *pDC);

};

#endif // !defined(AFX_TEXT_H__ACE670F8_DEFD_4154_9336_E9906CCFCBDF__INCLUDED_)

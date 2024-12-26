// Cirque.h: interface for the CCirque class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_CIRQUE_H__23423C83_0543_469B_AAB1_EEE0095B03ED__INCLUDED_)
#define AFX_CIRQUE_H__23423C83_0543_469B_AAB1_EEE0095B03ED__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "Circle.h"

class CCirque : public CCircle  
{
public:
	CCirque();
	/*	
	colorFill 颜色。该圆环线的颜色和填充色
	LineWidth 边缘线条宽度
	bFill 是否填充颜色
	CircleX 圆心X坐标
	CircleY 圆心Y坐标
	InCircleR 内圆半径
	OutCircleR 外圆半径
	*/
	CCirque(COLORREF  colorFill,
			short LineWidth,
			BOOL bFill,
			short CircleX,short CircleY,
			short InCircleR,short OutCircleR
			)
			:CCircle(colorFill,LineWidth,0,colorFill,0,bFill,	CircleX, CircleY,InCircleR)
	{
		m_OutCircleR=OutCircleR;		
	}
	virtual ~CCirque();
	
protected:
	short m_OutCircleR;	      // 外圈半径

	
public:
	void setLine(COLORREF colorPen,short LineWide)  //不填充的时候用来设置边的属性，不过里外的边是一样的
	{
		m_colorPen=colorPen;
		m_LineWide=LineWide;
	}
	virtual void Draw(CDC*pDC);

};

#endif // !defined(AFX_CIRQUE_H__23423C83_0543_469B_AAB1_EEE0095B03ED__INCLUDED_)

// Circle.h: interface for the CCircle class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_CIRCLE_H__DFD9345F_4143_4ACA_B3FE_E6AAEE758F88__INCLUDED_)
#define AFX_CIRCLE_H__DFD9345F_4143_4ACA_B3FE_E6AAEE758F88__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "AreaFtr.h"
	

class CCircle : public CAreaFtr  
{	
public:
	CCircle();
	CCircle(COLORREF colorPen,short LineWide,short LineType,COLORREF  colorFill,short FillType,BOOL bFill,
		short CircleX,short CircleY,short CircleR)
		:CAreaFtr(colorPen,LineWide,LineType,colorFill,FillType,bFill)
	{
		m_CircleX = CircleX;
		m_CircleY = CircleY;
		m_CircleR = CircleR;
	}
	virtual ~CCircle();

protected:
	short m_CircleX,m_CircleY,m_CircleR;	//记录圆心坐标及半径的变量

public:
	virtual void Draw(CDC *pDC);

};

#endif // !defined(AFX_CIRCLE_H__DFD9345F_4143_4ACA_B3FE_E6AAEE758F88__INCLUDED_)

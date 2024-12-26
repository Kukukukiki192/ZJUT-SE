// LineFtr.h: interface for the CLineFtr class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_LINEFTR_H__05646A66_71B1_452A_A98C_CB6134D35B34__INCLUDED_)
#define AFX_LINEFTR_H__05646A66_71B1_452A_A98C_CB6134D35B34__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "PolyLine.h"

class CLineFtr : public CPolyLine  
{
public:
	CLineFtr();
	void CLineFtr::SetLineFtr(int X1,int Y1,int X2,int Y2);
	CLineFtr(COLORREF ColorPen,short LineWide, short LineType,int X1,int Y1,int X2,int Y2);
		
	virtual ~CLineFtr();
	

protected:
	int m_X1,m_X2,m_Y1,m_Y2;		//the start point and end point of a line

//public:
///	virtual void Draw(CDC *pDC);

};

#endif // !defined(AFX_LINEFTR_H__05646A66_71B1_452A_A98C_CB6134D35B34__INCLUDED_)

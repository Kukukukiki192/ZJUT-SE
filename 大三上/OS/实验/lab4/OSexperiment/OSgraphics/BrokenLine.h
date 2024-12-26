// BrokenLine.h: interface for the CBrokenLine class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_LINEFTR_H__05646A66_71B1_452A_A98C_CB6134D35B34__INCLUDED_)
#define AFX_LINEFTR_H__05646A66_71B1_452A_A98C_CB6134D35B34__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "LineFtr.h"

class BrokenLine : public CLineFtr 
{
public:
	BrokenLine();	
	BrokenLine(COLORREF ColorPen,short LineWide, short LineType,CPoint * Peak, short nPeakNum );		
	virtual ~BrokenLine();

 
protected:
	CPoint * m_Peak;		//顶点集合,点(CPoint) 的数组
	short m_nPeakNum;		//顶点个数

public:
	virtual void Draw(CDC *pDC);

};

#endif // !defined(AFX_LINEFTR_H__05646A66_71B1_452A_A98C_CB6134D35B34__INCLUDED_)

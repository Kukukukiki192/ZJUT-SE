// PolyLine.h: interface for the CPolyLine class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_BROKEN_H__3D426E73_BD30_4CD5_B259_E309D1061414__INCLUDED_)
#define AFX_BROKEN_H__3D426E73_BD30_4CD5_B259_E309D1061414__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "Feature.h"

class CPolyLine : public CFeature 
{
public:
	CPolyLine();	
	CPolyLine(COLORREF ColorPen,short LineWide, short LineType,CPoint * Peak=0, short nPeakNum=0 );		
	virtual ~CPolyLine();

 
protected:
	CPoint * m_Peak;		//顶点集合,点(CPoint) 的数组
	short m_nPeakNum;		//顶点个数

public:
	virtual void Draw(CDC *pDC);

};

#endif // !defined(AFX_LINEFTR_H__05646A66_71B1_452A_A98C_CB6134D35B34__INCLUDED_)

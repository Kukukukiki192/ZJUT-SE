// Poly.h: interface for the CPoly class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_POLYLINE_H__D018259B_B73B_463D_A43A_ED1F288FE3B6__INCLUDED_)
#define AFX_POLYLINE_H__D018259B_B73B_463D_A43A_ED1F288FE3B6__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "AreaFtr.h"

class CPoly : public CAreaFtr  
{
public:
	CPoly();
	CPoly(COLORREF colorPen, short LineWide, short LineType,COLORREF colorFill,short FillType,BOOL bFill,CPoint* Peak=0,short nPeakNum=0);
	virtual ~CPoly();

protected:
	CPoint * m_Peak;		//顶点集合,点(CPoint) 的数组
	short m_nPeakNum;		//顶点个数
public:
	virtual void Draw(CDC *pDC);
};

#endif // !defined(AFX_POLYLINE_H__D018259B_B73B_463D_A43A_ED1F288FE3B6__INCLUDED_)

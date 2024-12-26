// Square.h: interface for the CSquare class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_SQUARE_H__40005374_A1C0_4D65_A5B8_3CDF22EAEEF8__INCLUDED_)
#define AFX_SQUARE_H__40005374_A1C0_4D65_A5B8_3CDF22EAEEF8__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "Rectangle.h"

class CSquare : public CRectangle  
{
public:
	CSquare();
	CSquare(COLORREF colorPen, short LineWide, short LineType,COLORREF colorFill,short FillType,BOOL bFill,CPoint ptLeftTop/*左上角顶点*/,int SideLength=0);
	virtual ~CSquare();
protected:
	int m_nSideLength;		//正方形边长

};

#endif // !defined(AFX_SQUARE_H__40005374_A1C0_4D65_A5B8_3CDF22EAEEF8__INCLUDED_)

// Rectangle.h: interface for the CRectangle class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_RECTANGLE_H__957CA9E2_EFC0_4436_8057_67AD67E98D7B__INCLUDED_)
#define AFX_RECTANGLE_H__957CA9E2_EFC0_4436_8057_67AD67E98D7B__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "Poly.h"

class CRectangle : public CPoly  
{
public:
	CRectangle();
	CRectangle(COLORREF colorPen, short LineWide, short LineType,COLORREF colorFill,short FillType,BOOL bFill,CPoint ptLeftTop/*左上角顶点*/,CPoint ptRightBottom/*右下角顶点*/);
	virtual ~CRectangle();
public:
	void SetRectPeak(CPoint ptLeftTop/*左上角顶点*/,CPoint ptRightBottom/*右下角顶点*/ );		//设置矩形的顶点

};

#endif // !defined(AFX_RECTANGLE_H__957CA9E2_EFC0_4436_8057_67AD67E98D7B__INCLUDED_)

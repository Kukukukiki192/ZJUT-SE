// Rectangle.cpp: implementation of the CRectangle class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "Rectangle.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CRectangle::CRectangle()
{

}
CRectangle::CRectangle(COLORREF colorPen, short LineWide, short LineType,COLORREF colorFill,short FillType,BOOL bFill,CPoint ptLeftTop/*左上角顶点*/,CPoint ptRightBottom/*右下角顶点*/)
	:CPoly(colorPen,LineWide,LineType,colorFill,FillType,bFill)
{
	m_nPeakNum = 4;
	m_Peak = new CPoint [m_nPeakNum];
	m_Peak[0] = ptLeftTop;	
	m_Peak[1] = CPoint(ptRightBottom.x,ptLeftTop.y);	
	m_Peak[2] = ptRightBottom;
	m_Peak[3] = CPoint(ptLeftTop.x,ptRightBottom.y);	
}
CRectangle::~CRectangle()
{
	
}

void CRectangle::SetRectPeak(CPoint ptLeftTop,CPoint ptRightBottom )
{
	m_Peak[0] = ptLeftTop;	
	m_Peak[1] = CPoint(ptRightBottom.x,ptLeftTop.y);	
	m_Peak[2] = ptRightBottom;
	m_Peak[3] = CPoint(ptLeftTop.x,ptRightBottom.y);
}

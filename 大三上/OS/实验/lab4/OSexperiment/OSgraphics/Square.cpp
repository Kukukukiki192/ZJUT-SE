// Square.cpp: implementation of the CSquare class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "Square.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CSquare::CSquare()
{

}
CSquare::CSquare(COLORREF colorPen, short LineWide, short LineType,COLORREF colorFill,short FillType,BOOL bFill,CPoint ptLeftTop/*×óÉÏ½Ç¶¥µã*/,int SideLength)
	:CRectangle(colorPen,LineWide,LineType,colorFill,FillType,bFill,ptLeftTop,CPoint(ptLeftTop.x+SideLength,ptLeftTop.y+SideLength))
{
	m_nSideLength = SideLength;
}

CSquare::~CSquare()
{

}


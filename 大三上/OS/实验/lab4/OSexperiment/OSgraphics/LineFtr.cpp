// LineFtr.cpp: implementation of the CLineFtr class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "LineFtr.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////
CLineFtr::CLineFtr()
{
}

CLineFtr::CLineFtr(COLORREF colorPen,short LineWide, short LineType,int X1,int Y1,int X2,int Y2)
   :CPolyLine(colorPen,LineWide,LineType)
  // :CPolyLine()
{
    m_nPeakNum = 2;
	m_Peak = new CPoint [m_nPeakNum];
    m_Peak[0].x = X1;
    m_Peak[0].y = Y1;
    m_Peak[1].x = X2;
    m_Peak[1].y = Y2;
	m_X1 = X1;
    m_Y1 = Y1;
    m_X2 = X2;
    m_Y2 = Y2;
     
}

void CLineFtr::SetLineFtr(int X1,int Y1,int X2,int Y2)
{
	m_Peak[0].x = X1;
    m_Peak[0].y = Y1;
    m_Peak[1].x = X2;
    m_Peak[1].y = Y2;
	m_X1 = X1;
    m_Y1 = Y1;
    m_X2 = X2;
    m_Y2 = Y2;
}

CLineFtr::~CLineFtr()
{

}






	

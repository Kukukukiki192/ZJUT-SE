// LineFtr.cpp: implementation of the CLineFtr class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "BrokenLine.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////
BrokenLine::BrokenLine();
BrokenLine::BrokenLine(COLORREF ColorPen,short LineWide, short LineType,CPoint*Peak, short nPeakNum)
	:CLineFtr(ColorPen,LineWide,LineType)
{

	m_nPeakNum = nPeakNum;
	m_Peak = new CPoint [m_nPeakNum];
	if (m_nPeakNum > 0)
	{
	   	for (int i = 0; i < m_nPeakNum; i++)
		{
			//这个地方需要判断Peak[i]是否合法？？？
			m_Peak[i]  = Peak[i];			
		}
	 
	}
}


CBrokenLine::~CBrokenLine()
{
   delete [] m_Peak;
}

/*void CBrokenLine::SetBrokenLine(int X1, int Y1,int X2,int Y2,short nPeakNum )
{
	
}*/

void CBrokenLine::Draw(CDC *pDC)
{
	COLORREF ColorPen = m_colorPen;
	
	CPen pen ((int)m_LineType,(int)m_LineWide,ColorPen);
	CPen * pOldPen = pDC ->SelectObject(&pen);
	
	pDC->MoveTo(m_Peak[0].x,m_Peak[0].y);
	for (int i = 0; i< m_nPeakNum; i++)
	{
		pDC->LineTo(m_Peak[i].x,m_Peak[i].y);
	}	
	pDC->SelectObject(pOldPen);

}







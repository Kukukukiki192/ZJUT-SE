// LineFtr.cpp: implementation of the CPloyLine class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "PolyLine.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////
CPolyLine::CPolyLine()
{
}

CPolyLine::CPolyLine(COLORREF colorPen,short LineWide, short LineType, CPoint * Peak, short nPeakNum)
	:CFeature(colorPen,LineWide,LineType)
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


CPolyLine::~CPolyLine()
{
   delete [] m_Peak;
}

/*void CBrokenLine::SetBrokenLine(int X1, int Y1,int X2,int Y2,short nPeakNum )
{
	
}*/

void CPolyLine::Draw(CDC *pDC)
{
	CPen pen((int)m_LineType,(int)m_LineWide,m_colorPen);

	CPen * pOldPen = pDC ->SelectObject(&pen);
	
	pDC->MoveTo(m_Peak[0].x,m_Peak[0].y);
	for (int i = 0; i< m_nPeakNum; i++)
	{
		pDC->LineTo(m_Peak[i].x,m_Peak[i].y);
	}	
	pDC->SelectObject(pOldPen);

}







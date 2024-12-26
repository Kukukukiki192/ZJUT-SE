// Poly.cpp: implementation of the CPoly class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "Poly.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CPoly::CPoly()
{

}
CPoly::CPoly(COLORREF colorPen, short LineWide, short LineType,COLORREF colorFill,short FillType,BOOL bFill,CPoint* Peak,short nPeakNum)
	:CAreaFtr(colorPen,LineWide,LineType,colorFill,FillType,bFill)
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

CPoly::~CPoly()
{
	delete [] m_Peak;
}
void CPoly::Draw(CDC *pDC)
{
	//创建并初始化一个CPen对象
	CPen pen((int)m_LineType,(int)m_LineWide,m_colorPen);
	CPen * pOldPen = pDC->SelectObject(&pen);
	CBrush brush(m_colorFill);
	CBrush * pOldBrush = pDC->SelectObject(&brush);

	pDC->MoveTo(m_Peak[0].x,m_Peak[0].y);
	for (int i = 0; i< m_nPeakNum; i++)
	{
		pDC->LineTo(m_Peak[i].x,m_Peak[i].y);
	}
	pDC->LineTo(m_Peak[0].x,m_Peak[0].y);
	if (m_bFill)
		pDC->Polygon(m_Peak,m_nPeakNum);
	
	pDC->SelectObject(pOldPen);
	pDC->SelectObject(pOldBrush);
	
}
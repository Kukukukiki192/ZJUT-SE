// Circle.cpp: implementation of the CCircle class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "Circle.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CCircle::CCircle()
{

}

CCircle::~CCircle()
{

}
void CCircle::Draw(CDC *pDC)
{
	//创建并初始化一个CPen对象
	CPen pen((int) m_LineType,(int)m_LineWide,m_colorPen);
	CPen * pOldPen = pDC->SelectObject(&pen);
	CBrush brush(m_colorFill);
	CBrush * pOldBrush = pDC->SelectObject(&brush);
	if (!m_bFill)
		pDC->SelectStockObject(NULL_BRUSH);
	pDC->Ellipse(m_CircleX-m_CircleR,m_CircleY-m_CircleR,m_CircleX+m_CircleR,m_CircleY+m_CircleR);
	pDC->SelectObject(pOldPen);
	pDC->SelectObject(pOldBrush);
}


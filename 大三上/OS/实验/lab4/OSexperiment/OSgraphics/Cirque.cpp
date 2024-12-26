// Cirque.cpp: implementation of the CCirque class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "Cirque.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CCirque::CCirque()
{

}

CCirque::~CCirque()
{

}
void CCirque::Draw(CDC*pDC)
{
	
	//创建并初始化一个CPen对象
	if(m_bFill){
		m_LineWide=m_OutCircleR - m_CircleR;
		m_colorPen=m_colorFill;
	}
	CPen pen((int) m_LineType,(int)m_LineWide,m_colorPen);
	CPen * pOldPen = pDC->SelectObject(&pen);
	if(!m_bFill){
		pDC->Ellipse(m_CircleX-m_OutCircleR,m_CircleY-m_OutCircleR,m_CircleX+m_OutCircleR,m_CircleY+m_OutCircleR);
		pDC->Ellipse(m_CircleX-m_CircleR,m_CircleY-m_CircleR,m_CircleX+m_CircleR,m_CircleY+m_CircleR);
	}
	else
		pDC->Ellipse(m_CircleX-(m_CircleR+m_OutCircleR)/2,m_CircleY-(m_CircleR+m_OutCircleR)/2,m_CircleX+(m_CircleR+m_OutCircleR)/2,m_CircleY+(m_CircleR+m_OutCircleR)/2);
	
	pDC->SelectObject(pOldPen);

	
	//创建并初始化一个CPen对象
	
}


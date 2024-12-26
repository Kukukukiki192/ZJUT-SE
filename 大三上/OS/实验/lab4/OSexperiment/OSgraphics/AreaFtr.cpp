// AreaFtr.cpp: implementation of the CAreaFtr class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
//#include "OSexperiment.h"
#include "AreaFtr.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CAreaFtr::CAreaFtr()
{
	m_colorFill = RGB(255,255,255);
}

CAreaFtr::~CAreaFtr()
{

}
void CAreaFtr::SetColorFill(COLORREF colorFill)
{
	m_colorFill = colorFill;
}
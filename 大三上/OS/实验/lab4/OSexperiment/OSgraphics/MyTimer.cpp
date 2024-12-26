// ImageMove.cpp: implementation of the CFeatureContainer class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "MyTimer.h"
#include "AllGraphicHead.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

CTimerMap CFeatureContainer::m_sTimeMap;
//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////


CFeatureContainer::CFeatureContainer(CDC * pDC)
{
	m_nTimerID = 0;
	m_nCurrentFtrIndex =0;
	m_pDC = pDC;
}

CFeatureContainer::~CFeatureContainer()
{

}

void CFeatureContainer::AddFeature(CFeature * NewFtr)
{
	m_FtrQuene.AddTail(NewFtr);
}

void CFeatureContainer::Draw()
{
	int ftrCount = m_FtrQuene.GetCount();
	CFeature * tmpFtr;

	for ( int i = 0; i< ftrCount ; i++)
	{
		POSITION pos = m_FtrQuene.FindIndex(i);
		tmpFtr = m_FtrQuene.GetAt(pos);
		tmpFtr->Draw(m_pDC);
	}
}

void CALLBACK CFeatureContainer::MyTimerProc(HWND hwnd,UINT uMsg,UINT idEvent,DWORD dwTime)
{	//KillTimer(NULL,idEvent);	

	CList<CFeature*,CFeature*> * tmpFtrList = & (m_sTimeMap[idEvent]->m_FtrQuene);
	int CurrentIndex = m_sTimeMap[idEvent]->m_nCurrentFtrIndex;
	POSITION pos = tmpFtrList->FindIndex(CurrentIndex);
	if (pos == NULL)
	{
		KillTimer(hwnd,idEvent);
		m_sTimeMap.RemoveKey(idEvent);
		return ;
	}
	else
	{
		m_sTimeMap[idEvent]->m_nCurrentFtrIndex+=1;
	}

	CFeature * tmpFtr;
	tmpFtr = tmpFtrList->GetAt(pos);
	
	tmpFtr->Draw(m_sTimeMap[idEvent]->m_pDC);
	//CString sss;
	//sss.Format("Current Feature Address = %d",(int)tmpFtr);
	//AfxMessageBox(sss);
	
}

void CFeatureContainer::SetMyTimer(UINT nElapse)
{
	m_nTimerID = SetTimer(NULL,NULL,nElapse,MyTimerProc);
	m_nCurrentFtrIndex =0;
	m_sTimeMap[m_nTimerID] = this;
}

void CFeatureContainer::KillMyTimer()
{
	KillTimer(NULL,m_nTimerID);
	m_sTimeMap.RemoveKey(m_nTimerID);
} 


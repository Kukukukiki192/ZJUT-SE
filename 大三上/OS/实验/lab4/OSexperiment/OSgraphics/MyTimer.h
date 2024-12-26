// ImageMoveTimer.h: interface for the CMyTimer class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_MYTIMER_H__D97674D1_B221_49CD_9637_4CBA8C3180CE__INCLUDED_)
#define AFX_MYTIMER_H__D97674D1_B221_49CD_9637_4CBA8C3180CE__INCLUDED_

#include <afxtempl.h>
#include "Feature.h"

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CFeatureContainer;
typedef CMap<UINT,UINT,CFeatureContainer*,CFeatureContainer*> CTimerMap;

/************************************************************************/
/* 一个图形的容器类                                                     */
/************************************************************************/
class CFeatureContainer  
{
public:	
	CFeatureContainer(CDC * pDC);
	virtual ~CFeatureContainer();

/*===================链表维护相关函数==================*/
public:
	//Add features to container
	void AddFeature(CFeature * NewFtr);
	//Draw all the features in the container
	void Draw();
private:
	//a list saving features
	CList<CFeature*,CFeature*> m_FtrQuene;

/*===================定时器相关函数==================*/
public:	
	//set the timer，nElapse表示时间间隔
	void SetMyTimer(UINT nElapse);
	//destroy instance of the timer
	void KillMyTimer();	
	//static member ,map table class. used to save all the timer information
	static CTimerMap m_sTimeMap;
	//Current index of feature in the container.
	int m_nCurrentFtrIndex;
	//静态成员函数，用于处理定时器的消息(每个时间间隔画一个Ftr，直到画完停止)
	static void CALLBACK MyTimerProc(HWND hwnd,UINT uMsg,UINT idEvent,DWORD dwTime);
private:
	//save identify of the timer
	UINT m_nTimerID;

/*===================其他==================*/
public:
	CDC * m_pDC;
};

#endif // !defined(AFX_MYTIMER_H__D97674D1_B221_49CD_9637_4CBA8C3180CE__INCLUDED_)
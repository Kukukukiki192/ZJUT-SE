// OSexperiment.h : main header file for the OSEXPERIMENT application
//

#if !defined(AFX_OSEXPERIMENT_H__A7965C02_5552_48B1_BDFB_BF9072D9BFC6__INCLUDED_)
#define AFX_OSEXPERIMENT_H__A7965C02_5552_48B1_BDFB_BF9072D9BFC6__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// COSexperimentApp:
// See OSexperiment.cpp for the implementation of this class
//

class COSexperimentApp : public CWinApp
{
public:
	COSexperimentApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COSexperimentApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(COSexperimentApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OSEXPERIMENT_H__A7965C02_5552_48B1_BDFB_BF9072D9BFC6__INCLUDED_)

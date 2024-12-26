// OSgraphicsExe.h : main header file for the OSGRAPHICSEXE application
//

#if !defined(AFX_OSGRAPHICSEXE_H__709DE226_74CC_41D0_8D3C_728A01F77C3A__INCLUDED_)
#define AFX_OSGRAPHICSEXE_H__709DE226_74CC_41D0_8D3C_728A01F77C3A__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeApp:
// See OSgraphicsExe.cpp for the implementation of this class
//

class COSgraphicsExeApp : public CWinApp
{
public:
	COSgraphicsExeApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COSgraphicsExeApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(COSgraphicsExeApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OSGRAPHICSEXE_H__709DE226_74CC_41D0_8D3C_728A01F77C3A__INCLUDED_)

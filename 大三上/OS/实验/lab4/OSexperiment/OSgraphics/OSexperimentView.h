// OSexperimentView.h : interface of the COSexperimentView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_OSEXPERIMENTVIEW_H__69F9F072_258C_40D2_972A_C4432162618C__INCLUDED_)
#define AFX_OSEXPERIMENTVIEW_H__69F9F072_258C_40D2_972A_C4432162618C__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class COSexperimentView : public CScrollView
{
protected: // create from serialization only
	COSexperimentView();
	DECLARE_DYNCREATE(COSexperimentView)

// Attributes
public:
	COSexperimentDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COSexperimentView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	virtual void OnInitialUpdate();
	protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~COSexperimentView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(COSexperimentView)
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in OSexperimentView.cpp
inline COSexperimentDoc* COSexperimentView::GetDocument()
   { return (COSexperimentDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OSEXPERIMENTVIEW_H__69F9F072_258C_40D2_972A_C4432162618C__INCLUDED_)

// OSgraphicsExeView.h : interface of the COSgraphicsExeView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_OSGRAPHICSEXEVIEW_H__B8E242E6_EC98_4885_90E6_9B72F352D17A__INCLUDED_)
#define AFX_OSGRAPHICSEXEVIEW_H__B8E242E6_EC98_4885_90E6_9B72F352D17A__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class COSgraphicsExeView : public CView
{
protected: // create from serialization only
	COSgraphicsExeView();
	DECLARE_DYNCREATE(COSgraphicsExeView)

// Attributes
public:
	COSgraphicsExeDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COSgraphicsExeView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~COSgraphicsExeView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(COSgraphicsExeView)
	afx_msg void OnShowWindow(BOOL bShow, UINT nStatus);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in OSgraphicsExeView.cpp
inline COSgraphicsExeDoc* COSgraphicsExeView::GetDocument()
   { return (COSgraphicsExeDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OSGRAPHICSEXEVIEW_H__B8E242E6_EC98_4885_90E6_9B72F352D17A__INCLUDED_)

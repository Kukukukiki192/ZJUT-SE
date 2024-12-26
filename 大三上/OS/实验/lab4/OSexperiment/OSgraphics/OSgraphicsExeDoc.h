// OSgraphicsExeDoc.h : interface of the COSgraphicsExeDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_OSGRAPHICSEXEDOC_H__B11DED1B_D517_4537_B9D6_9DC957A187BB__INCLUDED_)
#define AFX_OSGRAPHICSEXEDOC_H__B11DED1B_D517_4537_B9D6_9DC957A187BB__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class COSgraphicsExeDoc : public CDocument
{
protected: // create from serialization only
	COSgraphicsExeDoc();
	DECLARE_DYNCREATE(COSgraphicsExeDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COSgraphicsExeDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~COSgraphicsExeDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(COSgraphicsExeDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OSGRAPHICSEXEDOC_H__B11DED1B_D517_4537_B9D6_9DC957A187BB__INCLUDED_)

// MemoryDoc.h : interface of the CMemoryDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_MEMORYDOC_H__CEBF7D54_A140_4C83_853B_31A61A411E1E__INCLUDED_)
#define AFX_MEMORYDOC_H__CEBF7D54_A140_4C83_853B_31A61A411E1E__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CMemoryDoc : public CDocument
{
protected: // create from serialization only
	CMemoryDoc();
	DECLARE_DYNCREATE(CMemoryDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMemoryDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CMemoryDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CMemoryDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_MEMORYDOC_H__CEBF7D54_A140_4C83_853B_31A61A411E1E__INCLUDED_)

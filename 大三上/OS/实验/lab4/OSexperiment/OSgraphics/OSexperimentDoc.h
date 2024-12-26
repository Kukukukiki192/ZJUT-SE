// OSexperimentDoc.h : interface of the COSexperimentDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_OSEXPERIMENTDOC_H__5EDC125C_A8FA_441D_A192_DCAF32BBF6BD__INCLUDED_)
#define AFX_OSEXPERIMENTDOC_H__5EDC125C_A8FA_441D_A192_DCAF32BBF6BD__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class COSexperimentDoc : public CDocument
{
protected: // create from serialization only
	COSexperimentDoc();
	DECLARE_DYNCREATE(COSexperimentDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COSexperimentDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~COSexperimentDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(COSexperimentDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OSEXPERIMENTDOC_H__5EDC125C_A8FA_441D_A192_DCAF32BBF6BD__INCLUDED_)

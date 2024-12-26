// MemoryDoc.cpp : implementation of the CMemoryDoc class
//

#include "stdafx.h"
#include "Memory.h"

#include "MemoryDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMemoryDoc

IMPLEMENT_DYNCREATE(CMemoryDoc, CDocument)

BEGIN_MESSAGE_MAP(CMemoryDoc, CDocument)
	//{{AFX_MSG_MAP(CMemoryDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMemoryDoc construction/destruction

CMemoryDoc::CMemoryDoc()
{
	// TODO: add one-time construction code here

}

CMemoryDoc::~CMemoryDoc()
{
}

BOOL CMemoryDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CMemoryDoc serialization

void CMemoryDoc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: add storing code here
	}
	else
	{
		// TODO: add loading code here
	}
}

/////////////////////////////////////////////////////////////////////////////
// CMemoryDoc diagnostics

#ifdef _DEBUG
void CMemoryDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CMemoryDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMemoryDoc commands

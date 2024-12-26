// OSgraphicsExeDoc.cpp : implementation of the COSgraphicsExeDoc class
//

#include "stdafx.h"
#include "OSgraphicsExe.h"

#include "OSgraphicsExeDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeDoc

IMPLEMENT_DYNCREATE(COSgraphicsExeDoc, CDocument)

BEGIN_MESSAGE_MAP(COSgraphicsExeDoc, CDocument)
	//{{AFX_MSG_MAP(COSgraphicsExeDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeDoc construction/destruction

COSgraphicsExeDoc::COSgraphicsExeDoc()
{
	// TODO: add one-time construction code here

}

COSgraphicsExeDoc::~COSgraphicsExeDoc()
{
}

BOOL COSgraphicsExeDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeDoc serialization

void COSgraphicsExeDoc::Serialize(CArchive& ar)
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
// COSgraphicsExeDoc diagnostics

#ifdef _DEBUG
void COSgraphicsExeDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void COSgraphicsExeDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeDoc commands

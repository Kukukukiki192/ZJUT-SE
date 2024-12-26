// OSexperimentDoc.cpp : implementation of the COSexperimentDoc class
//

#include "stdafx.h"
#include "OSexperiment.h"

#include "OSexperimentDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// COSexperimentDoc

IMPLEMENT_DYNCREATE(COSexperimentDoc, CDocument)

BEGIN_MESSAGE_MAP(COSexperimentDoc, CDocument)
	//{{AFX_MSG_MAP(COSexperimentDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// COSexperimentDoc construction/destruction

COSexperimentDoc::COSexperimentDoc()
{
	// TODO: add one-time construction code here

}

COSexperimentDoc::~COSexperimentDoc()
{
}

BOOL COSexperimentDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// COSexperimentDoc serialization

void COSexperimentDoc::Serialize(CArchive& ar)
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
// COSexperimentDoc diagnostics

#ifdef _DEBUG
void COSexperimentDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void COSexperimentDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// COSexperimentDoc commands

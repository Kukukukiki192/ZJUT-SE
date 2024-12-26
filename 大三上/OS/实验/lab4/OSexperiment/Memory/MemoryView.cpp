// MemoryView.cpp : implementation of the CMemoryView class
//

#include "stdafx.h"
#include "Memory.h"

#include "MemoryDoc.h"
#include "MemoryView.h"

#include "..\OSgraphics\LineFtr.h"
#include "..\OSgraphics\Circle.h"
#include "..\OSgraphics\PolyLine.h"
#include "..\OSgraphics\Rectangle.h"
#include "..\OSgraphics\Square.h"
#include "MemAllocate.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMemoryView

IMPLEMENT_DYNCREATE(CMemoryView, CScrollView)

BEGIN_MESSAGE_MAP(CMemoryView, CScrollView)
	//{{AFX_MSG_MAP(CMemoryView)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CScrollView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMemoryView construction/destruction

CMemoryView::CMemoryView()
{
	// TODO: add construction code here

}

CMemoryView::~CMemoryView()
{
}

BOOL CMemoryView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CScrollView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CMemoryView drawing

void CMemoryView::OnDraw(CDC* pDC)
{
	CMemoryDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here

	/*CPoint * vertexs = new CPoint [3];
	vertexs[0]=CPoint(100,100);
	vertexs[1]=CPoint(600,200);
	vertexs[2]=CPoint(400,100);
	CSquare rect(RGB(255,111,0),4,0,RGB(100,100,100),0,1,vertexs[0],100);
	rect.Draw(pDC);*/
	CMemAllocate memallocate;
	memallocate.test();
	memallocate.DrawMemory(pDC);
	

}

void CMemoryView::OnInitialUpdate()
{
	CScrollView::OnInitialUpdate();

	//A4 Ö½µÄ´óÐ¡
	SIZE Size ={2489,3508};
	SIZE pSize = {200,200};
	SIZE lSize = {30,30};
	SetScrollSizes(MM_TEXT,Size,pSize,lSize);
}

/////////////////////////////////////////////////////////////////////////////
// CMemoryView printing

BOOL CMemoryView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CMemoryView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CMemoryView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CMemoryView diagnostics

#ifdef _DEBUG
void CMemoryView::AssertValid() const
{
	CScrollView::AssertValid();
}

void CMemoryView::Dump(CDumpContext& dc) const
{
	CScrollView::Dump(dc);
}

CMemoryDoc* CMemoryView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMemoryDoc)));
	return (CMemoryDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMemoryView message handlers

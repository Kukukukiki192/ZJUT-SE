// OSexperimentView.cpp : implementation of the COSexperimentView class
//

#include "stdafx.h"
#include "OSexperiment.h"

#include "OSexperimentDoc.h"
#include "OSexperimentView.h"

#include "LineFtr.h"
#include "Circle.h"
#include "PolyLine.h"
#include "Rectangle.h"
#include "Square.h"
#include "text.h"
#include "Cirque.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

int aa =0;

/////////////////////////////////////////////////////////////////////////////
// COSexperimentView

IMPLEMENT_DYNCREATE(COSexperimentView, CScrollView)

BEGIN_MESSAGE_MAP(COSexperimentView, CScrollView)
	//{{AFX_MSG_MAP(COSexperimentView)
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// COSexperimentView construction/destruction

COSexperimentView::COSexperimentView()
{
	// TODO: add construction code here

}

COSexperimentView::~COSexperimentView()
{
}

BOOL COSexperimentView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// COSexperimentView drawing

void COSexperimentView::OnDraw(CDC* pDC)
{
	COSexperimentDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
	//CLineFtr line(RGB(255,111,0),1,0,100,100,200,200);
	//line.Draw(pDC);
	
	//////////////circle/////////////////////////////////////////////////
	CCircle circle(RGB(255,111,0),2,0,RGB(100,40,100),0,800,500,300,100);
	circle.Draw(pDC);

	//////////////////////////////////////////////////////////////////////////
	
	/*CPoint * vertexs = new CPoint [3];
	vertexs[0]=CPoint(100,100);
	vertexs[1]=CPoint(600,200);
	vertexs[2]=CPoint(400,300);
	CRectangle rect(RGB(255,111,0),4,0,RGB(100,100,100),0,1,vertexs[0],vertexs[1]);
	rect.SetRectPeak(vertexs[0],vertexs[2]);
	rect.Draw(pDC);*/
	//CText tt(RGB(100,100,100),2,0,100,100,30,00,20,10,2,"顾国民是个大大的好人");
	//tt.Draw(pDC);

	////////Cirque/////////////////////////////////////
	CCirque cirque(RGB(255,111,0),3,0,300,300,50,100);
	cirque.Draw(pDC);
}

/////////////////////////////////////////////////////////////////////////////
// COSexperimentView printing

BOOL COSexperimentView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void COSexperimentView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void COSexperimentView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// COSexperimentView diagnostics

#ifdef _DEBUG
void COSexperimentView::AssertValid() const
{
	CView::AssertValid();
}

void COSexperimentView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

COSexperimentDoc* COSexperimentView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(COSexperimentDoc)));
	return (COSexperimentDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// COSexperimentView message handlers

void COSexperimentView::OnInitialUpdate() 
{
	SIZE Size ={2489,3508};
	SIZE pSize = {200,200};
	SIZE lSize = {30,30};
	SetScrollSizes(MM_TEXT,Size,pSize,lSize);

	CView::OnInitialUpdate();
}



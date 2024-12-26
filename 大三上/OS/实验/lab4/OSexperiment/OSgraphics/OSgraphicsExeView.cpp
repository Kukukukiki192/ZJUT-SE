// OSgraphicsExeView.cpp : implementation of the COSgraphicsExeView class
//

#include "stdafx.h"
#include "OSgraphicsExe.h"

#include "OSgraphicsExeDoc.h"
#include "OSgraphicsExeView.h"


#include "Feature.h"
#include "LineFtr.h"
#include "Circle.h"
#include "Poly.h"
#include "Rectangle.h"
#include "Square.h"
#include "PolyLine.h"
#include "Text.h"
#include "Cirque.h"
#include "mytimer.h "

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeView

IMPLEMENT_DYNCREATE(COSgraphicsExeView, CView)

BEGIN_MESSAGE_MAP(COSgraphicsExeView, CView)
	//{{AFX_MSG_MAP(COSgraphicsExeView)
	ON_WM_SHOWWINDOW()
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeView construction/destruction

COSgraphicsExeView::COSgraphicsExeView()
{
	// TODO: add construction code here

}

COSgraphicsExeView::~COSgraphicsExeView()
{
}

BOOL COSgraphicsExeView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeView drawing

void COSgraphicsExeView::OnDraw(CDC* pDC)
{
	COSgraphicsExeDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here


	
	CFeatureContainer ftrs(pDC);
	CLineFtr line(RGB(255,111,0),1,0,100,100,200,200);
	//line.Draw(pDC);
	
	//////////////circle/////////////////////////////////////////////////
	//CCircle circle(RGB(255,111,0),2,0,RGB(100,40,100),0,1,500,300,100);
	//circle.Draw(m_pDC);
	//circle.MoveImage(1000,pDC);
	
	//image = new CCircle(RGB(255,111,0),2,0,RGB(100,40,100),0,1,500,300,100);
	//image->Draw(m_pDC);
	//image->MoveImage(2000,m_pDC);
	
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
	CCirque cirque(RGB(255,111,0),3,1,300,300,50,100);
	
	
	ftrs.AddFeature(&line);
	ftrs.AddFeature(&cirque);
	//ftrs.Draw();
}

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeView printing

BOOL COSgraphicsExeView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void COSgraphicsExeView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void COSgraphicsExeView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeView diagnostics

#ifdef _DEBUG
void COSgraphicsExeView::AssertValid() const
{
	CView::AssertValid();
}

void COSgraphicsExeView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

COSgraphicsExeDoc* COSgraphicsExeView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(COSgraphicsExeDoc)));
	return (COSgraphicsExeDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// COSgraphicsExeView message handlers

void COSgraphicsExeView::OnShowWindow(BOOL bShow, UINT nStatus) 
{
	CView::OnShowWindow(bShow, nStatus);
	
	// TODO: Add your message handler code here
	CClientDC* pDC = new CClientDC(this);
	static CFeatureContainer ftrs(pDC);
	//CLineFtr line(RGB(255,111,0),1,0,100,100,200,200);
	CLineFtr * line = new CLineFtr(RGB(255,111,0),1,0,100,100,200,200);
	//line.Draw(pDC);
	
	//////////////circle/////////////////////////////////////////////////
	//CCircle circle(RGB(255,111,0),2,0,RGB(100,40,100),0,1,500,300,100);
	//circle.Draw(m_pDC);
	//circle.MoveImage(1000,pDC);
	
	//image = new CCircle(RGB(255,111,0),2,0,RGB(100,40,100),0,1,500,300,100);
	//image->Draw(m_pDC);
	//image->MoveImage(2000,m_pDC);
	
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
//	static CCirque cirque(RGB(255,111,0),3,1,300,300,50,100);
	CCirque * cirque  = new CCirque(RGB(255,111,0),3,1,300,300,50,100);
	CCircle * circle = new CCircle(RGB(255,111,0),2,0,RGB(100,40,100),0,1,500,300,100);
	
	
	ftrs.AddFeature(cirque);
	ftrs.AddFeature(line);
	ftrs.AddFeature(circle);
	ftrs.SetMyTimer(1000);
	//===========================================================
	static CFeatureContainer ftrs1(pDC);
	CLineFtr * line1 = new CLineFtr(RGB(0,255,0),1,0,200,200,300,50);
	CCirque * cirque1  = new CCirque(RGB(111,255,0),3,1,400,400,50,100);
	CCircle * circle1 = new CCircle(RGB(0,111,255),2,0,RGB(0,40,100),0,1,600,300,100);
	
	
	ftrs1.AddFeature(cirque1);
	ftrs1.AddFeature(line1);
	ftrs1.AddFeature(circle1);
	ftrs1.SetMyTimer(1500);
}

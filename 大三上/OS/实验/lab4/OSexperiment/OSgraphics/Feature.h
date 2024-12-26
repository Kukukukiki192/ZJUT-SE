// Feature.h: interface for the CFeature class.
//
//////////////////////////////////////////////////////////////////////


#if !defined(AFX_FEATURE_H__84814ECA_D8DC_47BA_9E2B_2358B25B8215__INCLUDED_)
#define AFX_FEATURE_H__84814ECA_D8DC_47BA_9E2B_2358B25B8215__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CFeature  
{
public:
	CFeature()
	{
		m_colorPen = RGB(0,0,0);
		m_LineWide = 1;
		m_LineType = 0;
	};
	CFeature(COLORREF& colorPen,short LineWide,short LineType)	//construct
	{
		m_colorPen = colorPen;
		m_LineWide = LineWide;
		m_LineType = LineType;
	}
	virtual ~CFeature();
	//画图形的虚函数
	virtual void Draw(CDC *pDC) {AfxMessageBox("Feature");}//= 0;


protected:
	COLORREF m_colorPen;		//pen color
	/*
	* 0 -- 实线 | 1 -- 虚线 | 2 -- 
	*/
	short m_LineWide;		//with of line(pixel)
	short m_LineType;		//type of line（实线 虚线 。。。。）
	
};

#endif // !defined(AFX_FEATURE_H__84814ECA_D8DC_47BA_9E2B_2358B25B8215__INCLUDED_)


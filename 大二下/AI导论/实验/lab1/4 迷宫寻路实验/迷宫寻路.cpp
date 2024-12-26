// maze.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include <iostream>
#include <strstream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

#define MAZE_ROW      9
#define MAZE_COL      7

char maze[MAZE_ROW][MAZE_COL]={
	' ',' ',' ',' ',' ','#','#',
	'#',' ',' ','#',' ',' ','#',
	' ','#',' ',' ','#','#',' ',
	' ',' ',' ',' ',' ',' ',' ',
	' ',' ','#','#','#',' ','#',
	'#',' ',' ',' ',' ','#',' ',
	' ','#',' ','#',' ','#',' ',
	' ',' ',' ',' ','#',' ',' ',
	' ',' ','#',' ',' ',' ',' ',
};


typedef struct
{
	int gn;
	int fn;
	int flag; //1����in open; 2����in close
}GFN;

map<int ,GFN*> gmap; //gֵ

int Bi=0, Bj=0;
int Ei=6, Ej=6;


bool opensort(int n1,int n2)
{
	map<int,GFN*>::iterator pos1,pos2;
	pos1 = gmap.find(n1);
	pos2 = gmap.find(n2);
	return pos1->second->fn < pos2->second->fn;
}


void getway(int i,int j,int gn);     //���·��
void printmaze();
void printway();
bool isok(int i,int j);//�ж�n1λ��Ϊ�Թ��п����ߵ�λ��

int main()
{
	vector<int> open;
	vector<int> close;

	map<int,GFN*>::iterator pos;
	vector<int>::iterator it;

	int n,gn,fn;
	int n1,gn1,fn1;
	int ci,cj;
	int ni,nj;

	GFN* pgf = NULL;

	printmaze();

	ci = Bi;
	cj = Bj;

	n = ci*MAZE_COL + cj;
	gn = 0;
//	fn = abs(Ei-ci)+abs(Ej-cj);
	fn = 0;
	pgf=new GFN;
	pgf->gn = 0;
	pgf->fn = fn;
	pgf->flag = 1;

	gmap[n] = pgf;
	open.push_back(n);

	while(!open.empty())
	{
		n = open.front(); //pop front from open
		open.erase(open.begin());

		ci = n/MAZE_COL;       //the corren sit
		cj = n%MAZE_COL;

		pos = gmap.find(n);     //find the sit
		gn = pos->second->gn;
		fn = pos->second->fn;

		pos->second->flag = 2;
		close.push_back(n);     //push n into close

		if(ci==Ei && cj==Ej)
		{
			cout<<"�ҵ����·��������Ϊ��"<<gn<<endl;
			//      getway(Ei,Ej,gn-1);
			//     printway();
			cout<<"�����Ľڵ�����"<<close.size()<<endl;
			cout<<"���ɵĽڵ�����"<<open.size()+close.size()<<endl;
			return 1;
		}

		gn1 = gn+1;
		for(int d=0; d<4; ++d)
		{
			ni = ci;
			nj = cj;
			switch(d)
			{
			case 0 : //left derect
				nj = cj-1;
				break;
			case 1 : //up derect
				ni = ci-1;
				break;
			case 2 : //right derect
				nj = cj+1;
				break;
			case 3 : //down derect
				ni = ci+1;
				break;
			}//end_switch

			if(isok(ni,nj))
			{
				n1 = ni*MAZE_COL+nj;
//				fn1 = abs(Ei-ni)+abs(Ej-nj)+gn1;
//                fn1 = 0;
                fn1 =abs(Ei-ni)*abs(Ej-nj)+abs(Ej-nj)*abs(Ej-nj)+gn1;
				pos = gmap.find(n1);
				if(pos!=gmap.end())
				{//n1 is old
					if(pos->second->fn   >   fn1)
					{
						pos->second->fn = fn1;
						pos->second->gn = gn1;
						if(pos->second->flag==2)
						{
							it = find(close.begin(),close.end(),n1);
							close.erase(it);
							open.push_back(n1);
						}
						sort(open.begin(),open.end(),opensort );
					}
				}
				else
				{//
					pgf = new GFN;
					pgf->gn = gn1;
					pgf->fn = fn1;
					pgf->flag = 1;

					gmap[n1] = pgf;
					open.push_back(n1);
					sort(open.begin(),open.end(),opensort );
				}//end_else
			}//end_if
		}//end_for
	}//end_while
	
	cout<<"û��·�����Ե�����ڣ�\n\n\n"<<endl;
	return 1;
}

bool isok(int i,int j) //�ж�n1λ��Ϊ�Թ��п����ߵ�λ��
{
	if( i>=0 && i<=MAZE_ROW && j>=0 && j<=MAZE_COL && maze[i][j]==' ')
		return true;
	return false;
}

void printmaze()
{
	cout<<"�Թ���"<<endl;
	for(int i=0; i<MAZE_ROW; ++i)
	{
		for(int j=0; j<MAZE_COL; ++j)
			cout<<maze[i][j];
		cout<<endl;
	}
	cout<<"�������Ϊ��("<<Bi<<","<<Bj<<")\n��������Ϊ��("<<Ei<<","<<Ej<<")\n\n"<<endl;

}

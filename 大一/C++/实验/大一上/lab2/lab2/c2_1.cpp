#include<iostream>
#include<iomanip>
using namespace std;
#define pi 3.1415926
int main()
{float r,h,l,s,sq,vq,vz;
	cout<<"Please enter r,h:"<<endl;
	cin>>r>>h;
	l=2*pi*r;
	s=pi*r*r;
	sq=4*pi*r*r;
	vq=4*pi*r*r*r/3;
	vz=pi*r*r*h;
	cout<<setiosflags(ios::fixed)<<setprecision(2);
	cout<<"圆周长l="<<l<<'\n'<<"圆面积s="<<s<<'\n'<<"圆球表面积sq="<<sq<<'\n'<<"圆球体积vq="<<vq<<'\n'<<"圆柱体积vz="<<vz<<endl;
	return 0;
}
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
	cout<<"Բ�ܳ�l="<<l<<'\n'<<"Բ���s="<<s<<'\n'<<"Բ������sq="<<sq<<'\n'<<"Բ�����vq="<<vq<<'\n'<<"Բ�����vz="<<vz<<endl;
	return 0;
}
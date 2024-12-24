template <class T>
class BOOLEAN
{
	private:
	T x;
	bool y;
	public:
	BOOLEAN();
	BOOLEAN(char z)
	{x=z;if(x=='0'||x=='\0')y=false;else y=true;}
	BOOLEAN(int z)
	{x=z;if(x<=0)y=false;else y=true;}
	BOOLEAN(long z)
	{x=z;if(x<=0)y=false;else y=true;}
	BOOLEAN(double z)
	{x=z;if(x<=0.0)y=false;else y=true;}
	BOOLEAN(const BOOLEAN &a){x=a.x;y=a.y;}//¿½±´
	friend bool operator&&(BOOLEAN&,BOOLEAN&);
	friend bool operator||(BOOLEAN&,BOOLEAN&);
	friend bool operator^(BOOLEAN&,BOOLEAN&);//Òì»ò
	bool operator!();
	friend ostream& operator<<(ostream&,BOOLEAN&);
};
bool operator&&(BOOLEAN &a,BOOLEAN &b)
{
	if(a.y==true&&b.y==true)return true;
	else return false;
}
bool operator||(BOOLEAN &a,BOOLEAN &b)
{
	if(a.y==false&&b.y==false)return false;
	else return true;
}
bool operator^(BOOLEAN &a,BOOLEAN &b)
{
	if((a.y==true||b.y==true)&&(a.y==false||b.y==false))return true;
	else return false;
}
BOOLEAN::bool operator!()
{return !y;
}
ostream& ostream&::operator<<(ostream &out,BOOLEAN &a)
{
	if(a.y==true)out<<1;
	else out<<0;
}
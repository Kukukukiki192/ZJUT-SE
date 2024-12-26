class pool
{
public:
   pool(double rv,double cv,int n){radius=rv; c=cv; num=n; }
   ~pool(){cout<<"destructor called"<<num<<endl;}
   double rail_length ();
   double rail_area();
private:
   double radius;
   double c;
   int num;
};

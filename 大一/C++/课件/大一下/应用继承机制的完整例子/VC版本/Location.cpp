#include "basgraph.hpp"

//¹¹Ôìº¯Êý
Location::Location(int x,int y)
{ X_pos=x;
  Y_pos=y;
}

int Location::Get_x()
{return X_pos;  }

int Location::Get_y()
{ return Y_pos;  }
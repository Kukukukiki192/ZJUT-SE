#include "basgraph.hpp"

//���캯��
Location::Location(int x,int y)
{ X_pos=x;
  Y_pos=y;
}

void Location::get_x()
{return X_pos;  }

void Location::get_y()
{ return Y_pos;  }
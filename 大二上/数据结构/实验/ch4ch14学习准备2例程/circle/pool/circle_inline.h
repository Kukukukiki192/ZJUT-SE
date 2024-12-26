//circle_inline.h
const float PI=3.14159;
class circle
{ 
public: 
     //构造函数
     circle(float r):radius(r) 
     {  }  //初始化半径
     //成员函数
     float circumference() const
     { return   2*PI*radius;     } //计算圆周长
     float area() const
     { return   PI*radius *radius;     } //计算圆半径
private:
    //数据成员
    float radius; //半径
};  //implemention of circle class with  inline code

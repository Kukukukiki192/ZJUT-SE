//circle.h
class circle
{ 
public: 
     //构造函数
     circle(float r); //初始化半径
     //成员函数
     float circumference() const;//计算圆周长
     float area() const; //计算圆半径
private:
    //数据成员
    float radius; //半径
};  // declaration of circle class

//circle_inline.h
const float PI=3.14159;
class circle
{ 
public: 
     //���캯��
     circle(float r):radius(r) 
     {  }  //��ʼ���뾶
     //��Ա����
     float circumference() const
     { return   2*PI*radius;     } //����Բ�ܳ�
     float area() const
     { return   PI*radius *radius;     } //����Բ�뾶
private:
    //���ݳ�Ա
    float radius; //�뾶
};  //implemention of circle class with  inline code

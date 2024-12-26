package com.company;
import static java.lang.Math.PI;
import java.util.Scanner;
abstract class GeometricObject{
    GeometricObject(){}
    public abstract double getArea();
}
class Circle extends GeometricObject{
    private double radius;
    Circle(double r){super(); radius=r;}
    public double getArea(){return PI*radius*radius;}
    public void set(double r){radius=r; }
}
class Rectangle extends GeometricObject{
    private double width;
    private double height;
    Rectangle(double w, double h) {
        super();
        width = w;
        height = h;
    }
    public double getArea() {
        return width * height;
    }
    public void set(double w,double h){
        width = w;
        height = h;
    }
}
public class Main {
    public static void main(String[] args) {
        Circle c=new Circle(0.0);
        Rectangle r=new Rectangle(0.0,0.0);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            char a=in.next().charAt(0);
            if(a=='c'){
                float x=in.nextFloat();
                c.set(x);
                String s=String.format("%.2f",c.getArea());
                System.out.println(s);
            }
            else if(a=='r'){
                float x1=in.nextFloat(),x2=in.nextFloat();
                r.set(x1,x2);
                String s=String.format("%.2f",r.getArea());
                System.out.println(s);
            }
        }

    }
}

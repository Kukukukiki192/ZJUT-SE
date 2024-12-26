package cn.edu.zjut.java.ch03;

public class Triangle  
{
      double length=10.0;
      double height=5.0;
      
      double area() throws Exception
      {
            return length*height/2.0;
      }
      
      public static void f(){
    	  
      }
      
      public static void main (String args[]) throws Exception
      {
    	  
           double s;
           
           Triangle t = new Triangle();
           s=t.area();
           System.out.println("该三角形的面积是: " + s);
           
           
           
           
      }
}

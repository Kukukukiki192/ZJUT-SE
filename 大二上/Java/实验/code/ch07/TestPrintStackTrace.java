package cn.edu.zjut.java.ch07;

public class TestPrintStackTrace {

    public static void g() throws Exception{
        throw new Exception("≥ˆŒ Ã‚¿≤£°");
    }
    
    public static void f() throws Exception{
        g();
    }
    
    public static void main(String[] args) {
        try {
            f();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

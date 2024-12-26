package com.model;
public class Converter{
    private double celcius;
    private double fahrenheit;
    public double getCelcius(){
       return (fahrenheit - 32) * 5 / 9;
    }
    public void setCelcius(double celcius){
       this.celcius = celcius;
    }
    public double getFahrenheit(){
       return celcius * 9 / 5 + 32;
    }
    public void setFahrenheit(double fahrenheit){
       this.fahrenheit = fahrenheit;
    }
}


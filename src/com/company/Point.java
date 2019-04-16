package com.company;

public class Point {
    double x;
    double y;
    public Point(double tx, double ty){
        System.out.println("costruisco il punto P("+tx+"," +ty+")");
        x=tx;
        y=ty;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public boolean isEqual(Point p){
        return x==p.getX() && y==p.getY();
    }
}

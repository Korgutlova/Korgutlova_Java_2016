package com.korgutlova;

public class Vector2D {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ", " + y + "}";
    }

    public Vector2D add(Vector2D v){
        return new Vector2D(this.x + v.getX(), this.y + v.getY());
    }

    public Vector2D mult(double k){
        return new Vector2D(this.x * k, this.y * k);
    }

    public boolean equals(Vector2D v){
        return (this.x == v.getX()) && (this.y == v.getY());
    }

    public double length(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double scalarMultiplication(Vector2D v){
        return this.x * v.getX() + this.y * v.getY();
    }
}

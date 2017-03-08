/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java;

/**
 *
 * @author dasg
 */
public class Vector {

    private int d;               // dimension of the vector
    private double[] data;       // array of vector's components

    /**
     * Initializes a d-dimensional zero vector.
     *
     * @param d the dimension of the vector
     */
    public Vector(int d) {
        this.d = d;
        data = new double[d];
    }

    public Vector(double... a) {
        d = a.length;
        data = new double[d];
        for (int i = 0; i < d; i++) {
            data[i] = a[i];
        }
    }

    public int dimension() {
        return d;
    }

    public double dotProduct(Vector that) {
        if (this.d != that.d) {
            throw new IllegalArgumentException("Dimensions don't agree");
        }
        double sum = 0.0;
        for (int i = 0; i < d; i++) {
            sum = sum + (this.data[i] * that.data[i]);
        }
        return sum;
    }

    public double magnitude() {
        return Math.sqrt(this.dotProduct(this));
    }

    public double distanceTo(Vector that) {
        if (this.d != that.d) {
            throw new IllegalArgumentException("Dimensions don't agree");
        }
        return this.minus(that).magnitude();
    }

    public Vector plus(Vector that) {
        if (this.d != that.d) {
            throw new IllegalArgumentException("Dimensions don't agree");
        }
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++) {
            c.data[i] = this.data[i] + that.data[i];
        }
        return c;
    }

    public Vector minus(Vector that) {
        if (this.d != that.d) {
            throw new IllegalArgumentException("Dimensions don't agree");
        }
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++) {
            c.data[i] = this.data[i] - that.data[i];
        }
        return c;
    }

    public double cartesian(int i) {
        return data[i];
    }

    public Vector times(double alpha) {
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++) {
            c.data[i] = alpha * data[i];
        }
        return c;
    }

    public Vector scale(double alpha) {
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++) {
            c.data[i] = alpha * data[i];
        }
        return c;
    }

    public Vector direction() {
        if (this.magnitude() == 0.0) {
            throw new ArithmeticException("Zero-vector has no direction");
        }
        return this.times(1.0 / this.magnitude());
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < d; i++) {
            s.append(data[i] + " ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        double[] xdata = {1.0, 2.0, 3.0, 4.0};
        double[] ydata = {5.0, 2.0, 4.0, 1.0};
        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        System.out.println("   x       = " + x);
        System.out.println("   y       = " + y);

        Vector z = x.plus(y);
        System.out.println("   z       = " + z);

        z = z.times(10.0);
        System.out.println(" 10z       = " + z);

        System.out.println(" |x|      = " + x.magnitude());
        System.out.println(" <x, y>    = " + x.dotProduct(y));
        System.out.println(" dist(x, y) = " + x.distanceTo(y));
        System.out.println(" direction(x)     = " + x.direction());

    }
}

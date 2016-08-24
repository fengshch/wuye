package cn.southstone.wuye.server.cal;

/**
 * Created by fengs on 2016/8/23.
 */
public class Foo {
    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double sum() {
        return a+b;
    }

    public double sum1(double a, double b) {
        return a*b;
    }
}

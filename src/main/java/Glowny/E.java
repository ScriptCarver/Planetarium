package Glowny;

public class E implements Funkcja{

    private double M;
    private double e;

    public E(double m, double e) {
        M = m;
        this.e = e;
    }

    @Override
    public double policz(double x) {
        return M-e*Math.sin(x)-x;
    }
}

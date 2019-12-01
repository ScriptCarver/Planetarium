package Glowny;

public class NewtonRapson implements Iteracja {

    private double dokl;
    private Funkcja f;
    private double xrnew;

    public NewtonRapson(double dokl, Funkcja f) {
        this.dokl = dokl;
        this.f = f;
    }

    public double iteruj(){
        double xrold=0;
        double obdokla=1;
        double xl = 0;
        while(obdokla>dokl) {
            xrnew =xl - (f.policz(xl)/(-Math.exp(-xl)-1));
            obdokla = Math.abs((xrnew - xrold) / xrnew);
            xrold=xrnew;
            xl = xrnew;
        }
        return xrnew;
    }
}

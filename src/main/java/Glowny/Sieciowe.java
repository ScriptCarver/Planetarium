package Glowny;

public class Sieciowe implements Iteracja {

    private double dokl;
    private Funkcja f;
    private double xrnew;

    public Sieciowe(double dokl, Funkcja f) {
        this.dokl = dokl;
        this.f = f;
    }

    public double iteruj(){
        double xrold=0;
        double obdokla=1;
        double xl=0;
        double xl2 = -Math.PI/20;
        while(obdokla>dokl) {
            xrnew =xl - ((f.policz(xl)*(xl2-xl))/(f.policz(xl2)-f.policz(xl)));
            obdokla = Math.abs((xrnew - xrold) / xrnew);
            xrold=xrnew;
            xl2 = xl;
            xl = xrnew;
        }
        return xrnew;
    }
}

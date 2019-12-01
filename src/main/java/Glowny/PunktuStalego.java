package Glowny;

public class PunktuStalego implements Iteracja {

    private double dokl;
    private Funkcja f;
    private double xrnew;

    public PunktuStalego(double dokl, Funkcja f) {
        this.dokl = dokl;
        this.f = f;
    }

    public double iteruj(){
        double xrold=0;
        double obdokla=1;
        double xl=0;
        while(obdokla>dokl) {
            xrnew = f.policz(xl)+xl;
            obdokla = Math.abs((xrnew - xrold) / xrnew);
            xrold=xrnew;
            xl = xrnew;
        }
        return xrnew;
    }
}

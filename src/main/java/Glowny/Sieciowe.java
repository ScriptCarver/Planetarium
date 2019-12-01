package Glowny;

public class Sieciowe implements Iteracja {

    private String name = "Secznych";
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
        int licznik=1;
        double xl=0;
        double xl2 = -Math.PI/20;
        double xu = 2*Math.PI;
        while(obdokla>dokl) {
            xrnew =xl - ((f.Policz(xl)*(xl2-xl))/(f.Policz(xl2)-f.Policz(xl)));
            obdokla = Math.abs((xrnew - xrold) / xrnew);
            xrold=xrnew;
            xl2 = xl;
            xl = xrnew;
            licznik++;
        }
        return xrnew;
    }

    @Override
    public String getname() {
        return name;
    }
}

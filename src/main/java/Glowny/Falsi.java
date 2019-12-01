package Glowny;

public class Falsi implements Iteracja{
    private double dokl;
    private Funkcja f;
    private double xrnew;

    public Falsi(double dokl, Funkcja f) {
        this.dokl = dokl;
        this.f = f;
    }

    public double iteruj(){
        double xrold=0;
        double obdokla=1;
        double xl=0;
        double xu = 2*Math.PI;
        while(obdokla>dokl) {
            xrnew = xu-((f.policz(xu)*(xl-xu))/(f.policz(xl)-f.policz(xu)));
            obdokla = Math.abs((xrnew - xrold) / xrnew);
            if ((f.policz(xl) * f.policz(xrnew)) == 0) {
                obdokla = 0;
            } else if ((f.policz(xl) * f.policz(xrnew)) < 0) {
                xu = xrnew;
            } else if ((f.policz(xl) * f.policz(xrnew)) > 0) {
                xl = xrnew;
            }
            xrold=xrnew;
        }
        return xrnew;
    }
}

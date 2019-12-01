package Glowny;

public class Falsi implements Iteracja{
    String name = "Falsi";
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
        int licznik=1;
        double xl=0;
        double xu = 2*Math.PI;
        while(obdokla>dokl) {
            xrnew = xu-((f.Policz(xu)*(xl-xu))/(f.Policz(xl)-f.Policz(xu)));
            obdokla = Math.abs((xrnew - xrold) / xrnew);
            if ((f.Policz(xl) * f.Policz(xrnew)) == 0) {
                obdokla = 0;
            } else if ((f.Policz(xl) * f.Policz(xrnew)) < 0) {
                xu = xrnew;
            } else if ((f.Policz(xl) * f.Policz(xrnew)) > 0) {
                xl = xrnew;
            }
            xrold=xrnew;
            licznik++;
        }
        return xrnew;
    }

    @Override
    public String getname() {
        return name;
    }
}

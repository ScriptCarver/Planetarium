package Glowny;

public class NewtonRapson implements Iteracja {

    private String name = "Newton Rapson";
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
        int licznik=1;
        double xl = 0;
        double xu = 2*Math.PI;
        while(obdokla>dokl) {
            xrnew =xl - (f.Policz(xl)/(-Math.exp(-xl)-1));
            obdokla = Math.abs((xrnew - xrold) / xrnew);
            xrold=xrnew;
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

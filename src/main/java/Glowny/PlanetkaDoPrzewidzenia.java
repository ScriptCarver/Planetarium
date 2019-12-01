package Glowny;

import javafx.scene.chart.XYChart;

public class PlanetkaDoPrzewidzenia {

    private String nazwa;
    private double a;
    private double e;
    private String metoda;
    private double Ea;
    private XYChart.Series Wykresik;
    private String nazwawykresu;

    public PlanetkaDoPrzewidzenia(String nazwa, double a, double e, String metoda, double ea) {
        this.nazwa = nazwa;
        this.a = a;
        this.e = e;
        this.metoda = metoda;
        Ea = ea;
        nazwawykresu = nazwa + " - " + metoda;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getA() {
        return a;
    }

    public double getE() {
        return e;
    }

    public String getMetoda() {
        return metoda;
    }

    public double getEa() {
        return Ea;
    }

    public void wypelnijWykresik(){
        int T = 1000;
        double M;
        double E;
        Wykresik = new XYChart.Series<Number,Number>();
        Wykresik.setName(nazwawykresu);
        for(int i=0;i<T;i++){
            M=policzM(T,i);
            E = policzE(M);
            double x = (a*Math.cos(E-e));
            double y = (a*Math.sqrt(1-Math.pow(e,2))*Math.sin(E));
            Wykresik.getData().add(new XYChart.Data(x,y));
        }
    }

    private double policzM(int T, int t){
        return (2*Math.PI/T)*(t);
    }

    private double policzE(double M){
        Iteracja iteracja;
        if(metoda == "Bieskcja"){
            iteracja = new Bisekcjonowanie(Ea,new E(M, e));
        } else if (metoda == "Falsi"){
            iteracja = new Falsi(Ea,new E(M, e));
        } else if(metoda == "Newtona Rapsona"){
            iteracja = new NewtonRapson(Ea,new E(M, e));
        } else if(metoda=="Punktu Stalego"){
            iteracja = new PunktuStalego(Ea,new E(M, e));
        } else {
            iteracja = new Sieciowe(Ea,new E(M, e));
        }
        return iteracja.iteruj();
    }

    public XYChart.Series getWykresik() {
        return Wykresik;
    }
}

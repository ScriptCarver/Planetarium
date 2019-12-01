package Glowny;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class KontrolerOknaZWykresem {

    private ArrayList<PlanetkaDoPrzewidzenia> PlanetyDoPrzewidzenia = new ArrayList<>();

    @FXML
    private ScatterChart<Number,Number> Wykresik;

    @FXML
    private NumberAxis xos;

    @FXML
    private NumberAxis yos;

    @FXML
    private Button ZapisButton;

    @FXML
    void Zapis(ActionEvent event) throws IOException {
        ArrayList<String> DoDruku = new ArrayList<>();
        int i = Wykresik.getData().size();
        String nazwy= "";
        String osie = "";
        for(int d=0;d<i;d++){
            nazwy += Wykresik.getData().get(d).getName() + ", ,";
            osie += "x,y,";
        }
        nazwy = nazwy.substring(0,nazwy.length()-1);
        osie = osie.substring(0,osie.length()-1);
        DoDruku.add(nazwy);
        DoDruku.add(osie);

        for (int j = 0; j < Wykresik.getData().get(0).getData().size(); j++) {
            osie = "";
        for(int d=0;d<i;d++) {
            osie += Wykresik.getData().get(d).getData().get(j).getXValue() +","+Wykresik.getData().get(d).getData().get(j).getYValue()+",";
            }
        osie = osie.substring(0,osie.length()-1);
        DoDruku.add(osie);
        }

        FXMLLoader loader = new FXMLLoader();
        URL fxmlUrl = getClass().getClassLoader().getResource("fxml/OknoZapisu.fxml");
        loader.setLocation(fxmlUrl);
        loader.load();
        KontrolerOknaZapisu controller = loader.getController();
        controller.setWartosci(DoDruku, Wykresik);
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        Stage stage3 = new Stage();
        stage3.setScene(scene);
        stage3.setTitle("Zapisz");
        stage3.show();
    }

    public void setPlanetyDoPrzewidzenia(ArrayList<PlanetkaDoPrzewidzenia> planetyDoPrzewidzenia) {
        PlanetyDoPrzewidzenia = planetyDoPrzewidzenia;
        xos.setLabel("x [jednostki astronomiczne]");
        yos.setLabel("y [jednostki astronomiczne]");
        for(PlanetkaDoPrzewidzenia p :PlanetyDoPrzewidzenia){
            Wykresik.getData().add(p.getWykresik());
        }
    }
}

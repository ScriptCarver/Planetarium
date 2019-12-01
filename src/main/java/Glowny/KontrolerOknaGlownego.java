package Glowny;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class KontrolerOknaGlownego  {

    private ObservableList<String> sposoby =  FXCollections
            .observableArrayList("Bisekcja","Falsi","Newton Rapson","Punktu Stalego","Siecznych");

    private ArrayList<double[]> planetyUkladuSlonecznego;

    private ArrayList<PlanetkaDoPrzewidzenia> PlanetyDoPrzewidzenia = new ArrayList<>();

    @FXML
    private TextField Customa;

    @FXML
    private TextField Custome;

    @FXML
    private TextField CustomName;

    @FXML
    private ChoiceBox<String> MercuryChoice;

    @FXML
    private ChoiceBox<String> WenusChoice;

    @FXML
    private ChoiceBox<String> ZiemiaChoice;

    @FXML
    private ChoiceBox<String> MarsChoice;

    @FXML
    private ChoiceBox<String> JowiszChoice;

    @FXML
    private ChoiceBox<String> SaturnChoice;

    @FXML
    private ChoiceBox<String> UranChoice;

    @FXML
    private ChoiceBox<String> NeptunChoice;

    @FXML
    private ChoiceBox<String> PlutonChoice;

    @FXML
    private ChoiceBox<String> CustomChoice;


    @FXML
    private Button MercuryAdd;

    @FXML
    private Button WenusAdd;

    @FXML
    private Button ZiemiaAdd;

    @FXML
    private Button MarsAdd;

    @FXML
    private Button JowiszAdd;

    @FXML
    private Button SaturnAdd;

    @FXML
    private Button UranAdd;

    @FXML
    private Button NeptunAdd;

    @FXML
    private Button PlatunAdd;

    @FXML
    private Button CustomAdd;

    @FXML
    private Button Draw;

    @FXML
    private Button DeleteAll;

    @FXML
    private Button DeleteLastButton;

    @FXML
    private TextField EaMerkury;

    @FXML
    private TextField EaWenus;

    @FXML
    private TextField EaZiemia;

    @FXML
    private TextField EaMars;

    @FXML
    private TextField EaJowisz;

    @FXML
    private TextField EaSaturn;

    @FXML
    private TextField EaUran;

    @FXML
    private TextField EaNeptun;

    @FXML
    private TextField EaPluton;

    @FXML
    private TextField EaCustom;


    @FXML
    void DodajCustom(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia(CustomName.getText(),Double.valueOf(Customa.getText()),Double.valueOf(Custome.getText()),CustomChoice.getValue(),Double.valueOf(EaCustom.getText())));
    }

    @FXML
    void DodajJowisz(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Jowisz", planetyUkladuSlonecznego.get(4)[0],planetyUkladuSlonecznego.get(4)[1], JowiszChoice.getValue(),Double.valueOf(EaJowisz.getText())));
    }

    @FXML
    void DodajMars(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Mars", planetyUkladuSlonecznego.get(3)[0],planetyUkladuSlonecznego.get(3)[1],MarsChoice.getValue(),Double.valueOf(EaMars.getText())));
    }

    @FXML
    void DodajMercury(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Merkury", planetyUkladuSlonecznego.get(0)[0],planetyUkladuSlonecznego.get(0)[1],MercuryChoice.getValue(),Double.valueOf(EaMerkury.getText())));
    }

    @FXML
    void DodajNeptun(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Neptun", planetyUkladuSlonecznego.get(7)[0],planetyUkladuSlonecznego.get(7)[1],NeptunChoice.getValue(),Double.valueOf(EaNeptun.getText())));
    }

    @FXML
    void DodajPluton(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Pluton", planetyUkladuSlonecznego.get(8)[0],planetyUkladuSlonecznego.get(8)[1],PlutonChoice.getValue(),Double.valueOf(EaPluton.getText())));
    }

    @FXML
    void DodajSaturn(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Saturn", planetyUkladuSlonecznego.get(5)[0],planetyUkladuSlonecznego.get(5)[1],SaturnChoice.getValue(),Double.valueOf(EaSaturn.getText())));
    }

    @FXML
    void DodajUran(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Uran", planetyUkladuSlonecznego.get(6)[0],planetyUkladuSlonecznego.get(6)[1],UranChoice.getValue(),Double.valueOf(EaUran.getText())));
    }

    @FXML
    void DodajWenus(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Wenus", planetyUkladuSlonecznego.get(1)[0],planetyUkladuSlonecznego.get(1)[1],WenusChoice.getValue(),Double.valueOf(EaWenus.getText())));
    }

    @FXML
    void DodajZiemia(ActionEvent event) {
    PlanetyDoPrzewidzenia.add(new PlanetkaDoPrzewidzenia("Ziemia", planetyUkladuSlonecznego.get(2)[0],planetyUkladuSlonecznego.get(2)[1],ZiemiaChoice.getValue(),Double.valueOf(EaZiemia.getText())));
    }

    @FXML
    void Rysuj(ActionEvent event) throws IOException {
        prepToDraw();
        FXMLLoader loader = new FXMLLoader();
        URL fxmlUrl = getClass().getClassLoader().getResource("fxml/OknoZWykresem.fxml");
        loader.setLocation(fxmlUrl);
        loader.load();
        KontrolerOknaZWykresem controller = loader.getController();
        controller.setPlanetyDoPrzewidzenia(PlanetyDoPrzewidzenia);
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setTitle("Okno Trajektorii");
        stage2.show();
    }

    @FXML
    void UsunWszystkie(ActionEvent event) {
        PlanetyDoPrzewidzenia.clear();
    }

    @FXML
    void usunOstatnie(ActionEvent event) {
        PlanetyDoPrzewidzenia.remove(PlanetyDoPrzewidzenia.size()-1);
    }

    private void prepToDraw(){
        for(PlanetkaDoPrzewidzenia p : PlanetyDoPrzewidzenia){
            p.wypelnijWykresik();
        }
    }


    public void initialize(){
        planetyUkladuSlonecznego = new ArrayList<double[]>();
        planetyUkladuSlonecznego.add(new double[]{0.387, 0.2056});
        planetyUkladuSlonecznego.add(new double[]{0.723, 0.0068});
        planetyUkladuSlonecznego.add(new double[]{1, 0.0167});
        planetyUkladuSlonecznego.add(new double[]{1.524, 0.0934});
        planetyUkladuSlonecznego.add(new double[]{5.203, 0.0484});
        planetyUkladuSlonecznego.add(new double[]{9.537, 0.0542});
        planetyUkladuSlonecznego.add(new double[]{19.191, 0.0472});
        planetyUkladuSlonecznego.add(new double[]{30.067, 0.0086});
        planetyUkladuSlonecznego.add(new double[]{39.482, 0.2488});
        MercuryChoice.setItems(sposoby);
        WenusChoice.setItems(sposoby);
        ZiemiaChoice.setItems(sposoby);
        MarsChoice.setItems(sposoby);
        JowiszChoice.setItems(sposoby);
        SaturnChoice.setItems(sposoby);
        UranChoice.setItems(sposoby);
        NeptunChoice.setItems(sposoby);
        PlutonChoice.setItems(sposoby);
        CustomChoice.setItems(sposoby);
        MercuryChoice.setValue("Bisekcja");
        WenusChoice.setValue("Bisekcja");
        ZiemiaChoice.setValue("Bisekcja");
        MarsChoice.setValue("Bisekcja");
        JowiszChoice.setValue("Bisekcja");
        SaturnChoice.setValue("Bisekcja");
        UranChoice.setValue("Bisekcja");
        NeptunChoice.setValue("Bisekcja");
        PlutonChoice.setValue("Bisekcja");
        CustomChoice.setValue("Bisekcja");
    }
}

package Glowny;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class KontrolerOknaZapisu {

    ArrayList<String> DoDruku;

    @FXML
    private TextField NazwaPliku;

    @FXML
    private Button ZapisButton;

    @FXML
    void Zapisz(ActionEvent event) {

        File pliku = new File(NazwaPliku.getText()+".csv");
        try {
            FileWriter zapiscsv = new FileWriter(pliku);
            for (String s : DoDruku){
                zapiscsv.append(s);
                System.out.println(s);
                zapiscsv.append("\n");
            }
            zapiscsv.close();

            Stage stage = (Stage) ZapisButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex){

        }

    }

    public void setWartosci(ArrayList<String> DoDruku){
        this.DoDruku = DoDruku;
    }
}

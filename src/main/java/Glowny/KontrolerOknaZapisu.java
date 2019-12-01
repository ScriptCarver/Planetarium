package Glowny;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KontrolerOknaZapisu {

    ArrayList<String> DoDruku;
    ScatterChart Wykres;

    @FXML
    private TextField NazwaPliku;

    @FXML
    private Button ZapisButton;

    @FXML
    void Zapisz(ActionEvent event) {
    if(!NazwaPliku.getText().trim().isEmpty()) {
        File pliku = new File(NazwaPliku.getText() + ".csv");
        try {
            FileWriter zapiscsv = new FileWriter(pliku);
            for (String s : DoDruku) {
                zapiscsv.append(s);
                zapiscsv.append("\n");
            }
            zapiscsv.close();

            Stage stage = (Stage) ZapisButton.getScene().getWindow();
            stage.close();

            WritableImage image = Wykres.snapshot(new SnapshotParameters(), null);
            File plikuu = new File(NazwaPliku.getText() + ".png");

            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", plikuu);
        } catch (IOException e) {

        }
    }
    else {
        NazwaPliku.setText("WpiszNazwe");
    }
    }

    public void setWartosci(ArrayList<String> DoDruku, ScatterChart Wykres){
        this.DoDruku = DoDruku;
        this.Wykres = Wykres;
    }
}

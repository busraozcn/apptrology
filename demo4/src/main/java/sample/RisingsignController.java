package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalTime;

public class RisingsignController {
    @FXML
    private CalculatorController calculatorController;

    @FXML
    private Label risingsignLabel;
    @FXML
    private Label risingsignSymbolLabel;
    @FXML
    private Button cancelButton3;
    @FXML
    private Button backButton2;
    @FXML
    private Label risingsignCharacteristics;
    public void setCalculatorController(CalculatorController calculatorController) { //bu metodla calculator controller sınıfına erişiyoruz
        this.calculatorController = calculatorController;
        calculateAndSetRisingSign();
    }

    private void calculateAndSetRisingSign() {
        String hourValue = calculatorController.getHourComboBox().getValue();
        String minuteValue = calculatorController.getMinuteComboBox().getValue();
//calculatorcontroller sınıfındaki comboboxlaraki verileri alıyoruz

            LocalTime selectedTime = LocalTime.of(
                    Integer.parseInt(hourValue),
                    Integer.parseInt(minuteValue)
            );

            // Yükselen burç hesaplama işlemleri
            String risingSign = calculateRisingSign(selectedTime); //metodu çağırıp hesaplama yapıyor

            risingsignLabel.setText(risingSign);
        // Burç özelliklerini hesapla ve set et
        calculateAndSetRisingsignCharacteristics(risingSign);
        risingsignSymbol(risingSign);
    }

    private String calculateRisingSign(LocalTime selectedTime) {
        String[] signs = {"Koç", "Boğa", "İkizler", "Yengeç", "Aslan", "Başak", "Terazi", "Akrep", "Yay", "Oğlak", "Kova", "Balık"};

        // Seçilen saate göre yükselen burcu hesapla
        int index = (selectedTime.getHour() + 1) / 2 % 12; //kendi uydurduğumuz yükselen burç hesaplama yöntemi

        return signs[index];
    }

    @FXML
    public void cancelButtonOnAction3(ActionEvent e) {
        Stage stage = (Stage) cancelButton3.getScene().getWindow();
        stage.close();
    }
    private void calculateAndSetRisingsignCharacteristics(String risingSign) {
        String characteristics = "";

        if ("Koç".equals(risingSign)) {
            characteristics = "Elementi: Ateş\n" +
                    "Niteliği: Öncü\n" +
                    "Gezegeni: Mars\n" +
                    "Rengi: Kırmızı\n" +
                    "Taşı: Elmas\n" +
                    "Günü: Salı\n\n" +
                    "Koç burcu özellikleri: Cesur, enerjik,\n" +
                    " lider, bağımsız kişilerdir.";
        } else if ("Boğa".equals(risingSign)) {
            characteristics = "Elementi: Toprak\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Venüs\n" +
                    "Rengi: Yeşil\n" +
                    "Taşı: Zümrüt\n" +
                    "Günü: Cuma\n\n" +
                    "Boğa burcu özellikleri: Sabırlı, kararlı,\n" +
                    " güvenilir, pratik kişilerdir.";
        } else if ("İkizler".equals(risingSign)) {
            characteristics = "Elementi: Hava\n" +
                    "Niteliği: Değişken\n" +
                    "Gezegeni: Merkür\n" +
                    "Rengi: Sarı\n" +
                    "Taşı: Akik\n" +
                    "Günü: Çarşamba\n\n" +
                    "İkizler burcu özellikleri: İletişimci,\n" +
                    " zeki, esnek, meraklı kişilerdir.";
        } else if ("Yengeç".equals(risingSign)) {
            characteristics = "Elementi: Su\n" +
                    "Niteliği: Öncü\n" +
                    "Gezegeni: Ay\n" +
                    "Rengi: Gümüş\n" +
                    "Taşı: Aytaşı\n" +
                    "Günü: Pazartesi\n\n" +
                    "Yengeç burcu özellikleri: Duygusal,\n" +
                    "koruyucu, nazik, sezgisel kişilerdir.";
        } else if ("Aslan".equals(risingSign)) {
            characteristics = "Elementi: Ateş\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Güneş\n" +
                    "Rengi: Altın\n" +
                    "Taşı: Sitrin\n" +
                    "Günü: Pazar\n\n" +
                    "Aslan burcu özellikleri: Gururlu, \n" +
                    "cömert, neşeli, lider kişilerdir.";
        } else if ("Başak".equals(risingSign)) {
            characteristics = "Elementi: Toprak\n" +
                    "Niteliği: Değişken\n" +
                    "Gezegeni: Merkür\n" +
                    "Rengi: Kahverengi\n" +
                    "Taşı: Safir\n" +
                    "Günü: Çarşamba\n\n" +
                    "Başak burcu özellikleri: Titiz, analitik, \n" +
                    "düzenli, yardımsever kişilerdir.";
        } else if ("Terazi".equals(risingSign)) {
            characteristics = "Elementi: Hava\n" +
                    "Niteliği: Öncü\n" +
                    "Gezegeni: Venüs\n" +
                    "Rengi: Mavi\n" +
                    "Taşı: Opal\n" +
                    "Günü: Cuma\n\n" +
                    "Terazi burcu özellikleri: Adil, diplomatik, \n" +
                    "sosyal, zarif kişilerdir.";
        } else if ("Akrep".equals(risingSign)) {
            characteristics = "Elementi: Su\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Mars\n" +
                    "Rengi: Bordo\n" +
                    "Taşı: Opal\n" +
                    "Günü: Salı\n\n" +
                    "Akrep burcu özellikleri: Mücadeleci, güçlü, \n" +
                    "yılmaz, hırslı kişilerdir.";
        } else if ("Yay".equals(risingSign)) {
            characteristics = "Elementi: Ateş\n" +
                    "Niteliği: Değişken\n" +
                    "Gezegeni: Jüpiter\n" +
                    "Rengi: Mor\n" +
                    "Taşı: Turkuaz\n" +
                    "Günü: Perşembe\n\n" +
                    "Yay burcu özellikleri: Neşeli, özgürlük seven, \n" +
                    "iyimser, maceraperest kişilerdir.";
        } else if ("Oğlak".equals(risingSign)) {
            characteristics = "Elementi: Toprak\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Satürn\n" +
                    "Rengi: Kahverengi\n" +
                    "Taşı: Akik\n" +
                    "Günü: Cumartesi\n\n" +
                    "Oğlak burcu özellikleri: Disiplinli, ciddi, \n" +
                    "sorumluluk sahibi, hırslı kişilerdir.";
        } else if ("Kova".equals(risingSign)) {
            characteristics = "Elementi: Hava\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Uranüs\n" +
                    "Rengi: Turuncu\n" +
                    "Taşı: Ametist\n" +
                    "Günü: Cumartesi\n\n" +
                    "Kova burcu özellikleri: Yaratıcı, bağımsız,\n" +
                    " özgün, ileri görüşlü kişilerdir.";
        } else if ("Balık".equals(risingSign)) {
            characteristics = "Elementi: Su\n" +
                    "Niteliği: Değişken\n" +
                    "Gezegeni: Neptün\n" +
                    "Rengi: Deniz mavisi\n" +
                    "Taşı: Aytaşı\n" +
                    "Günü: Perşembe\n\n" +
                    "Balık burcu özellikleri: Duyarlı, içsel,\n" +
                    " sanatsal, anlayışlı kişilerdir.";
        }
        // Set the characteristics to sunsignCharacteristics label
        risingsignCharacteristics.setText(characteristics);
    }
    private void risingsignSymbol(String risingSign) {
        String symbol = "";
        if ("Koç".equals(risingSign)) {
            symbol = "♈";
        } else if ("Boğa".equals(risingSign)) {
            symbol = "♉";
        }
        else if ("İkizler".equals(risingSign)) {
            symbol = "♊";
        } else if ("Yengeç".equals(risingSign)) {
            symbol = "♋";
        } else if ("Aslan".equals(risingSign)) {
            symbol = "♌";
        } else if ("Başak".equals(risingSign)) {
            symbol = "♍";
        } else if ("Terazi".equals(risingSign)) {
            symbol = "♎";
        } else if ("Akrep".equals(risingSign)) {
            symbol = "♏";
        } else if ("Yay".equals(risingSign)) {
            symbol = "♐";
        } else if ("Oğlak".equals(risingSign)) {
            symbol = "♑";
        } else if ("Kova".equals(risingSign)) {
            symbol = "♒";
        } else if ("Balık".equals(risingSign)) {
            symbol = "♓";
        }
        risingsignSymbolLabel.setText(symbol);
    }
    @FXML
    private void initialize1() {

        backButton2.setOnAction(event -> {
            // İlgili FXML dosyasını yükleyerek yeni bir sahne oluştur
            loadScene();
        });
    }
    @FXML
    private void loadScene() {
        try {
            // İlgili FXML dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("calculator.fxml"));
            Parent root = loader.load();

            // Yeni bir sahne oluştur
            Scene scene = new Scene(root);

            // Mevcut pencereyi al
            Stage stage = (Stage) backButton2.getScene().getWindow();

            // Yeni sahneyi mevcut pencereye ayarla
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}

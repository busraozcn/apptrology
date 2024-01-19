package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class SunsignController {

    @FXML
    private Label sunsignLabel;
    @FXML
    private Label sunsignSymbolLabel;
    @FXML
    private Button backButton1;
    @FXML
    private Button cancelButton2;
    @FXML
    private CalculatorController calculatorController;
    @FXML
    private Label sunsignCharacteristics;

    public void setCalculatorController(CalculatorController calculatorController) { //bu metodla calculatorController sınıfına erişiyoruz
        this.calculatorController = calculatorController;
        calculateAndSetSunsign();
    }

    @FXML
    public void cancelButtonOnAction2() {
        Stage stage = (Stage) cancelButton2.getScene().getWindow();
        stage.close();
    }

    private void calculateAndSetSunsign() {
        LocalDate selectedDate = calculatorController.getDatePicker().getValue();
        int day = selectedDate.getDayOfMonth();
        int month = selectedDate.getMonthValue();

        // Burç hesaplama işlemleri
        String sunsign = calculateSunsign(day, month); //metodu çağır

        // Sonucu sunsignLabel'a yaz
        sunsignLabel.setText(sunsign);

        // Burç özelliklerini hesapla ve set et
        calculateAndSetSunsignCharacteristics(sunsign);
        sunsignSymbol(sunsign);
    }

    private String calculateSunsign(int day, int month) { //burç hesabı yapan metod
        String sunsign = "";

        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            sunsign = "Koç";
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            sunsign = "Boğa";
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
            sunsign = "İkizler";
        } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
            sunsign = "Yengeç";
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            sunsign = "Aslan";
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            sunsign = "Başak";
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            sunsign = "Terazi";
        } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
            sunsign = "Akrep";
        } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            sunsign = "Yay";
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            sunsign = "Oğlak";
        } else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            sunsign = "Kova";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            sunsign = "Balık";
        }

        return sunsign;
    }

    private void calculateAndSetSunsignCharacteristics(String sunsign) {
        String characteristics = "";

        if ("Koç".equals(sunsign)) {
            characteristics = "Elementi: Ateş\n" +
                    "Niteliği: Öncü\n" +
                    "Gezegeni: Mars\n" +
                    "Rengi: Kırmızı\n" +
                    "Taşı: Elmas\n" +
                    "Günü: Salı\n\n" +
                    "Koç burcu özellikleri: Cesur, \n" +
                    "enerjik, lider, bağımsız kişilerdir.";
        } else if ("Boğa".equals(sunsign)) {
            characteristics = "Elementi: Toprak\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Venüs\n" +
                    "Rengi: Yeşil\n" +
                    "Taşı: Zümrüt\n" +
                    "Günü: Cuma\n\n" +
                    "Boğa burcu özellikleri: Sabırlı, \n" +
                    "kararlı, güvenilir, pratik kişilerdir.";
        } else if ("İkizler".equals(sunsign)) {
            characteristics = "Elementi: Hava\n" +
                    "Niteliği: Değişken\n" +
                    "Gezegeni: Merkür\n" +
                    "Rengi: Sarı\n" +
                    "Taşı: Akik\n" +
                    "Günü: Çarşamba\n\n" +
                    "İkizler burcu özellikleri: İletişimci,\n" +
                    " zeki, esnek, meraklı kişilerdir.";
        } else if ("Yengeç".equals(sunsign)) {
            characteristics = "Elementi: Su\n" +
                    "Niteliği: Öncü\n" +
                    "Gezegeni: Ay\n" +
                    "Rengi: Gümüş\n" +
                    "Taşı: Aytaşı\n" +
                    "Günü: Pazartesi\n\n" +
                    "Yengeç burcu özellikleri: Duygusal,\n" +
                    " koruyucu, nazik, sezgisel kişilerdir.";
        } else if ("Aslan".equals(sunsign)) {
            characteristics = "Elementi: Ateş\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Güneş\n" +
                    "Rengi: Altın\n" +
                    "Taşı: Sitrin\n" +
                    "Günü: Pazar\n\n" +
                    "Aslan burcu özellikleri: Gururlu, \n" +
                    "cömert, neşeli, lider kişilerdir.";
        } else if ("Başak".equals(sunsign)) {
            characteristics = "Elementi: Toprak\n" +
                    "Niteliği: Değişken\n" +
                    "Gezegeni: Merkür\n" +
                    "Rengi: Kahverengi\n" +
                    "Taşı: Safir\n" +
                    "Günü: Çarşamba\n\n" +
                    "Başak burcu özellikleri: Titiz, analitik, \n" +
                    "düzenli, yardımsever kişilerdir.";
        } else if ("Terazi".equals(sunsign)) {
            characteristics = "Elementi: Hava\n" +
                    "Niteliği: Öncü\n" +
                    "Gezegeni: Venüs\n" +
                    "Rengi: Mavi\n" +
                    "Taşı: Opal\n" +
                    "Günü: Cuma\n\n" +
                    "Terazi burcu özellikleri: Adil, diplomatik, \n" +
                    "sosyal, zarif kişilerdir.";
        } else if ("Akrep".equals(sunsign)) {
            characteristics = "Elementi: Su\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Mars\n" +
                    "Rengi: Bordo\n" +
                    "Taşı: Opal\n" +
                    "Günü: Salı\n\n" +
                    "Akrep burcu özellikleri: Mücadeleci, güçlü, \n" +
                    "yılmaz, hırslı kişilerdir.";
        } else if ("Yay".equals(sunsign)) {
            characteristics = "Elementi: Ateş\n" +
                    "Niteliği: Değişken\n" +
                    "Gezegeni: Jüpiter\n" +
                    "Rengi: Mor\n" +
                    "Taşı: Turkuaz\n" +
                    "Günü: Perşembe\n\n" +
                    "Yay burcu özellikleri: Neşeli, özgürlük seven, \n" +
                    "iyimser, maceraperest kişilerdir.";
        } else if ("Oğlak".equals(sunsign)) {
            characteristics = "Elementi: Toprak\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Satürn\n" +
                    "Rengi: Kahverengi\n" +
                    "Taşı: Akik\n" +
                    "Günü: Cumartesi\n\n" +
                    "Oğlak burcu özellikleri: Disiplinli, ciddi, \n" +
                    "sorumluluk sahibi, hırslı kişilerdir.";
        } else if ("Kova".equals(sunsign)) {
            characteristics = "Elementi: Hava\n" +
                    "Niteliği: Sabit\n" +
                    "Gezegeni: Uranüs\n" +
                    "Rengi: Turuncu\n" +
                    "Taşı: Ametist\n" +
                    "Günü: Cumartesi\n\n" +
                    "Kova burcu özellikleri: Yaratıcı, bağımsız,\n" +
                    " özgün, ileri görüşlü kişilerdir.";
        } else if ("Balık".equals(sunsign)) {
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
            sunsignCharacteristics.setText(characteristics);
        }



    private void sunsignSymbol(String sunsign) {
        String symbol = "";
        if ("Koç".equals(sunsign)) {
            symbol = "♈";
        } else if ("Boğa".equals(sunsign)) {
            symbol = "♉";
        }
        else if ("İkizler".equals(sunsign)) {
            symbol = "♊";
        } else if ("Yengeç".equals(sunsign)) {
            symbol = "♋";
        } else if ("Aslan".equals(sunsign)) {
            symbol = "♌";
        } else if ("Başak".equals(sunsign)) {
            symbol = "♍";
        } else if ("Terazi".equals(sunsign)) {
            symbol = "♎";
        } else if ("Akrep".equals(sunsign)) {
            symbol = "♏";
        } else if ("Yay".equals(sunsign)) {
            symbol = "♐";
        } else if ("Oğlak".equals(sunsign)) {
            symbol = "♑";
        } else if ("Kova".equals(sunsign)) {
            symbol = "♒";
        } else if ("Balık".equals(sunsign)) {
            symbol = "♓";
        }
        sunsignSymbolLabel.setText(symbol);
    }

    @FXML
    private void initialize1() { //geri tuşu işlevleri
        backButton1.setOnAction(event -> {
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
            Stage stage = (Stage) backButton1.getScene().getWindow();

            // Yeni sahneyi mevcut pencereye ayarla
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

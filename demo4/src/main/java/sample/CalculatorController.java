package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> hourComboBox;
    @FXML
    private ComboBox<String> minuteComboBox;
    @FXML
    private ComboBox<String> birthplaceComboBox;
    @FXML
    private Button sunsignButton;
    @FXML
    private Button backButton;
    @FXML
    private Button risingsignButton;

    public DatePicker getDatePicker() { // bu verilerin sunsigncontroller ve risingsign controllerda çağırılabilmesi için constructor
        return datePicker;
    }

    public ComboBox<String> getHourComboBox() {
        return hourComboBox;
    }

    public ComboBox<String> getMinuteComboBox() {
        return minuteComboBox;
    }

    public ComboBox<String> getBirthplaceComboBox() {
        return birthplaceComboBox;
    }
    @FXML
    private void initialize() {
        // ComboBox için saat değerlerini doldur
        List<String> hours = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            hours.add(String.format("%02d", i));
        }
        ObservableList<String> hourItems = FXCollections.observableArrayList(hours);
        hourComboBox.setItems(hourItems);


        // ComboBox için dakika değerlerini doldur
        List<String> minutes = new ArrayList<>();
        for (int i = 0; i <= 59; i++) {
            minutes.add(String.format("%02d", i));
        }
        ObservableList<String> minuteItems = FXCollections.observableArrayList(minutes);
        minuteComboBox.setItems(minuteItems);

        // ComboBox için Türkiye'deki illeri doldur
        List<String> turkishCities = Arrays.asList(
                "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
                "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
                "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum",
                "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin",
                "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli",
                "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir",
                "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat",
                "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt",
                "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük",
                "Kilis", "Osmaniye", "Düzce"
        );

        ObservableList<String> cityItems = FXCollections.observableArrayList(turkishCities);
        birthplaceComboBox.setItems(cityItems);

        // DatePicker için sadece geçmiş tarihleri seçilebilir kıl
        datePicker.setValue(LocalDate.now());
    }



    @FXML
    private void onCalculateSunSignClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sunsign.fxml"));
            Parent root = loader.load();

            SunsignController sunsignController = loader.getController();
            sunsignController.setCalculatorController(this);

            Scene scene = new Scene(root);
            Stage stage = (Stage) sunsignButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onCalculateRisingSignClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("risingsign.fxml"));
            Parent root = loader.load();

            RisingsignController risingsignController = loader.getController();
            risingsignController.setCalculatorController(this);

            Scene scene = new Scene(root);
            Stage stage = (Stage) risingsignButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void initialize1() {

        backButton.setOnAction(event -> {
            // İlgili FXML dosyasını yükleyerek yeni bir sahne oluştur
            loadScene();
        });
    }
    @FXML
    private void loadScene() {
        try {
            // İlgili FXML dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));//FXMLLoader polymorphism örneği
            Parent root = loader.load();

            // Yeni bir sahne oluştur
            Scene scene = new Scene(root);

            // Mevcut pencereyi al
            Stage stage = (Stage) backButton.getScene().getWindow();

            // Yeni sahneyi mevcut pencereye ayarla
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}


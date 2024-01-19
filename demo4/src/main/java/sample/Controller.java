package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class Controller {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button signupButton;



    public void loginButtonOnAction(ActionEvent e) {
        if (usernameTextField.getText().isEmpty() == false && passwordPasswordField.getText().isEmpty() == false) {
            validateLogin(); //eğer username ve password kısmı boş değilse validateLogin metodunu çalıştır
        } else {
            loginMessageLabel.setText("Lütfen kullanıcı adı ve şifre giriniz.");
        }//eğer boş ise boş labeldaki text buna dönecek
    }

    public void cancelButtonOnAction(ActionEvent e) { //cancel butonuna basınca ekran kapanacak
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection(); //database'e bağlanmak için nesne connectNow adında bir nesne oluşturduk
        Connection connectDB = connectNow.getConnection(); //connectDB nesnesi getConnection metodu tarafından döndürülen bağlantıyı tutuyor
        //getConnection() metoduna connectNow nesnesi sayesinde ulaşıyoruz
        String verifyLogin = "SELECT COUNT(1) FROM users WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
        // sql kodlarıyla veritabanında yazdığımız kullanıcı adı ve parolaya sahip bir veri var mı onu kontrol ediyoruz
        try {
            Statement statement = connectDB.createStatement(); // Veritabanı bağlantısı üzerinden bir Statement nesnesi oluşturulur. Bu nesne, SQL ifadelerini veritabanına göndermek için kullanılır.
            ResultSet queryResult = statement.executeQuery(verifyLogin);  // Oluşturulan Statement nesnesi aracılığıyla SQL sorgusu (verifyLogin) veritabanına gönderilir ve sonuç ResultSet nesnesine atanır.

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    //eğer sql sorgusu doğruysa calculator ekranınıı açacak metod çağırılır
                    openCalculator();
                } else {
                    loginMessageLabel.setText("Geçersiz giriş. Lütfen tekrar deneyiniz.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openCalculator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("calculator.fxml"));
            //FXML dosyalarını yüklemek ve bu dosyadan bir Java nesnesi oluşturmak için kullanılır.
            Parent root = loader.load();

            // Yeni bir sahne oluşturun
            Scene scene = new Scene(root);

            // Mevcut pencereyi alın
            Stage stage = (Stage) cancelButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void signupButtonOnAction() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent root = loader.load();

            // Yeni bir sahne oluşturun
            Scene scene = new Scene(root);

            // Mevcut pencereyi alın
            Stage stage = (Stage) cancelButton.getScene().getWindow();


            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}



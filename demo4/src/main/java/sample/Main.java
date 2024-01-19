package sample; //uygulamamın ait olduğu paket
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException; //input output exception girdi çıktı işlemlerinde  hata olursa

public class Main extends Application { //application bir abstract classtır  ve
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.initStyle(StageStyle.UNDECORATED); //başlık çubuğu vs gibi ögeleri siliyor
        stage.setScene(scene);
        stage.show();
    }


}
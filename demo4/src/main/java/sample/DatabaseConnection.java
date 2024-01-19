package sample;
import java.sql.Connection; //veritabanı bağlantısı için gerekli kütüphaneleri import et
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection { //veritabanı bağlantısı kurmak için oluşturduğum sınıf
    public Connection databaseLink;

    public Connection getConnection() { //veritabanına bağlanmak için Connection objesini döndüren metod
        String databaseName = "apptrology";
        String databaseUser = "postgres";
        String databasePassword = "cennet70";
        String url = "jdbc:postgresql://localhost:5432/" + databaseName;

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (ClassNotFoundException | SQLException e) { //eğer bir hata oluşursa catch hatanın izini ekrana yazdırır (e.printStackTrace();).
            e.printStackTrace();
        }
        return databaseLink; //bağlantı başarıyla kurulduğunda metod bağlantıyı döndürür
    }


}

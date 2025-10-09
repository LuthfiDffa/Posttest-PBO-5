package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    // ganti sesuai DB kamu
    private static final String URL  =
        "jdbc:mysql://127.0.0.1:3306/showroom_pbo?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // default XAMPP
    private static final String PASS = "";     // kosong kalau belum set password

    public static Connection getConnection() throws Exception {
        // pastikan driver ter-load (aman untuk Maven/non-Maven)
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

package main;

import database.DB;
import java.sql.Connection;
import java.sql.SQLException;

public class TestKoneksi {
    public static void main(String[] args) {
        try (Connection c = DB.getConnection()) {
            System.out.println("Koneksi OK: " + (c != null));
        } catch (SQLException e) {
            System.out.println("Koneksi GAGAL (SQLException)");
            for (Throwable t : e) t.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL tidak ditemukan");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error lain");
            e.printStackTrace();
        }
    }
}

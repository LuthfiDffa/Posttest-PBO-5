package main;

import database.DB;
import java.sql.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("MENU DATABASE MOBIL SPORT");
            System.out.println("1. Tambah Data Mobil");
            System.out.println("2. Lihat Data Mobil");
            System.out.println("3. Ubah Data Mobil");
            System.out.println("4. Hapus Data Mobil");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = Integer.parseInt(in.nextLine());

            switch (pilih) {
                case 1 -> tambahData(in);
                case 2 -> tampilkanData();
                case 3 -> ubahData(in);
                case 4 -> hapusData(in);
                case 5 -> System.out.println("Keluar dari program...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 5);
    }

    private static void tambahData(Scanner in) {
        try (Connection c = DB.getConnection()) {
            System.out.print("Tipe (1=Coupe, 2=Convertible): ");
            int tipe = Integer.parseInt(in.nextLine());
            System.out.print("Merk  : ");
            String merk = in.nextLine();
            System.out.print("Model : ");
            String model = in.nextLine();
            System.out.print("Tahun : ");
            int tahun = Integer.parseInt(in.nextLine());
            System.out.print("Harga : ");
            String harga = in.nextLine();

            if (tipe == 1) {
                System.out.print("Jumlah Pintu: ");
                int pintu = Integer.parseInt(in.nextLine());
                String sql = "INSERT INTO mobil (tipe, merk, model, tahun, harga, pintu, atap_terbuka) VALUES ('COUPE',?,?,?,?,?,NULL)";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setString(1, merk);
                    ps.setString(2, model);
                    ps.setInt(3, tahun);
                    ps.setString(4, harga);
                    ps.setInt(5, pintu);
                    ps.executeUpdate();
                }
            } else {
                System.out.print("Atap Terbuka (true/false): ");
                boolean atap = Boolean.parseBoolean(in.nextLine());
                String sql = "INSERT INTO mobil (tipe, merk, model, tahun, harga, pintu, atap_terbuka) VALUES ('CONVERTIBLE',?,?,?,?,NULL,?)";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setString(1, merk);
                    ps.setString(2, model);
                    ps.setInt(3, tahun);
                    ps.setString(4, harga);
                    ps.setBoolean(5, atap);
                    ps.executeUpdate();
                }
            }
            System.out.println("Data berhasil ditambahkan ke database.");
        } catch (Exception e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }
    }

    private static void tampilkanData() {
        String sql = "SELECT * FROM mobil ORDER BY id";
        try (Connection c = DB.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("DATA MOBIL (DARI DATABASE)");
            while (rs.next()) {
                int id = rs.getInt("id");
                String tipe = rs.getString("tipe");
                String merk = rs.getString("merk");
                String model = rs.getString("model");
                int tahun = rs.getInt("tahun");
                String harga = rs.getString("harga");
                String pintu = rs.getString("pintu");
                String atap = rs.getString("atap_terbuka");

                System.out.println(id + ". " + tipe + " | " + merk + " | " + model + " | "+ tahun + " | " + harga
                        + (pintu != null ? " | Pintu: " + pintu : "")
                        + (atap != null ? " | Atap Terbuka: " + ("1".equals(atap) ? "Ya" : atap) : "")
                );  
            }
        } catch (Exception e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
        }
    }

    private static void ubahData(Scanner in) {
        tampilkanData();
        try (Connection c = DB.getConnection()) {
            System.out.print("Masukkan ID yang akan diubah: ");
            int id = Integer.parseInt(in.nextLine());

            System.out.print("Tipe baru (1=Coupe, 2=Convertible): ");
            int tipe = Integer.parseInt(in.nextLine());
            System.out.print("Merk  : ");
            String merk = in.nextLine();
            System.out.print("Model : ");
            String model = in.nextLine();
            System.out.print("Tahun : ");
            int tahun = Integer.parseInt(in.nextLine());
            System.out.print("Harga : ");
            String harga = in.nextLine();

            if (tipe == 1) {
                System.out.print("Jumlah Pintu: ");
                int pintu = Integer.parseInt(in.nextLine());
                String sql = "UPDATE mobil SET tipe='COUPE', merk=?, model=?, tahun=?, harga=?, pintu=?, atap_terbuka=NULL WHERE id=?";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setString(1, merk);
                    ps.setString(2, model);
                    ps.setInt(3, tahun);
                    ps.setString(4, harga);
                    ps.setInt(5, pintu);
                    ps.setInt(6, id);
                    ps.executeUpdate();
                }
            } else {
                System.out.print("Atap Terbuka (true/false): ");
                boolean atap = Boolean.parseBoolean(in.nextLine());
                String sql = "UPDATE mobil SET tipe='CONVERTIBLE', merk=?, model=?, tahun=?, harga=?, pintu=NULL, atap_terbuka=? WHERE id=?";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setString(1, merk);
                    ps.setString(2, model);
                    ps.setInt(3, tahun);
                    ps.setString(4, harga);
                    ps.setBoolean(5, atap);
                    ps.setInt(6, id);
                    ps.executeUpdate();
                }
            }
            System.out.println("Data berhasil diubah di database.");
        } catch (Exception e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
        }
    }

    private static void hapusData(Scanner in) {
        tampilkanData();
        try (Connection c = DB.getConnection()) {
            System.out.print("\nMasukkan ID yang akan dihapus: ");
            int id = Integer.parseInt(in.nextLine());
            String sql = "DELETE FROM mobil WHERE id=?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
            System.out.println("Data berhasil dihapus dari database.");
        } catch (Exception e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
        }
    }
}

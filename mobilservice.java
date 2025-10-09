package service;

import java.util.ArrayList;
import model.mobilsport;
import model.mobilsportcoupe;
import model.mobilsportconvertible;

public class mobilservice {
    private ArrayList<mobilsport> data = new ArrayList<>();

    // V1: tambah pakai objek langsung
    public void tambah(mobilsport m) {
        data.add(m);
        System.out.println("Data berhasil ditambahkan.");
    }

    // V2 (OVERLOADING) : COUPE  -> parameter terakhir INT (pintu)
    public void tambah(String merk, String model, int tahun, String harga, int pintu) {
        mobilsport m = new mobilsportcoupe(merk, model, tahun, harga, pintu);
        tambah(m);
    }

    // V3 (OVERLOADING) : CONVERTIBLE -> parameter terakhir BOOLEAN (atapTerbuka)
    public void tambah(String merk, String model, int tahun, String harga, boolean atapTerbuka) {
        mobilsport m = new mobilsportconvertible(merk, model, tahun, harga, atapTerbuka);
        tambah(m);
    }

    // READ
    public void tampil() {
        if (data.isEmpty()) {
            System.out.println("(Belum ada data)");
        } else {
            for (int i = 0; i < data.size(); i++) {
                System.out.println((i + 1) + ". " + data.get(i).info());
            }
        }
    }

    // UPDATE
    public void ubah(int index, mobilsport mBaru) {
        data.set(index, mBaru);
        System.out.println("Data berhasil diubah.");
    }

    // DELETE
    public void hapus(int index) {
        data.remove(index);
        System.out.println("Data berhasil dihapus.");
    }
}

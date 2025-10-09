/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class mobilsportcoupe extends mobilsport{
    private int jumlahpintu;

    public mobilsportcoupe(String merk, String model, int tahun, String harga, int jumlahPintu) { // <- String
        super(merk, model, tahun, harga);  // <- String
        this.jumlahpintu = jumlahPintu;
    }
          
    @Override
    public String info() {
        return "[Coupe] " + super.info() + " | Pintu: " + jumlahpintu;

    }
}


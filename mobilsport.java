/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class mobilsport {  
    private String merk;                   
    private String model;
    private int tahun;
    private String harga;
    
    public mobilsport(String merk, String model, int tahun, String harga) {
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.harga = harga;
}

    public String getMerk() { return merk; }
    public String getModel() { return model; }
    public int getTahun() { return tahun; }
    public String getHarga() { return harga; }

    public void setMerk(String merk)   { this.merk = merk; }
    public void setModel(String model) { this.model = model; }
    public void setTahun(int tahun)    { this.tahun = tahun; }
    public void setHarga(String harga) { this.harga = harga; }
    
    public String info() {
        return merk + " | " + model + " | " + tahun + " | " + harga;
    }
}   


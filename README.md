# Showroom Mobil Sport (Readme sebelumnya dengan penjelasan tambahan)

| Nama                      | NIM           | Kelas             |
|---------------------------|---------------|-------------------|
| Luthfi Daffa Purbaya   | 2409116102    | Sistem Informasi C |

## Deskripsi Program
Program ini merupakan sebuah sistem manajemen data showroom mobil sport berbasis Java, fitur utama nya sendiri mencakup operasi CRUD (Create, Read, Update, Delete) terhadap data-data mobil yang ada di showroom. Setiap data mobil juga memiliki atribut yaitu merk, model, tahun, dan harga.

Program juga menerapkan:

1. Encapsulation dengan penggunaan getter dan setter.
2. Inheritance dengan membuat satu superclass mobilsport dan dua subclass mobilsportcoupe serta mobilsportconvertible.
3. Polymorphism (Overriding), di mana method info() di subclass menampilkan data sesuai tipe mobil (Coupe atau Convertible).

## Penerapan Abstraction & Polymorphism
**1. Abstraction**

Abstraction diterapkan pada class mobilsport. Class ini dijadikan abstract class yang berisi atribut umum (merk, model, tahun, harga) dan mendeklarasikan method abstract info(). Karena info() bersifat abstract, setiap subclass (seperti mobilsportcoupe dan mobilsportconvertible) harus mengimplementasikan sendiri method ini sesuai kebutuhannya. Dengan cara ini, kita bisa menyembunyikan detail implementasi pada superclass dan hanya memberikan “kerangka” yang harus diikuti oleh subclass.

Letak Abstraction:
- abstract class mobilsport di package model
- public abstract String info(); (method abstract yang di-override oleh subclass)


**2. Polymorphism**

Untuk Polymorphism di program ini ada 2 jenis yaitu Overloading dan Overriding.

a. Overloading

Overloading diterapkan pada class mobilservice. Di class ini, terdapat tiga versi method tambah() dengan parameter berbeda:
- tambah(mobilsport m) → menerima objek langsung.
- tambah(String merk, String model, int tahun, String harga, int pintu) → untuk menambah mobil tipe Coupe.
- tambah(String merk, String model, int tahun, String harga, boolean atapTerbuka) → untuk menambah mobil tipe Convertible.

Semua versi ini memiliki nama method yang sama tetapi parameter berbeda. Inilah yang disebut method overloading. Dengan overloading, kita memudahkan MainApp memanggil method tambah() sesuai kebutuhan tanpa membuat objek secara manual.

Letak Overloading:
- Class mobilservice di package service
- Method tambah() dengan parameter berbeda


b. Overriding

Overriding diterapkan pada subclass mobilsportcoupe dan mobilsportconvertible. Kedua subclass ini meng-override method info() yang berasal dari superclass mobilsport.

- Di mobilsportcoupe, method info() menampilkan tambahan jumlah pintu.
- Di mobilsportconvertible, method info() menampilkan status atap terbuka.

Jadi ketika kita memanggil data.get(i).info() di mobilservice.tampil(), program otomatis memanggil method info() versi yang sesuai dengan objeknya (Coupe atau Convertible). Inilah yang disebut method overriding.

Letak Overriding:

- Class mobilsportcoupe di package model → override info()
- Class mobilsportconvertible di package model → override info()

Saya juga membuat file baru bernama Deskripsi.java yang berisi sebuah interface. Interface ini berfungsi untuk menerapkan konsep Abstraction pada program saya. Di dalam interface ini saya hanya mendeklarasikan satu method, yaitu deskripsiSingkat(), tanpa memberikan isi atau implementasi langsung. Dengan adanya interface ini, setiap subclass yang mengimplementasikannya (seperti mobilsportcoupe dan mobilsportconvertible) wajib membuat sendiri isi dari method tersebut sesuai dengan karakteristik masing-masing tipe mobil. Cara ini membuat program lebih rapi, fleksibel, dan mudah diperluas karena aturan method sudah ditentukan di interface, tapi implementasinya bisa berbeda-beda pada tiap class.

<img width="303" height="116" alt="image" src="https://github.com/user-attachments/assets/8fbb0fb3-5e41-4795-a1d1-db211617e586" />


## Penerapan JDBC & ORM
**1. JDBC (Java Database Connectivity)**

Koneksi database dilakukan melalui class DB.java di package database. Class ini menggunakan driver com.mysql.cj.jdbc.Driver untuk menghubungkan program ke database MySQL. Lalu pada program ini, JDBC juga digunakan untuk menjalankan perintah SQL seperti INSERT, SELECT, UPDATE, dan DELETE ke dalam database yang dibuat menggunakan XAMPP (phpMyAdmin).  

Letak JDBC (Java Database Connectivity):

- Class DB.Java pada package Database (Berisi driver untuk terhubung ke database MySQL).
- Class TestKoneksi.Java pada package Main (untuk mengetes apakah koneksi JDBC ke database MySQL sudah berhasil atau belum).


<img width="360" height="46" alt="image" src="https://github.com/user-attachments/assets/68851132-695c-437e-a014-0cb2f74eaafb" />

<img width="358" height="68" alt="image" src="https://github.com/user-attachments/assets/f498ea5c-27e9-4dfc-8def-013d0d8047cd" />


**2. ORM (Object Relational Mapping)**

Dalam program ini, saya menerapkan konsep ORM (Object Relational Mapping) secara sederhana, di mana class mobilsport berperan sebagai representasi dari tabel mobil di database showroom_pbo. Setiap atribut yang terdapat di dalam class (merk, model, tahun, harga) mewakili kolom-kolom pada tabel tersebut, sehingga struktur data pada program Java dapat terhubung langsung dengan struktur data di dalam database.

 Letak ORM (Object Relational Mapping):
 - Class mobilsport.java pada package model
 - Class mobilsportcoupe.java pada package model
 - Class mobilsportconvertible.java pada package model

<img width="358" height="114" alt="Screenshot 2025-10-10 005907" src="https://github.com/user-attachments/assets/7c5042a6-ed30-4f8d-a485-6a2fad3b5930" />


## Penjelasan Singkat Program Setelah Menerapkan JDBC & ORM
Setelah Menerapkan JDBC & ORM, program ini memiliki sedikit perubahan alur/output yang dimana jika kita ingin menampilkan data mobil pada output, Maka data yang ditampilkan/diambil adalah data yang sudah ada pada Database Mysql. Namun kita juga bisa menambah data baru, mengubah bahkan menghapus data melalui NetBeans lalu perubahan tersebut juga akan terjadi pada database.

Disini jika kita memilih opsi lihat data mobil, maka data yang ditampilkan merupakan data dari database.

<img width="755" height="246" alt="Screenshot 2025-10-10 001328" src="https://github.com/user-attachments/assets/65c063eb-f36e-4139-914e-7ab12ac34a1d" />

<img width="1916" height="975" alt="Screenshot 2025-10-07 221643" src="https://github.com/user-attachments/assets/37a489a6-f632-427a-8820-01469db29a51" />


Lalu jika kita menambahkan data mobil baru di Netbeans maka data mobil yang baru tersebut juga akan muncul/bertambah di database.

<img width="696" height="310" alt="Screenshot 2025-10-10 001339" src="https://github.com/user-attachments/assets/7365c0d7-767c-434b-bd09-73b569070884" />

<img width="1602" height="502" alt="Screenshot 2025-10-10 011835" src="https://github.com/user-attachments/assets/604392c9-a853-4c87-867f-bcb8d609eeb0" />



## Alur Program
1. Program menampilkan menu utama berupa:
   - Tambah data mobil
   - Lihat semua data
   - Ubah data mobil
   - Hapus data mobil
   - Keluar
2. Pengguna memilih menu dengan memasukkan angka 1–5.
3. Setiap pilihan menu memanggil method dari class `mobilservice`:
   - **Tambah** : Pengguna menambah dan memilih tipe mobil (Coupe / Convertible), lalu mengisi data umum (merk, model, tahun, harga) serta data tambahan sesuai tipe (jumlah pintu atau status atap terbuka).  
   - **Lihat** : Program menampilkan seluruh data mobil sport yang sudah tersimpan. Output berbeda sesuai tipe mobil karena menerapkan method overriding.  
   - **Ubah** : mengganti data mobil sesuai nomor urut yang dipilih.  
   - **Hapus** : menghapus data mobil sesuai nomor urut yang dipilih.
   - **Keluar** : menghentikan program berjalan.
4. Program terus berjalan hingga user memilih menu keluar.

##  Struktur Packages & Class
   
<img width="354" height="268" alt="image" src="https://github.com/user-attachments/assets/6546543f-6301-4394-9e6e-5d14577ee747" />

Bisa terlihat pada struktur project di atas, saya menambahkan 2 class baru di dalam package model, yaitu:
1. mobilsportcoupe.java
2. mobilsportconvertible.java
Pada package model,  mobilsport.java menjadi superclass nya sedangkan mobilsportcoupe.java dan mobilsportconvertible.java menjadi subclass nya. Tujuannya adalah untuk menerapkan konsep inheritance, di mana mobilsport menyimpan atribut warisan/umum seperti merk, model, tahun, dan harga, sementara mobilsportcoupe dan mobilsportconvertible menambahkan atribut khusus mereka sendiri:
- mobilsportcoupe: atribut tambahannya pintu (jumlah pintu).
- mobilsportconvertible: atribut tambahan atapTerbuka (status atap).

Jadi  tipe Coupe adalah mobil sport dengan desain atap tetap (nggak bisa dibuka) dan biasanya punya dua pintu. Sedangkan tipe Convertible adalah mobil sport dengan desain atap terbuka yang bisa dilipat atau dilepas, sehingga bisa dipakai dalam mode atap tertutup atau terbuka.

# Penggunaan Program

<details>
<summary><h3>Menu Showroom Mobil Sport</h3></summary>

<img width="653" height="147" alt="image" src="https://github.com/user-attachments/assets/d9bd3829-bdfb-422b-816c-f3f8a3d62c39" />

Ketika program dijalankan, sistem akan langsung menampilkan menu utama yang berisi daftar pilihan menu. Disini pengguna diminta untuk memasukkan nomor menu sesuai dengan pilihan yang mereka inginkan. Setelah itu, inputan pengguna akan dijalankan oleh program dan kemudian kembali menampilkan menu utama, proses ini terus berulang hingga pengguna memilih opsi Keluar untuk menghentikan program.

## 1. Tambah Data Mobil

<img width="1011" height="167" alt="image" src="https://github.com/user-attachments/assets/f5c493a1-0ddb-4249-b996-a7d730ee14e6" />

<img width="858" height="170" alt="image" src="https://github.com/user-attachments/assets/89bb26ea-bc44-4dd9-bd53-c14de139e0b7" />

Saat memilih menu ini, pengguna diminta untuk menginput informasi mobil seperti merk, model, tahun, dan harga. Setelah itu, pengguna juga menentukan tipe mobil, apakah Coupe atau Convertible. Jika memilih Coupe, maka ada input tambahan berupa jumlah pintu. Sedangkan jika memilih Convertible, pengguna mengisi status atap (terbuka atau tidak).

## 2. Lihat Data Mobil

<img width="752" height="204" alt="image" src="https://github.com/user-attachments/assets/71713f01-1eb5-4391-962a-9c1fface77b5" />

Saat memilih menu ini, program akan menampilkan semua data mobil yang tersimpan beserta detailnya, termasuk merk, model, tahun, harga, serta atribut khusus sesuai tipe mobil (jumlah pintu untuk Coupe atau status atap untuk Convertible).

## 3. Ubah Data Mobil

<img width="1032" height="358" alt="image" src="https://github.com/user-attachments/assets/d4e3498c-1d11-4f4d-8506-99c4dd6f67c9" />

Pada pilihan ini, pengguna dapat memperbarui data mobil yang sudah ada. Program akan meminta nomor urut data yang ingin diganti, lalu menyuruh pengguna memasukkan input data baru dan menyimpannya sebagai pengganti data lama. Disini saya mengganti data nomor 1 yaitu merubah tipe mobil nya menjadi Convertible.

<img width="759" height="65" alt="image" src="https://github.com/user-attachments/assets/2b4a68d6-b5b7-4043-a51e-70a7183f433b" />

Bisa dilihat pada data no 1 yang awalanya mobil BMW M2 Competition itu bertipe Coupe sekarang menjadi Convertible

## 4. Hapus Data Mobil

<img width="859" height="238" alt="image" src="https://github.com/user-attachments/assets/84fc829a-ae0b-416f-aaca-731d79b53737" />

Pada opsi ini memungkinkan pengguna menghilangkan data mobil tertentu dari daftar data. Setelah memilih nomor urut mobil, data tersebut akan dihapus dari ArrayList. Disini saya menghapus data pada nomor 1.

<img width="790" height="176" alt="image" src="https://github.com/user-attachments/assets/85012f0e-7620-436c-93e3-3e9eb4ea09dd" />

Maka jika kita cek data mobil pada nomor 1 sudah tidak dan hanya tersisa data mobil yang belum dihapus.

## 5. Keluar

<img width="888" height="297" alt="image" src="https://github.com/user-attachments/assets/648cdd90-f220-441b-a625-1a731aecc9b3" />

Jika memilih opsi maka program nya akan berhenti berjalan.






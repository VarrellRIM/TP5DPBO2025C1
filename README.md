# TP5 - Mahasiswa Management System with Database

Aplikasi manajemen data mahasiswa dengan Java Swing terintegrasi database MySQL/MariaDB.

## Janji  
Saya Varrell Rizky Irvanni Mahkota dengan NIM 2306245 mengerjakan Tugas Praktikum 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Desain Program

### Struktur Kelas
1. **Kelas Mahasiswa**  
   - Model data mahasiswa dengan atribut:
     - `nim` (String)
     - `nama` (String)
     - `jenisKelamin` (String)
     - `semester` (int)
   - Method: Constructor, getter, setter

2. **Kelas Database**  
   - Menangani koneksi dan operasi database:
     - Koneksi ke MySQL/MariaDB
     - Method: `selectQuery()`, `insertUpdateDeleteQuery()`

3. **Kelas Menu**  
   - GUI utama menggunakan Java Swing
   - Komponen:
     - Form input (NIM, Nama, Jenis Kelamin, Semester Slider)
     - Tabel data mahasiswa
     - Tombol CRUD (Add, Update, Delete, Cancel)


## Alur Program

### 1. Inisialisasi
- Program memulai koneksi ke database
- Membaca data mahasiswa dari tabel `mahasiswa`
- Menampilkan data di tabel GUI

### 2. Create (Insert)
- User mengisi form:
  - NIM (*harus unik*)
  - Nama
  - Jenis Kelamin (dropdown)
  - Semester (slider 1-8)
- Validasi:
  - Jika NIM/nama kosong → tampil error dialog
  - Jika NIM sudah ada → tampil error dialog
- Data tersimpan di database

### 3. Read (Tampil Data)
- Data langsung diambil dari database
- Tabel otomatis refresh setelah operasi CRUD

### 4. Update
- Pilih baris di tabel → form terisi
- Ubah data → tombol "Update"
- Validasi NIM baru (jika diubah) harus unik

### 5. Delete
- Pilih baris → tombol "Delete"
- Konfirmasi dialog sebelum hapus

## Fitur Utama
1. **Integrasi Database**  
   - CRUD langsung ke MySQL/MariaDB
   - Data persisten (tidak hilang saat aplikasi ditutup)

2. **Validasi Input**  
   - Error dialog untuk:
     - Field kosong
     - NIM duplikat

3. **Slider Semester**  
   - Rentang 1-8 dengan tampilan nilai real-time

4. **Konfirmasi Hapus**  
   - Dialog "Ya/Tidak" sebelum menghapus data

## Dokumentasi Program
https://github.com/user-attachments/assets/eb5ec404-e1fb-424d-815b-bffb035a4e03


## Catatan Implementasi
- Menggunakan JDBC Driver untuk koneksi database
- Konfigurasi database di kelas `Database.java`:
  ```java
  String url = "jdbc:mysql://localhost:3306/db_mahasiswa";
  String user = "root";
  String password = ""; // Disesuaikan
  ```

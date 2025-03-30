public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private int semester; // Atribut baru

    public Mahasiswa(String nim, String nama, String jenisKelamin, int semester) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.semester = semester;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getNim() {
        return this.nim;
    }

    public String getNama() {
        return this.nama;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    
    public int getSemester() {
        return this.semester;
    }
}

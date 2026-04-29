package P2Jobsheet10;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;
    private String kelas;

    // Konstruktor
    public Mahasiswa(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    // Menampilkan data mahasiswa
    public void tampilkanData() {
        System.out.println("NIM    : " + nim);
        System.out.println("Nama   : " + nama);
        System.out.println("Prodi  : " + prodi);
        System.out.println("Kelas  : " + kelas);
    }

    // Getter
    public String getNim()   { return nim; }
    public String getNama()  { return nama; }
    public String getProdi() { return prodi; }
    public String getKelas() { return kelas; }
}
package TugasJobsheet10;

import java.util.Scanner;

public class AntrianKRSMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Maks antrian 10, maks per DPA 30 mahasiswa
        AntrianKRS antrian = new AntrianKRS(10, 30);
        int pilihan;

        do {
            System.out.println("\n");
            System.out.println("║    ANTRIAN PERSETUJUAN KRS MAHASISWA ");
            System.out.println("║         oleh Dosen PA (DPA)          ");
            System.out.println("");
            System.out.println(" 1. Daftar Antrian KRS");
            System.out.println(" 2. Panggil Antrian (2 mahasiswa)");
            System.out.println(" 3. Tampilkan Semua Antrian");
            System.out.println(" 4. Tampilkan 2 Antrian Terdepan");
            System.out.println(" 5. Tampilkan Antrian Paling Akhir");
            System.out.println(" 6. Cek Antrian Kosong");
            System.out.println(" 7. Cek Antrian Penuh");
            System.out.println(" 8. Kosongkan Antrian");
            System.out.println(" 9. Cetak Jumlah Antrian");
            System.out.println("10. Cetak Jumlah Sudah Proses KRS");
            System.out.println("11. Cetak Jumlah Belum Proses KRS");
            System.out.println(" 0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM    : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama   : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi  : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas  : ");
                    String kelas = sc.nextLine();
                    antrian.enqueue(new Mahasiswa(nim, nama, prodi, kelas));
                    break;
                case 2:
                    antrian.panggilAntrian();
                    break;
                case 3:
                    antrian.tampilkanSemua();
                    break;
                case 4:
                    antrian.tampilkanDuaDepan();
                    break;
                case 5:
                    antrian.tampilkanAkhir();
                    break;
                case 6:
                    System.out.println("Antrian kosong? " + antrian.isEmpty());
                    break;
                case 7:
                    System.out.println("Antrian penuh? " + antrian.isFull());
                    break;
                case 8:
                    antrian.clear();
                    break;
                case 9:
                    antrian.cetakJumlahAntrian();
                    break;
                case 10:
                    antrian.cetakSudahKRS();
                    break;
                case 11:
                    antrian.cetakBelumKRS();
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        sc.close();
    }
}

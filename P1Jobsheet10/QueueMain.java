package P1Jobsheet10;

import java.util.Scanner;

public class QueueMain {
    static Queue Q;
    static Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n===== MENU QUEUE =====");
        System.out.println("1. Enqueue (Tambah Data)");
        System.out.println("2. Dequeue (Keluarkan Data)");
        System.out.println("3. Peek (Lihat Depan)");
        System.out.println("4. Print (Tampilkan Semua)");
        System.out.println("5. Clear (Kosongkan Queue)");
        System.out.println("6. Cek Queue Kosong");
        System.out.println("7. Cek Queue Penuh");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        System.out.print("Masukkan kapasitas maksimal queue: ");
        int n = sc.nextInt();
        Q = new Queue(n);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data yang akan dienqueue: ");
                    int dt = sc.nextInt();
                    Q.enqueue(dt);
                    break;
                case 2:
                    int hasil = Q.dequeue();
                    if (hasil != -1) {
                        System.out.println("Data yang didequeue: " + hasil);
                    }
                    break;
                case 3:
                    Q.peek();
                    break;
                case 4:
                    Q.print();
                    break;
                case 5:
                    Q.clear();
                    break;
                case 6:
                    System.out.println("Queue kosong? " + Q.isEmpty());
                    break;
                case 7:
                    System.out.println("Queue penuh? " + Q.isFull());
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }
}

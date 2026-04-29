package TugasJobsheet10;

public class AntrianKRS {
    private Mahasiswa[] data;
    private int front;
    private int rear;
    private int size;
    private int max;
    private int jumlahSudahKRS;
    private int maxPerDPA;

    // Konstruktor
    public AntrianKRS(int maxAntrian, int maxPerDPA) {
        this.max = maxAntrian;
        this.maxPerDPA = maxPerDPA;
        this.data = new Mahasiswa[max];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.jumlahSudahKRS = 0;
    }

    // Cek antrian kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Cek antrian penuh
    public boolean isFull() {
        return size == max;
    }

    // Mengosongkan antrian
    public void clear() {
        front = -1;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    // Tambahkan mahasiswa ke antrian
    public void enqueue(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("[ERROR] Antrian Penuh! Maksimal " + max + " mahasiswa.");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear++;
            data[rear] = mhs;
            size++;
            System.out.println("✔ " + mhs.getNama() + " berhasil mendaftar antrian KRS. Posisi: " + size);
        }
    }

    // Panggil antrian untuk proses KRS (2 mahasiswa sekaligus)
    public void panggilAntrian() {
        if (isEmpty()) {
            System.out.println("[INFO] Tidak ada antrian untuk dipanggil.");
            return;
        }
        System.out.println("=== Memanggil Antrian KRS ===");
        int dipanggil = 0;
        while (!isEmpty() && dipanggil < 2) {
            if (jumlahSudahKRS >= maxPerDPA) {
                System.out.println("[INFO] DPA sudah menangani " + maxPerDPA + " mahasiswa. Sesi selesai.");
                return;
            }
            Mahasiswa mhs = data[front];
            front++;
            size--;
            if (isEmpty()) {
                front = -1;
                rear = -1;
            }
            jumlahSudahKRS++;
            dipanggil++;
            System.out.println("--- Mahasiswa ke-" + dipanggil + " ---");
            mhs.tampilkanData();
        }
        System.out.println("Total " + dipanggil + " mahasiswa telah diproses KRS.");
    }

    // Tampilkan semua antrian
    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Daftar Antrian KRS ===");
            for (int i = front; i <= rear; i++) {
                System.out.println("No. " + (i - front + 1));
                data[i].tampilkanData();
                System.out.println();
            }
        }
    }

    // Tampilkan 2 antrian terdepan
    public void tampilkanDuaDepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("=== 2 Antrian Terdepan ===");
        int tampil = Math.min(2, size);
        for (int i = 0; i < tampil; i++) {
            System.out.println("--- Antrian ke-" + (i + 1) + " ---");
            data[front + i].tampilkanData();
        }
    }

    // Tampilkan antrian paling akhir
    public void tampilkanAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Antrian Paling Akhir ===");
            data[rear].tampilkanData();
        }
    }

    // Cetak jumlah antrian
    public void cetakJumlahAntrian() {
        System.out.println("Jumlah antrian saat ini : " + size);
    }

    // Cetak jumlah yang sudah KRS
    public void cetakSudahKRS() {
        System.out.println("Jumlah sudah proses KRS : " + jumlahSudahKRS);
    }

    // Cetak jumlah yang belum KRS (yang masih dalam antrian)
    public void cetakBelumKRS() {
        System.out.println("Jumlah belum proses KRS : " + size);
        System.out.println("Kapasitas DPA tersisa   : " + (maxPerDPA - jumlahSudahKRS));
    }

    // Getter
    public int getSize()            { return size; }
    public int getJumlahSudahKRS()  { return jumlahSudahKRS; }
    public int getMaxPerDPA()       { return maxPerDPA; }
}
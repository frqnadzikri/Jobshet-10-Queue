package P2Jobsheet10;

public class AntrianLayanan {
    private Mahasiswa[] data;
    private int front;
    private int rear;
    private int size;
    private int max;

    // Konstruktor
    public AntrianLayanan(int n) {
        max = n;
        data = new Mahasiswa[max];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Mengecek apakah antrian kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Mengecek apakah antrian penuh
    public boolean isFull() {
        return size == max;
    }

    // Menampilkan mahasiswa paling depan
    public void peek() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Antrian Paling Depan ===");
            data[front].tampilkanData();
        }
    }

    // Menampilkan semua antrian
    public void print() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Semua Antrian Layanan ===");
            for (int i = front; i <= rear; i++) {
                System.out.println("--- Antrian ke-" + (i - front + 1) + " ---");
                data[i].tampilkanData();
            }
        }
    }

    // Mengosongkan antrian
    public void clear() {
        front = -1;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    // Menambahkan mahasiswa ke antrian
    public void enqueue(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian Penuh! Tidak dapat menambah antrian.");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear++;
            data[rear] = mhs;
            size++;
            System.out.println("Mahasiswa " + mhs.getNama() + " berhasil masuk antrian.");
        }
    }

    // Mengeluarkan mahasiswa dari antrian
    public Mahasiswa dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian Kosong! Tidak ada mahasiswa yang dapat dipanggil.");
            return null;
        } else {
            Mahasiswa temp = data[front];
            front++;
            size--;
            if (isEmpty()) {
                front = -1;
                rear = -1;
            }
            return temp;
        }
    }

    // Mendapatkan jumlah antrian saat ini
    public int getJumlahAntrian() {
        return size;
    }

    // [Pertanyaan Percobaan 2] Melihat antrian paling belakang
    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Antrian Paling Belakang ===");
            data[rear].tampilkanData();
        }
    }
}
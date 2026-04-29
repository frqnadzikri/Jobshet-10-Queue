package P1Jobsheet10;

public class Queue {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int max;

    // Konstruktor
    public Queue(int n) {
        max = n;
        data = new int[max];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Mengecek apakah queue kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Mengecek apakah queue penuh
    public boolean isFull() {
        return size == max;
    }

    // Menampilkan elemen paling depan (front)
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
        } else {
            System.out.println("Elemen paling depan: " + data[front]);
        }
    }

    // Menampilkan semua elemen queue dari front ke rear
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
        } else {
            System.out.print("Isi Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(data[i]);
                if (i < rear) System.out.print(" <- ");
            }
            System.out.println();
        }
    }

    // Menghapus semua elemen queue
    public void clear() {
        front = -1;
        rear = -1;
        size = 0;
        System.out.println("Queue berhasil dikosongkan.");
    }

    // Menambahkan elemen ke queue (enqueue)
    public void enqueue(int dt) {
        if (isFull()) {
            // Queue Overflow
            System.out.println("Queue Overflow! Queue sudah penuh.");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear++;
            data[rear] = dt;
            size++;
            System.out.println("Enqueue: " + dt + " berhasil ditambahkan.");
        }
    }

    // Mengeluarkan elemen dari queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            // Queue Underflow
            System.out.println("Queue Underflow! Queue sudah kosong.");
            return -1;
        } else {
            int temp = data[front];
            front++;
            size--;
            if (isEmpty()) {
                front = -1;
                rear = -1;
            }
            return temp;
        }
    }
}
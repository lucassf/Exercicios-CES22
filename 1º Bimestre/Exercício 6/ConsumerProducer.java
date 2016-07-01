package consumerproducer;

import java.io.FileInputStream;
import java.util.Scanner;

class Writer extends Thread {

    Buffer b;
    FileInputStream fs;

    @Override
    public void run() {
        int x;
        try {
            while ((x = fs.read()) != -1) {
                b.put((char) x);
            }
            b.put('\032');
        } catch (Exception e) {
            System.err.println("Cannot read");
            System.exit(1);
        }
    }

    Writer(String fname, Buffer b) {
        this.b = b;
        try {
            fs = new FileInputStream(fname);
        } catch (Exception e) {
            fs = null;
            System.err.println("Cannot open " + fname);
            System.exit(1);
        }
    }
}

class Reader extends Thread {

    Buffer b;
    int consumer;

    @Override
    public void run() {
        char x;
        while ((x =callGet() )!= '\032') {
            System.out.println("Consumidor #" + consumer + ": " + x);
        }
        b.put('\032');
    }

    Reader(Buffer b, int consumer) {
        this.b = b;
        this.consumer = consumer;
    }
    
    synchronized char callGet(){
        return b.get();
    }
}

class Buffer {

    final int MAXSIZE = 1; // Número máximo de elementos contidos no Buffer
    char keep[];
    int count, front, rear;

    public synchronized char get() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                
            }
            
        }
        char x = keep[rear];
        rear = (rear + 1) % MAXSIZE;
        count--;
        notifyAll();  // that a space is now available 
        return x;
    }

    public synchronized void put(char x) {
        while (count == MAXSIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Put "+e.getMessage());
            }
        }
        keep[front] = x;
        front = (front + 1) % MAXSIZE;
        count++;
        notify();
    }

    Buffer() {
        keep = new char[MAXSIZE];
        count = 0;
        front = rear = 0;
    }
}

public class ConsumerProducer {

    public static void main(String[] args) {
        int consumers;
        Buffer buffer;
        Scanner sc = new Scanner(System.in);
        consumers = sc.nextInt();
        if (consumers<=0||consumers>1000)consumers=1;
        buffer = new Buffer();
        for (int i = 1; i <= consumers; i++) {
            new Reader(buffer, i).start();
        }
        new Writer("items.txt", buffer).start();
    }
}

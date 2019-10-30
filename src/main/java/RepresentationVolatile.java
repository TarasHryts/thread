import java.util.Scanner;

public class RepresentationVolatile {
    public static void main(String[] args) {
        MyNewThread myNewThread = new MyNewThread();
        myNewThread.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        myNewThread.shutdown();
    }
}

class MyNewThread extends Thread {
    private boolean running = true;

    public void run() {
        while (running) {
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
public class RepresentationRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runner());
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello from main");
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("hello from my Thread " + i);
        }
    }
}
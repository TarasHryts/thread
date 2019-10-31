public class Representation {
    public static int count = 0;

    public static void main(String[] args) {
        MyNewThread myNewThread = new MyNewThread();
        Runner runner = new Runner();
        myNewThread.start();
        new Thread(runner).start();
    }

    public void increment() {
        while (count < 100) {
            count++;
            System.out.println("count = " + count + " " + Thread.currentThread().getName());
        }
    }
}

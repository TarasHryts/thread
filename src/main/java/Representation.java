public class Representation {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyNewThread myNewThread = new MyNewThread(counter);
        Runner runner = new Runner(counter);
        myNewThread.start();
        new Thread(runner).start();
    }
}

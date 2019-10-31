class MyNewThread extends Thread {
    private Counter counter;

    public MyNewThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100 ; i++) {
            counter.increment();
            System.out.println("hello from thread " + counter.getCounter()
                    + " " + Thread.currentThread().getName());
        }
    }
}

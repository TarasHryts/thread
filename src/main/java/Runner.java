class Runner implements Runnable {
    private Counter counter;

    public Runner(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.increment();
            System.out.println("hello from runner " + counter.getCounter()
                    + " " + Thread.currentThread().getName());
        }
    }
}

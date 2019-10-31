class Runner implements Runnable {
    @Override
    public void run() {
        Representation representation = new Representation();
        representation.increment();
    }
}

class MyNewThread extends Thread {
    private boolean running = true;

    public void run() {
        Representation representation = new Representation();
        representation.increment();
    }
}

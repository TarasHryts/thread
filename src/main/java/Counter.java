public class Counter {
    private int counter;

    public Counter() {
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void increment() {
        counter++;
    }
}

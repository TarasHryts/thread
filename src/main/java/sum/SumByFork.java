package sum;

import java.util.concurrent.ForkJoinPool;

public class SumByFork {
    private static final Long NUMBER_OF_OPERATIONS = 1000000L;
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(NUMBER_OF_THREADS);
        System.out.println(new MyFork(0L, NUMBER_OF_OPERATIONS).compute());
    }
}

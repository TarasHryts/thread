package sum;

import java.util.concurrent.RecursiveTask;

class MyFork extends RecursiveTask<Long> {
    private static Long NUMBER_OF_OPERATIONS = 1000000L;
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    private Long from;
    private Long to;

    public MyFork(Long from, Long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if ((to - from) <= NUMBER_OF_OPERATIONS / NUMBER_OF_THREADS) {
            Long j = 0L;
            for (Long i = from; i < to; i++) {
                j += i;
            }
            return j;
        } else {
            Long middle = (to - from) / 2;
            MyFork firstHalf = new MyFork(from, middle);
            firstHalf.fork();
            MyFork secondHalf = new MyFork(from + middle, to);
            secondHalf.fork();
            return firstHalf.join() + secondHalf.join();
        }
    }
}
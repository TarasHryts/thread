package sum;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumByFork {
    static Long NUMBER_OF_OPERATIONS = 1000000L;
    static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(NUMBER_OF_THREADS);
        System.out.println(new MyFork(0L, NUMBER_OF_OPERATIONS).compute());
    }

    static class MyFork extends RecursiveTask<Long> {
        Long from;
        Long to;

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
}

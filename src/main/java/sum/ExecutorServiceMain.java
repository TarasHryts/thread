package sum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMain {
    private static final Long NUMBER_OF_OPERATIONS = 1_000_000L;
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Long> longList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
            longList.add(1L);
        }
        List<Future<Long>> streamsList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            List<Long> subList = longList
                    .subList((int) (NUMBER_OF_OPERATIONS * i / NUMBER_OF_THREADS),
                            (int) (NUMBER_OF_OPERATIONS * (i + 1) / NUMBER_OF_THREADS));
            MyThread myThread = new MyThread(subList);
            streamsList.add(executorService.submit(myThread));
        }
        executorService.shutdown();
        Long sum = streamsList.stream().mapToLong(x -> {
            try {
                return x.get().longValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return 0;
        }).sum();
        System.out.println(sum);
    }
}

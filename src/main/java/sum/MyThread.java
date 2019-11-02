package sum;

import java.util.List;
import java.util.concurrent.Callable;

public class MyThread implements Callable<Long> {
    List<Long> longList;

    public MyThread(List<Long> longList) {
        this.longList = longList;
    }

    @Override
    public Long call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return longList.stream().mapToLong(Long::longValue).sum();
    }
}

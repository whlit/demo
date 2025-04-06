package com.whlit.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Executor {

    private final int coreSize;
    private final int maxSize;

    private final long timeout;
    private final TimeUnit unit;

    private final List<Work> works = new ArrayList<>();
    private final BlockingQueue<Runnable> queue;

    private final ThreadFactory factory;
    private final Consumer<Runnable> reject;

    public Executor(Integer coreSize, Integer maxSize, Long timeout, TimeUnit unit, BlockingQueue<Runnable> queue,
                    ThreadFactory factory, Consumer<Runnable> reject) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.timeout = timeout;
        this.unit = unit;
        this.reject = reject;
        this.queue = queue;
        this.factory = factory;
    }

    public void execute(Runnable job) {
        if (works.size() < coreSize) {
            addWork(job);
            return;
        }
        if (queue.offer(job)) {
            return;
        }
        if (works.size() < maxSize) {
            addWork(job);
            return;
        }
        reject.accept(job);
    }

    private void addWork(Runnable job) {
        Work work = new Work(job);
        synchronized (works) {
            works.add(work);
        }
        factory.newThread(work).start();
    }

    private class Work implements Runnable {

        private Runnable job;

        public Work(Runnable job) {
            this.job = job;
        }

        @Override
        public void run() {
            job.run();

            while (true) {
                try {
                    job = queue.poll(timeout, unit);
                    if (job != null) {
                        job.run();
                        continue;
                    }
                    if (works.size() > coreSize) {
                        synchronized (works) {
                            works.remove(this);
                        }
                        break;
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}

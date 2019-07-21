package com.doctor.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 编码规则：创建线程池指定有意义的名称，方便出错时回溯。
 *
 * @author cuikexiang
 * @date 2019-07-20
 */
public class ThreadFactory {
    public static void main(String[] args) {

        DefaultThreadFactory threadFactory = new DefaultThreadFactory("sdcuike-test");
        threadFactory.newThread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        }).start();

        BasicThreadFactory basicThreadFactory = new BasicThreadFactory.Builder()
                .namingPattern("sdcuike-thread-%d-")
                .daemon(false)
                .priority(Thread.NORM_PRIORITY).
                        build();

        basicThreadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    static class DefaultThreadFactory implements java.util.concurrent.ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory(String namePrefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = namePrefix + "-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }

            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }

            return t;
        }
    }

}

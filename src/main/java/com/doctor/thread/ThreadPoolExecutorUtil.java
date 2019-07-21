package com.doctor.thread;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月16日 上午12:29:41
 */
public final class ThreadPoolExecutorUtil {

    public static void main(String[] args) {
        System.out.println(Math.abs( "cbs_hermes-deliver_devices-push-common-consumer-group".hashCode())%50);
    }
    public static ThreadPoolExecutorInfo getInfo(ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutorInfo threadPoolExecutorInfo = new ThreadPoolExecutorInfo();
        threadPoolExecutorInfo.activeCount = threadPoolExecutor.getActiveCount();
        threadPoolExecutorInfo.taskCount = threadPoolExecutor.getTaskCount();
        threadPoolExecutorInfo.largestPoolSize = threadPoolExecutor.getLargestPoolSize();
        threadPoolExecutorInfo.maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
        threadPoolExecutorInfo.poolSize = threadPoolExecutor.getPoolSize();
        threadPoolExecutorInfo.corePoolSize = threadPoolExecutor.getCorePoolSize();
        threadPoolExecutorInfo.queueSize = threadPoolExecutor.getQueue().size();
        return threadPoolExecutorInfo;
    }

    public static final class ThreadPoolExecutorInfo {
        private int activeCount;
        private long completedTaskCount;
        private long taskCount;
        private int largestPoolSize;
        private int maximumPoolSize;
        private int poolSize;
        private int corePoolSize;
        private int queueSize;

        public int getActiveCount() {
            return activeCount;
        }

        public void setActiveCount(int activeCount) {
            this.activeCount = activeCount;
        }

        public long getCompletedTaskCount() {
            return completedTaskCount;
        }

        public void setCompletedTaskCount(long completedTaskCount) {
            this.completedTaskCount = completedTaskCount;
        }

        public long getTaskCount() {
            return taskCount;
        }

        public void setTaskCount(long taskCount) {
            this.taskCount = taskCount;
        }

        public int getLargestPoolSize() {
            return largestPoolSize;
        }

        public void setLargestPoolSize(int largestPoolSize) {
            this.largestPoolSize = largestPoolSize;
        }

        public int getMaximumPoolSize() {
            return maximumPoolSize;
        }

        public void setMaximumPoolSize(int maximumPoolSize) {
            this.maximumPoolSize = maximumPoolSize;
        }

        public int getPoolSize() {
            return poolSize;
        }

        public void setPoolSize(int poolSize) {
            this.poolSize = poolSize;
        }

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getQueueSize() {
            return queueSize;
        }

        public void setQueueSize(int queueSize) {
            this.queueSize = queueSize;
        }

        @Override
        public String toString() {
            return "ThreadPoolExecutorInfo [activeCount=" + activeCount + ", completedTaskCount=" + completedTaskCount + ", taskCount=" + taskCount + ", largestPoolSize=" + largestPoolSize + ", maximumPoolSize=" + maximumPoolSize + ", poolSize=" + poolSize + ", corePoolSize=" + corePoolSize
                    + ", queueSize=" + queueSize + "]";
        }

    }
}

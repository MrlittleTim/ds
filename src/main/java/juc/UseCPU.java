package juc;

import java.util.HashMap;

/**
 * @author tim
 * @date 2024/6/5
 */

public class UseCPU {


    private static final int THREAD_COUNT = 16;
    private static final int ITEM_COUNT = 1000000;
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        // 启动多个线程同时向HashMap中添加数据
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITEM_COUNT; j++) {
                    map.put((int) (Math.random() * ITEM_COUNT), (int) (Math.random() * ITEM_COUNT));
                }
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished");
    }




//    public static void main(String[] args) {
//        int numThreads = Runtime.getRuntime().availableProcessors(); // 获取可用处理器数
//        System.out.println("Starting " + numThreads + " threads to burn CPU");
//        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
//        for (int i = 0; i < numThreads; i++) {
//            CompletableFuture.runAsync(() -> {
//                while (true) {
//
//                }
//            }, executor);
//        }
//    }
}

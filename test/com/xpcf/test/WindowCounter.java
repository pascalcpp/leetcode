//package com.xpcf.test;
//
//import lombok.Getter;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.FluxSink;
//import reactor.core.publisher.Mono;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.concurrent.atomic.AtomicReference;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
///**
// * IP 滑动窗口计数
// *
// * @author zhangyang
// * @date 2021-05-07
// */
//public class WindowCounter {
//
//    /**
//     * 计数器
//     */
//    private static class Counter {
//
//        public static Counter EMPTY = new Counter();
//
//        private AtomicLong count = new AtomicLong(0L);
//
//        Counter increment(String empty) {
//            this.count.incrementAndGet();
//            return this;
//        }
//
//        Counter addCounter(Counter counter) {
//            this.count.addAndGet(counter.count.get());
//            return this;
//        }
//
//        public long count() {
//            return count.get();
//        }
//    }
//
//
//    /**
//     * IP 请求计数滑动窗口
//     */
//    public static class CounterStream implements Consumer<FluxSink<String>> {
//
//        private volatile static Map<String, CounterStream> streamMap = new ConcurrentHashMap<>();
//
//        /**
//         * 计数器流
//         */
//        private Flux<Counter> counterStream;
//
//        /**
//         * 滑动窗口的时间桶
//         */
//        @Getter
//        private final int numBuckets;
//
//        /**
//         * 每个窗口的时间大小
//         */
//        @Getter
//        private final int bucketSizeInMs;
//
//        /**
//         * ip事件
//         */
//        private FluxSink<String> ipSink;
//
//        private String ipAddress;
//
//        private final AtomicBoolean isSourceCurrentlySubscribed = new AtomicBoolean(false);
//
//        private AtomicReference<Counter> reference = new AtomicReference<>();
//
//        public CounterStream(int numBuckets, int bucketSizeInMs, String ipAddress) {
//            this.numBuckets = numBuckets;
//            this.bucketSizeInMs = bucketSizeInMs;
//            this.ipAddress = ipAddress;
//
//            //计入单位时间内的IP请求数量
//            Function<Flux<String>, Mono<Counter>> reduceBucketToSummary = ipFlux -> {
//                return ipFlux.reduceWith(Counter::new, Counter::increment);
//            };
//
//            //计算滑动窗口总时间内的请求数量
//            Function<Flux<Counter>, Flux<Counter>> reduceCounter = counterFlux -> {
//                return counterFlux.scanWith(Counter::new, Counter::addCounter).skip(numBuckets);
//            };
//
//            //see hystrix
//            //note: start it with empty arrays to make consumer logic as generic as possible (windows are always full)
//            // 首次将窗口填满，让窗口总是满的
//            final List<Counter> emptyEventCountsToStart = new ArrayList<>();
//
//            for (int i = 0; i < numBuckets; i++) {
//                emptyEventCountsToStart.add(new Counter());
//            }
//
//            this.counterStream = Flux.defer(() -> Flux.create(this)
//                    .window(Duration.ofMillis(bucketSizeInMs))
//                    .flatMap(reduceBucketToSummary)
//                    .startWith(emptyEventCountsToStart)
//            )
//                    .window(numBuckets, 1)
//                    .flatMap(reduceCounter)
//                    .doOnSubscribe(subscription -> isSourceCurrentlySubscribed.set(true))
//                    .doOnTerminate(() -> isSourceCurrentlySubscribed.set(false))
//                    .log()
//                    .onBackpressureDrop();
//
//            this.counterStream
//                    .doOnTerminate(()-> ipSink.complete())
//                    .subscribe(c -> reference.set(c), e -> ipSink.error(e));
//
//        }
//
//
//        @Override
//        public void accept(FluxSink<String> ipSink) {
//            this.ipSink = ipSink;
//        }
//
//        /**
//         * double check
//         *
//         * @param ipAddress      ip 地址
//         * @param numBuckets     window 窗口数量
//         * @param bucketSizeInMs 窗口的单位时间
//         */
//        public static CounterStream getInstance(String ipAddress, int numBuckets, int bucketSizeInMs) {
//            CounterStream counterStream = streamMap.get(ipAddress);
//            if (counterStream == null) {
//                synchronized (CounterStream.class) {
//                    counterStream = streamMap.get(ipAddress);
//                    if (counterStream == null) {
//                        CounterStream newStream = new CounterStream(numBuckets, bucketSizeInMs, ipAddress);
//                        streamMap.putIfAbsent(ipAddress, newStream);
//                        counterStream = newStream;
//                    }
//                }
//            }
//            return counterStream;
//        }
//
//        /**
//         * 统计请求数量
//         *
//         */
//        public void request() {
//            ipSink.next(ipAddress);
//        }
//
//        /**
//         * 获取当前请求的数量
//         */
//        public long getLast() {
//
//            if (reference.get() == null)
//                return 0L;
//
//            return reference.get().count();
//        }
//
//    }
//
//}

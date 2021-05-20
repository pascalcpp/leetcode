//package com.xpcf.test;
//
//import com.jonner.cloud.filter.WindowCounter.CounterStream;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.net.InetSocketAddress;
//import java.time.Duration;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * 网关流量监控，针对恶意流量封禁IP地址
// *
// * @author zhangyang
// * @date 2021-05-20
// */
//public class FlowMetricGlobalFilter implements GlobalFilter, InitializingBean {
//
//
//    /**
//     * 统计一天内封禁 IP的数量
//     */
//    public static final String STATICS_COUNTER_NAME = "IP:STATICS";
//
//
//    public static final String COUNTER_PREFIX = "EXPIRE:COUNTER:";
//
//    /**
//     * 窗口期内 IP 请求的最大值
//     */
//    private static final int MAX_REQUEST_TIME = 1000;
//
//    /**
//     * 首次封禁时间
//     */
//    private static final Duration START_TIME = Duration.ofMinutes(5);
//
//
//    private RedisTemplate<String, IpCounter> redisTemplate;
//
//    private static ScheduledExecutorService executorService
//            = new ScheduledThreadPoolExecutor(1);
//
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        executorService.scheduleAtFixedRate(this::syncIpCounter, 1, 1, TimeUnit.SECONDS);
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        //是否可以路由
//        boolean router = true;
//
//        ServerHttpRequest request = exchange.getRequest();
//        InetSocketAddress address = request.getRemoteAddress();
//        if (address != null) {
//            String hostAddress = address.getAddress().getHostAddress();
//
//            //判断当前IP 是否已经封禁
//            router = exists(hostAddress);
//
//            if (!router){
//                CounterStream counterStream = CounterStream.getInstance(hostAddress, 10, 1000);
//                counterStream.request();
//
//                //如果当前IP的请求数量已经达到最大值,那么直接封禁当前IP
//                if (counterStream.getLast() > MAX_REQUEST_TIME) {
//                    incrementForbidIp(hostAddress);
//                    router = false;
//                }
//            }
//        }
//
//        if (router) {
//            return chain.filter(exchange);
//        }
//
//        return Mono.error(new RuntimeException("请求次数过多"));
//
//    }
//
//    /**
//     * 判断该请求是否已经被封禁了，如果已经被封禁则直接跳过
//     *
//     * @param hostAddress 请求的Ip地址
//     */
//    private boolean exists(String hostAddress) {
//        Boolean exists = redisTemplate.hasKey(hostAddress);
//        return exists != null && exists;
//    }
//
//
//    /**
//     * 设置 IP 封禁的时间
//     * @param address 请求的IP地址
//     */
//    private void incrementForbidIp(String address) {
//
//        boolean isNew = false;
//        HashOperations<String, String, IpCounter> operations = redisTemplate.opsForHash();
//
//        IpCounter counter = operations.get(STATICS_COUNTER_NAME, address);
//
//        if (counter == null || !StringUtils.hasText(counter.ip)) {
//            counter = new IpCounter(address, START_TIME, 0);
//            operations.put(STATICS_COUNTER_NAME, address, counter);
//            isNew = true;
//        }
//
//        counter.increment();
//
//        if (!isNew) {
//            counter.expireTime = Duration.ofMinutes(START_TIME.toMinutes() * counter.getCount());
//        }
//
//        //设置IP的统计时间
//        redisTemplate.expire(STATICS_COUNTER_NAME, 1, TimeUnit.DAYS);
//
//        //设置IP的封禁时间
//        redisTemplate.opsForValue().set(COUNTER_PREFIX + address, IpCounter.EMPTY, counter.expireTime);
//
//
//    }
//
//
//
//   /* private void syncIpCounter() {
//        SetOperations<String, IpCounter> ipSet = redisTemplate.opsForSet();
//        Set<IpCounter> ipCounter = Optional.ofNullable(ipSet.members("ipCounter")).orElseGet(HashSet::new);
//        Map<String, IpCounter> ipCounterMap = new HashMap<>(counterMap);
//        for (IpCounter counter : ipCounter) {
//            LocalDateTime nowTime = LocalDateTime.now();
//            if (!counter.getStartTime().plus(counter.expireTime).isAfter(nowTime)) {
//                redisTemplate.delete(STATICS_COUNTER_NAME);
//                continue;
//            }
//
//            ipCounterMap.put(counter.getIp(), counter);
//        }
//        this.counterMap = ipCounterMap;
//    }*/
//
//
//    @Getter
//    @Setter
//    @AllArgsConstructor
//    private static class IpCounter {
//
//        static IpCounter EMPTY = new IpCounter(null);
//
//        //ip地址
//        private String ip;
//
//        //过期时间
//        private Duration expireTime;
//
//        //已经被屏蔽的次数
//        private long shutOutCount;
//
//        IpCounter(String ip) {
//            this.ip = ip;
//        }
//
//        public static IpCounter valueOf(String ip) {
//            return new IpCounter(ip);
//        }
//
//        public void increment() {
//            this.shutOutCount++;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (!(obj instanceof IpCounter))
//                return false;
//            return new EqualsBuilder().append(ip, ((IpCounter) obj).ip).isEquals();
//        }
//
//        @Override
//        public int hashCode() {
//            return new HashCodeBuilder()
//                    .append(ip).toHashCode();
//        }
//    }
//
//
//}
//

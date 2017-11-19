package bench;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.*;

public class Main {
    static HashMap<String, ArrayList<Long>> stats = new HashMap<>();
    static long startTime;

    public static void main(String[] args) throws IOException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        setupGC();

        int size = 500 * 1000;
        Stand stand = new Stand();
        stand.stand(size);
    }

    private static void setupGC() {
        startTime = System.currentTimeMillis();
        List<GarbageCollectorMXBean> gcbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcbean : gcbeans) {
            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            System.out.println(gcbean.getName());

            stats.put(gcbean.getName(), new ArrayList<>());

            NotificationListener listener = (notification, handback) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

                    long duration = info.getGcInfo().getDuration();
                    stats.get(info.getGcName()).add(duration);
                    printStats();
                }
            };

            emitter.addNotificationListener(listener, null, null);
        }
    }

    private static void printStats() {
        long appTime = System.currentTimeMillis() - startTime;
        for (String name : stats.keySet()){
            ArrayList<Long> list = stats.get(name);
            long totalTimeMS = list.stream().mapToLong(Long::longValue).sum();
            System.out.println("GC: " + name + ", runs: " + list.size() + ", duration: " + totalTimeMS + "/" + appTime);
        }
    }
}
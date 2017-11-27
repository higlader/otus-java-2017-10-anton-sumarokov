package bench;

/**
 * results:
 *  1) ParNew: runs: 7  time: 907
 *     ConcurrentMarkSweep: runs: 3 time: 602
 *
 *  2) PS Scavenge runs: 4  time: 281
 *     PS MarkSweep runs: 1  time: 711
 *
 *  3) Copy runs: 5 time: 473
 *     MarkSweepCompact runs: 1 time: 419
 *
 *  4) G1 Young Generation  runs:24   time:883
 *     G1 Old Generation    runs:4   time:1235
 */

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.*;
import java.util.List;
import java.lang.management.ThreadMXBean;

public class Main {
    static HashMap<String, ArrayList<Long>> stats = new HashMap<>();
    static long startTime;

    public static void main(String[] args) throws IOException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        runGC();

        int size = 500 * 1000;
        Stand stand = new Stand();
        stand.stand(size);
    }

    private static void runGC() {
        startTime = System.currentTimeMillis();
        List<GarbageCollectorMXBean> gcbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcbean : gcbeans) {
            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            System.out.println(gcbean.getName());

            stats.put(gcbean.getName(), new ArrayList<>());

            NotificationListener listener = (notification, handback) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo gcinfo = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

                    long duration = gcinfo.getGcInfo().getDuration();
                    stats.get(gcinfo.getGcName()).add(duration);
                    printStats();
                }
            };

            emitter.addNotificationListener(listener, null, null);
        }
    }

    private static void printStats() {
        JvmStatistics jvmStatistics = new JvmStatistics();
        for (String name : stats.keySet()){
            System.out.println("GC: " + name +  " young: " + jvmStatistics.getYoungGcCount() + " old: " + jvmStatistics.getFullGcCount() + " young time: " + jvmStatistics.getYoungGcTotalTime() + " oldtime: " + jvmStatistics.getFullGcTotalTime());
        }
    }

    public static class JvmStatistics implements JvmStatisticsMBean{

        private MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        private ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        private List<GarbageCollectorMXBean> gcList=ManagementFactory.getGarbageCollectorMXBeans();
        private List<String> youngGcNameList = new ArrayList<String>();
        private List<String> fullGcNameList = new ArrayList<String>();

        public JvmStatistics(){
            // Oracle (Sun) HotSpot
            youngGcNameList.add("Copy");
            youngGcNameList.add("ParNew");
            youngGcNameList.add("PS Scavenge");
            youngGcNameList.add("G1 Young Generation");
            fullGcNameList.add("MarkSweepCompact");
            fullGcNameList.add("PS MarkSweep");
            fullGcNameList.add("ConcurrentMarkSweep");
            fullGcNameList.add("G1 Old Generation");

            // JRocket
            youngGcNameList.add("Garbage collection optimized for short pausetimes Young Collector");
            youngGcNameList.add("Garbage collection optimized for throughput Young Collector");
            youngGcNameList.add("Garbage collection optimized for deterministic pausetimes Young Collector");
            fullGcNameList.add("Garbage collection optimized for short pausetimes Old Collector");
            fullGcNameList.add("Garbage collection optimized for throughput Old Collector");
            fullGcNameList.add("Garbage collection optimized for deterministic pausetimes Old Collector");

        }

        public long getHeapMemoryUse() {
            return memoryMXBean.getHeapMemoryUsage().getUsed();
        }
        public long getHeapMemoryMax() {
            return memoryMXBean.getHeapMemoryUsage().getMax();
        }
        public long getDaemonThreadCount() {
            return threadMXBean.getDaemonThreadCount();
        }
        public long getPeakThreadCount() {
            return threadMXBean.getPeakThreadCount();
        }

        public long getYoungGcCount() {
            int gcSize=gcList.size();
            long result=0;
            for (int i=0;i<gcSize;i++){
                GarbageCollectorMXBean gcMBean=gcList.get(i);
                String name=gcMBean.getName();
                if (youngGcNameList.contains(name)){
                    long tmp=gcMBean.getCollectionCount();
                    result= tmp>0 ? result+tmp : result;
                }
            }
            return result;
        }

        public long getYoungGcTotalTime() {
            int gcSize=gcList.size();
            long result=0;
            for (int i=0;i<gcSize;i++){
                GarbageCollectorMXBean gcMBean=gcList.get(i);
                String name=gcMBean.getName();
                if (youngGcNameList.contains(name)){
                    long tmp=gcMBean.getCollectionTime();
                    result= tmp>0 ? result+tmp : result;
                }
            }
            return result;
        }
        public long getFullGcCount() {
            int gcSize=gcList.size();
            long result=0;
            for (int i=0;i<gcSize;i++){
                GarbageCollectorMXBean gcMBean=gcList.get(i);
                String name=gcMBean.getName();
                if (fullGcNameList.contains(name)){
                    long tmp=gcMBean.getCollectionCount();
                    result= tmp>0 ? result+tmp : result;
                }
            }
            return result;
        }

        public long getFullGcTotalTime() {
            int gcSize=gcList.size();
            long result=0;
            for (int i=0;i<gcSize;i++){
                GarbageCollectorMXBean gcMBean=gcList.get(i);
                String name=gcMBean.getName();
                if (fullGcNameList.contains(name)){
                    long tmp=gcMBean.getCollectionTime();
                    result= tmp>0 ? result+tmp : result;
                }
            }
            return result;
        }

        public long getCurrentThreadCount() {
            return threadMXBean.getThreadCount();
        }

    }
}

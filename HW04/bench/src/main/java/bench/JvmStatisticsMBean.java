package bench;

/**
 * Created by anton on 20.11.17.
 */
public interface JvmStatisticsMBean {
    public long getHeapMemoryUse();
    public long getHeapMemoryMax();
    public long getDaemonThreadCount();
    public long getPeakThreadCount();
    public long getCurrentThreadCount();

    public long getYoungGcCount();
    public long getYoungGcTotalTime();
    public long getFullGcCount();
    public long getFullGcTotalTime();
}

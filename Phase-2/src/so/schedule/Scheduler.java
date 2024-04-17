package so.schedule;

import so.cpu.CpuManager;
import so.Process;

public abstract class Scheduler {
    private CpuManager cpu;

    public Scheduler() {
        this.cpu = new CpuManager();
    }

    public abstract void execute(Process p);

    public abstract void finish(Process p);

    public CpuManager getCpu() {
        return cpu;
    }
}

package so.schedule;

import so.cpu.CpuManager;
import so.Process;
import so.ProcessListener;

public abstract class Scheduler implements ProcessListener {
    private CpuManager cpu;

    public Scheduler() {
        this.cpu = new CpuManager(this);
    }

    public abstract void execute(Process p);

    public abstract void finish(Process p);

    public CpuManager getCpu() {
        return cpu;
    }
}

package so.schedule;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;

public class SchedulerQueue extends Scheduler {
    private PriorityQueue<Process> queue;
    private Hashtable<String, List<SubProcess>> SubProcess;

    public SchedulerQueue(Comparator<Process> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    @Override
    public void execute(Process p) {
        List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.READ_PROCESS, p);
        this.queue.add(p);
        this.SubProcess.put(p.getId(), sps);
        registerProcess();

    }

    private void registerProcess() {
        Process p = this.queue.poll();
        if (p != null) {
            List<SubProcess> sps = this.SubProcess.get(p.getId());
            Core[] cores = this.getCpu().getCores();
            for (Core core : cores) {
                if (core.getActuallyProcess() == null) {
                    SubProcess sp = sps.removeLast();
                    this.getCpu().registerProcess(core.getId(), sp);
                }
            }

        }
    }

    @Override
    public void finish(Process p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finish'");
    }

    public PriorityQueue<Process> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<Process> queue) {
        this.queue = queue;
    }
}

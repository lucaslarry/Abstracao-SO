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
    private Hashtable<String, List<SubProcess>> subProcesses;

    public SchedulerQueue(Comparator<Process> comparator) {
        this.queue = new PriorityQueue<>(comparator);
        this.subProcesses = new Hashtable<>();
    }

    @Override
    public void execute(Process p) {
        List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.READ_PROCESS, p);
        this.queue.add(p);
        this.subProcesses.put(p.getId(), sps);
        registerProcess();

    }

    private void registerProcess() {
        Core[] cores = this.getCpu().getCores();
        for (Core core : cores) {
            if (core.getActuallyProcess() == null) {
                this.coresExecuted(core.getId());
            }
        }
    }

    @Override
    public void coresExecuted(int coreId) {
        try {
            Process p = this.queue.peek();
            if (p != null) {
                List<SubProcess> sps = this.subProcesses.get(p.getId());
                if (this.subProcesses.get(p.getId()) == null || this.subProcesses.get(p.getId()).isEmpty()) {
                    this.queue.poll(); // Remove The first element
                    this.subProcesses.remove(p.getId());
                    p = this.queue.peek();
                    sps = this.subProcesses.get(p.getId());

                }
                SubProcess actuallySubprocess = sps.remove(0);
                this.getCpu().registerProcess(coreId, actuallySubprocess);

            }
        } catch (Exception e) {
            System.out.print("");
        }
    }

    @Override
    public void finish(Process p) {
        // TODO Auto-generated method stub

    }

    public PriorityQueue<Process> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<Process> queue) {
        this.queue = queue;
    }
}

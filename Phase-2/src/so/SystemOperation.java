package so;

import java.util.List;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.schedule.FCFS;
import so.schedule.Priority;
import so.schedule.SJF;
import so.schedule.Scheduler;

public class SystemOperation {
    private static MemoryManager mm;
    private static CpuManager cm;
    private static Scheduler scheduler;
    public static int MEMORY_SIZE = 256;
    public static int PAGE_SIZE = 4;

    public static CpuManager getCm() {
        return cm;
    }

    public static MemoryManager getMm() {
        return mm;
    }

    public static Scheduler getScheduler() {
        return scheduler;
    }

    public static void setCm(CpuManager cm) {
        SystemOperation.cm = cm;
    }

    public static void setMm(MemoryManager mm) {
        SystemOperation.mm = mm;
    }

    public static void setScheduler(Scheduler schedule) {
        SystemOperation.scheduler = schedule;
    }

    public static Process systemCall(SystemCallType type, int processSize) {
        if (type.equals(SystemCallType.CREATE_PROCESS)) {
            if (scheduler == null) {
                scheduler = new FCFS();
            }
            if (mm == null) {
                mm = new MemoryManager(MEMORY_SIZE, PAGE_SIZE);
            }
            return new Process(processSize);
        }
        return null;
    }

    public static Process systemCall(SystemCallType type, int processSize, int timeToExecute) {
        if (type.equals(SystemCallType.CREATE_PROCESS)) {
            if (scheduler == null) {
                scheduler = new SJF();
            }
            if (mm == null) {
                mm = new MemoryManager(MEMORY_SIZE, PAGE_SIZE);
            }
            return new Process(processSize, timeToExecute);
        }
        return null;
    }

    public static Process systemCall(SystemCallType type, int processSize, ProcessPriority priority) {
        if (type.equals(SystemCallType.CREATE_PROCESS)) {
            if (scheduler == null) {
                scheduler = new Priority();
            }
            if (mm == null) {
                mm = new MemoryManager(MEMORY_SIZE, PAGE_SIZE);
            }
            return new Process(processSize, priority);
        }
        return null;
    }

    public static List<SubProcess> systemCall(SystemCallType type, Process p) {
        if (type.equals(SystemCallType.WRITE_PROCESS)) {
            mm.write(p);
            scheduler.execute(p);
        }
        if (type.equals(SystemCallType.READ_PROCESS)) {
            scheduler.finish(p);
            return mm.read(p);
        }
        if (type.equals(SystemCallType.DELETE_PROCESS)) {
            mm.delete(p);
        }
        return null;
    }
}

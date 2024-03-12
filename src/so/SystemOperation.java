package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.Schedule;

public class SystemOperation {
    private static MemoryManager mm;
    private static CpuManager cm;
    private static Schedule schedule;

    public static CpuManager getCm() {
        return cm;
    }

    public static MemoryManager getMm() {
        return mm;
    }

    public static Schedule getSchedule() {
        return schedule;
    }

    public static void setCm(CpuManager cm) {
        SystemOperation.cm = cm;
    }

    public static void setMm(MemoryManager mm) {
        SystemOperation.mm = mm;
    }

    public static void setSchedule(Schedule schedule) {
        SystemOperation.schedule = schedule;
    }

    public static Process SystemCall(SystemCallType type, Process p) {
        if (type.equals(SystemCallType.WRITE_PROCESS)) {
            mm.write(p);

        }
        if (type.equals(SystemCallType.READ_PROCESS)) {
            System.out.println("Ler");
        }
        if (type.equals(SystemCallType.DELETE_PROCESS)) {
            System.out.println("Deletar");
        }
        if (type.equals(SystemCallType.CREATE_PROCESS)) {
            if (cm == null) {
                cm = new CpuManager();
            }
            if (mm == null) {
                mm = new MemoryManager(Strategy.BEST_FIT);

            }
            return new Process();
        }

        return null;
    }
}
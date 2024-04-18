package so.cpu;

import java.util.Timer;
import java.util.TimerTask;

import so.ProcessListener;
import so.SubProcess;

public class CpuManager {
    private Core[] cores;
    public static int NUM_OF_CORES = 4;
    public static int NUM_OF_INSTRUCTIONS = 7;
    public static long CLOCK = 500; // ms

    private ProcessListener listener;

    public CpuManager(ProcessListener listener) {
        this.cores = new Core[NUM_OF_CORES];
        for (int i = 0; i < this.cores.length; i++) {
            this.listener = listener;
            this.cores[i] = new Core(NUM_OF_INSTRUCTIONS, i, listener);
        }

        clock();
    }

    public void registerProcess(int coreId, SubProcess sp) {
        this.cores[coreId].setActuallyProcess(sp);
    }

    public void clock() {
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                executeProcess();
                Boolean teste = printProcessor();
                if (!teste) {
                    cancel();
                }
            }

        }, 0, CLOCK);
    }

    private void executeProcess() {
        int coreEmpty = 1;
        for (Core core : this.cores) {
            if (coreEmpty == NUM_OF_CORES) {
                break;
            }
            if (core.getActuallyProcess() != null) {
                core.run();

            } else {
                coreEmpty++;
            }

        }
    }

    public Core[] getCores() {
        return cores;
    }

    @SuppressWarnings("finally")
    private Boolean printProcessor() {
        String before = null;
        try {
            for (Core core : cores) {
                if (!core.getActuallyProcess().getProcessId().equals(before) && before != null) {
                    System.out.println("");
                    System.out.println("");
                    before = core.getActuallyProcess().getProcessId();
                }
                System.out.print("executed: " + core.getActuallyProcess().getId() + " | ");
                if (before == null) {
                    before = core.getActuallyProcess().getProcessId();
                }

            }
            System.out.println("");
        } catch (java.lang.NullPointerException e) {
            return false;
        } finally {
            return true;
        }

    }

}

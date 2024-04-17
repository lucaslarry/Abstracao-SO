package so.cpu;

import java.util.Timer;
import java.util.TimerTask;

import so.ProcessListener;
import so.SubProcess;

public class CpuManager {
    private Core[] cores;
    public static int NUM_OF_CORES = 4;
    public static int NUM_OF_INSTRUCTIONS = 7;
    public static long CLOCK = 3000; // ms

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
                printProcessor();
            }

        }, 0, CLOCK);
    }

    private void executeProcess() {
        for (Core core : this.cores) {
            if (core.getActuallyProcess() != null) {
                core.run();
            }
        }
    }

    public Core[] getCores() {
        return cores;
    }

    private void printProcessor() {
        SubProcess before = null;
        try {
            for (Core core : cores) {
                if (!core.getActuallyProcess().equals(before)) {
                    System.out.println("");
                    System.out.print("");
                    before = core.getActuallyProcess();
                }
                System.out.print("executed: " + core.getActuallyProcess().getId() + " | ");

            }
        } catch (java.lang.NullPointerException e) {
            System.out.println("");
        }

    }
}

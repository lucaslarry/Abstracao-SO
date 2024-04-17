package so.cpu;

import java.util.Timer;
import java.util.TimerTask;

import so.SubProcess;

public class CpuManager {
    private Core[] cores;
    public static int NUM_OF_CORES = 4;
    public static int NUM_OF_INSTRUCTIONS = 7;
    public static long CLOCK = 3000; // ms

    public CpuManager() {
        this.cores = new Core[NUM_OF_CORES];
        for (int i = 0; i < this.cores.length; i++) {
            this.cores[i] = new Core(NUM_OF_INSTRUCTIONS, i);
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
}

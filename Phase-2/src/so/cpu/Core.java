package so.cpu;

import so.ProcessListener;
import so.SubProcess;

public class Core implements Runnable {
    private int id;
    private SubProcess actuallyProcess;
    private int numOfInstructions; // per clock
    private int count;

    private ProcessListener listener;

    public Core(int numOfInstructions, int id, ProcessListener listener) {
        this.numOfInstructions = numOfInstructions;
        this.id = id;
        this.listener = listener;
    }

    @Override
    public void run() {
        count += numOfInstructions;
        if (count >= actuallyProcess.getInstructions()) {
            this.finish();
        }
    }

    private void finish() {
        this.actuallyProcess = null;
        this.count = 0;
        this.listener.coresExecuted(this.getId());
    }

    public SubProcess getActuallyProcess() {
        return actuallyProcess;
    }

    public void setActuallyProcess(SubProcess actuallyProcess) {
        this.actuallyProcess = actuallyProcess;
    }

    public int getId() {
        return id;
    }
}

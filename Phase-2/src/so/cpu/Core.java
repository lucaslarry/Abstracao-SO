package so.cpu;

import so.SubProcess;

public class Core implements Runnable {
    private int id;
    private SubProcess actuallyProcess;
    private int numOfInstructions; // per clock
    private int count;

    public Core(int numOfInstructions, int id) {
        this.numOfInstructions = numOfInstructions;
        this.id = id;
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

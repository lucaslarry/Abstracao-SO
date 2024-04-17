package so.schedule;

import so.Process;
import so.SubProcess;
import java.util.LinkedList;
import java.util.Random;

public class Lottery extends Scheduler {
    private LinkedList<SubProcess> processQueue = new LinkedList<>();

    public Lottery() {

    }

    @Override
    public void coresExecuted(int coreId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'coresExecuted'");
    }

    @Override
    public void execute(Process p) {
        Random rd = new Random();
        int random = rd.nextInt(64);

    }

    @Override
    public void finish(Process p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finish'");
    }

}
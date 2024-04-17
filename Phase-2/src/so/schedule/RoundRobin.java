package so.schedule;

import java.util.Comparator;

import so.Process;

public class RoundRobin extends SchedulerQueue {

    public RoundRobin(Comparator<Process> comparator) {
        super(new Comparator<Process>() {
            @Override
            public int compare(Process sp1, Process sp2) {
                return -1;
            }
        });

    }

}

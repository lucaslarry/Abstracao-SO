package so.schedule;

import java.util.Comparator;

import so.Process;

public class Priority extends SchedulerQueue {

    public Priority(Comparator<Process> comparator) {
        super(new Comparator<Process>() {
            @Override
            public int compare(Process sp1, Process sp2) {
                return sp1.getPriority().getLevel() >= sp2.getPriority().getLevel() ? 1 : -1;
            }
        });
    }

}

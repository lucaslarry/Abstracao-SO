package so;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Process {
    private String id;
    private int sizeInMemory;
    private List<String> subProcesses;
    public static int count;
    private int timeToExecute;
    private ProcessPriority priority;

    public Process(int sizeInMemory) {
        count++;
        this.id = "P" + count;
        this.sizeInMemory = sizeInMemory;
        this.subProcesses = this.getSubProcesses();
        Random rand = new Random();
        List<Integer> givenList = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000);
        this.timeToExecute = givenList.get(rand.nextInt(givenList.size()));

        List<ProcessPriority> priorityList = Arrays.asList(ProcessPriority.LOW, ProcessPriority.MEDIUM,
                ProcessPriority.HIGH,
                ProcessPriority.MAX);
        this.priority = priorityList.get(rand.nextInt(priorityList.size()));
    }

    public List<String> getSubProcesses() {
        if (this.subProcesses == null || this.subProcesses.isEmpty()) {
            this.subProcesses = new LinkedList<String>();
            for (int i = 0; i < this.sizeInMemory; i++) {
                this.subProcesses.add(this.getId() + i);
            }
        }
        return this.subProcesses;
    }

    public String getId() {
        return id;
    }

    public int getSizeInMemory() {
        return sizeInMemory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSizeInMemory(int sizeInMemory) {
        this.sizeInMemory = sizeInMemory;
    }

    public int getTimeToExecute() {
        return timeToExecute;
    }

    public ProcessPriority getPriority() {
        return priority;
    }
}

package so;

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
    private Ticket[] tickets;

    public Process(int sizeInMemory) {
        count++;
        this.id = "P" + count;
        this.sizeInMemory = sizeInMemory;
        this.subProcesses = this.getSubProcesses();
    }

    public Process(int sizeInMemory, Random rd, int quantityTickets) {
        count++;
        this.id = "P" + count;
        this.sizeInMemory = sizeInMemory;
        this.subProcesses = this.getSubProcesses();
        this.tickets = new Ticket[quantityTickets];
        deliverTickets(rd, quantityTickets);
        printTicketValue();
    }

    public Process(int sizeInMemory, int timeToExecute) {
        count++;
        this.id = "P" + count;
        this.sizeInMemory = sizeInMemory;
        this.subProcesses = this.getSubProcesses();
        this.timeToExecute = timeToExecute;
    }

    public Process(int sizeInMemory, ProcessPriority priority) {
        count++;
        this.id = "P" + count;
        this.sizeInMemory = sizeInMemory;
        this.subProcesses = this.getSubProcesses();
        this.priority = priority;
    }

    private void printTicketValue() {
        System.out.println("Total " + tickets.length + " Tickets for " + this.getId());
    }

    private void deliverTickets(Random rd, int quantityTickets) {
        for (int i = 0; i < quantityTickets; i++) {
            tickets[i] = new Ticket(rd.nextInt(100));
        }
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

    public Ticket[] getTicket() {
        return tickets;
    }
}

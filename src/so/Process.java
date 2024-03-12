package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {
    private String id;
    private int sizeInMemory;
    // private List<Process> processes;
    // private int timeToExecution;
    private AdressMemory adressInMemory;

    public Process() {
        Random r = new Random();
        this.id = UUID.randomUUID().toString();
        List<Integer> givenList = Arrays.asList(1, 2, 4, 5, 8, 10, 20, 50, 100);
        this.sizeInMemory = givenList.get(r.nextInt(givenList.size()));
    }

    public AdressMemory getAdressInMemory() {
        return adressInMemory;
    }

    public String getId() {
        return id;
    }

    public int getSizeInMemory() {
        return sizeInMemory;
    }

    public void setAdressInMemory(AdressMemory adressInMemory) {
        this.adressInMemory = adressInMemory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSizeInMemory(int sizeInMemory) {
        this.sizeInMemory = sizeInMemory;
    }
}

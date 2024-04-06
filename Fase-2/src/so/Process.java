package so;

import java.util.UUID;

import so.memory.AddressMemory;

public class Process {
    private String id;
    private int sizeInMemory;
    // private List<Process> processes;
    // private int timeToExecution;
    private AddressMemory addressInMemory;

    public Process(int sizeInMemory) {
        this.id = UUID.randomUUID().toString();
        this.sizeInMemory = sizeInMemory;
    }

    public AddressMemory getAddressInMemory() {
        return addressInMemory;
    }

    public String getId() {
        return id;
    }

    public int getSizeInMemory() {
        return sizeInMemory;
    }

    public void setAddressInMemory(AddressMemory addressInMemory) {
        this.addressInMemory = addressInMemory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSizeInMemory(int sizeInMemory) {
        this.sizeInMemory = sizeInMemory;
    }
}

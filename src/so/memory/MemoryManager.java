package so.memory;

import so.Process;

public class MemoryManager {
    private Strategy strategy;
    private String[] physicMemory;

    public MemoryManager(Strategy strategy) {
        this.strategy = strategy;
        this.physicMemory = new String[128];

    }

    public void write(Process p) {
        if (this.strategy.equals(Strategy.FIRST_FIT)) {
            this.writeUsingFirstFit(p);
        }
        if (this.strategy.equals(Strategy.BEST_FIT)) {
            this.writeUsingBestFit(p);
        }
        if (this.strategy.equals(Strategy.WORST_FIT)) {
            this.writeUsingWorstFit(p);
        }
        if (this.strategy.equals(Strategy.PAGING)) {
            this.writeUsingPaging(p);
        }

    }

    private void writeUsingPaging(Process p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeUsingPaging'");
    }

    private void writeUsingBestFit(Process p) {
        Integer index = null;
        int freeSpaces = 0;
        int actualSize = 0;
        for (int i = 0; i < physicMemory.length; i++) {
            if (i == (physicMemory.length - 1)) {
                if (index == null) {
                    index = i - actualSize;
                }

            }
            if (physicMemory[i] == null) {
                actualSize++;
            } else {
                if (actualSize > freeSpaces) {
                    index = i - comparator(p.getSizeInMemory(), actualSize, freeSpaces);
                    freeSpaces = actualSize;
                }
                actualSize = 0;
            }

        }
        int start = (index);
        int end = start + p.getSizeInMemory();
        AddressMemory address = createAddressMemory(start, end);
        if (p.getSizeInMemory() <= address.getSize()) {
            insertProcessInMemory(p, address);
        }

    }

    private void writeUsingWorstFit(Process p) {
        Integer index = null;
        int actualSize = 0;
        int freeSpaces = 0;
        for (int i = 0; i < physicMemory.length; i++) {
            if (physicMemory[i] == null) {
                actualSize++;
                if (actualSize > freeSpaces) {
                    index = i - freeSpaces;
                    freeSpaces = actualSize;

                }
            } else {
                actualSize = 0;
            }
        }

        if (index != null) {
            int start = (index);
            int end = start + p.getSizeInMemory();
            AddressMemory address = createAddressMemory(start, end);
            if (p.getSizeInMemory() <= address.getSize()) {
                insertProcessInMemory(p, address);
            }
        }
    }

    private void writeUsingFirstFit(Process p) {
        int actualSize = 0;
        for (int i = 0; i < physicMemory.length; i++) {
            if (i == (physicMemory.length - 1)) {
                if (actualSize > 0) {
                    int start = (i - actualSize);
                    int end = start + p.getSizeInMemory();
                    AddressMemory address = createAddressMemory(start, end);
                    if (p.getSizeInMemory() <= address.getSize()) {
                        insertProcessInMemory(p, address);
                        break;
                    }
                }
            } else if (physicMemory[i] == null) {
                actualSize++;
            } else {
                if (actualSize > 0) {
                    int start = (i - actualSize);
                    int end = start + p.getSizeInMemory();
                    AddressMemory address = createAddressMemory(start, end);
                    if (p.getSizeInMemory() <= address.getSize()) {
                        insertProcessInMemory(p, address);
                        break;
                    }
                    actualSize = 0;
                }

            }

        }

    }

    public void delete(Process p) {
        for (int i = 0; i < physicMemory.length; i++) {
            if (p.getId().equals(physicMemory[i])) {
                physicMemory[i] = null;
            }
        }
        System.out.println("==========================================================================");
        System.out
                .println("Processo: " + p.getId() + " deletado");
    }

    private void printMemoryStatus(Process p, AddressMemory address) {
        System.out.println("===========================================================================");
        System.out
                .println("Processo: " + p.getId() + " inserido do índice: : " + address.getStart() + " ao "
                        + address.getEnd());
    }

    private void insertProcessInMemory(Process p, AddressMemory address) {
        for (int i = address.getStart(); i <= address.getEnd(); i++) {
            this.physicMemory[i] = p.getId();
        }

        printMemoryStatus(p, address);
    }

    private AddressMemory createAddressMemory(int start, int end) {
        return new AddressMemory(start, end);
    }

    private int comparator(int comp, int num1, int num2) {
        int result1 = comp - num1;
        int result2 = comp - num2;
        if (result1 <= result2) {
            return num1;
        } else {
            return num2;
        }
    }
}

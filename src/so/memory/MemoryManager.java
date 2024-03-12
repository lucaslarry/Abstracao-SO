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
            if (i == physicMemory.length - 1) {
                index = i - freeSpaces;
            }
            if (physicMemory[i] == null) {
                actualSize++;
                if (actualSize > freeSpaces) {
                    if (comparator(p.getSizeInMemory(), actualSize, freeSpaces)) {
                        index = i - actualSize + 1;
                        freeSpaces = actualSize;
                    } else {
                        index = i - freeSpaces;
                        freeSpaces = actualSize;
                    }

                }
            } else {
                actualSize = 0;
            }
        }
        AdressMemory address = createAdressMemory(index, index + (freeSpaces - 1));
        if (p.getSizeInMemory() <= address.getSize()) {
            insertProcessInMemory(p, address);
        }

        printMemoryStatus();
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
            AdressMemory address = createAdressMemory(index, index + (freeSpaces - 1));
            if (p.getSizeInMemory() <= address.getSize()) {
                insertProcessInMemory(p, address);
            }
        }
        printMemoryStatus();
    }

    private void writeUsingFirstFit(Process p) {
        int actualSize = 0;
        for (int i = 0; i < physicMemory.length; i++) {
            if (i == (physicMemory.length - 1)) {
                if (actualSize > 0) {
                    AdressMemory adress = createAdressMemory((i - actualSize), i);
                    if (p.getSizeInMemory() <= adress.getSize()) {
                        insertProcessInMemory(p, adress);
                        break;
                    }
                }
            }
            if (physicMemory[i] == null) {
                actualSize++;
            } else {
                if (actualSize > 0) {
                    AdressMemory adress = createAdressMemory((i - actualSize), i);
                    if (p.getSizeInMemory() <= adress.getSize()) {
                        insertProcessInMemory(p, adress);
                        break;
                    }
                }
                actualSize = 0;

            }

        }
        printMemoryStatus();

    }

    private void printMemoryStatus() {
        for (int i = 0; i < physicMemory.length; i++) {
            System.out.print(physicMemory[i] + " : ");
        }
    }

    private void insertProcessInMemory(Process p, AdressMemory adress) {
        for (int i = adress.getStart(); i <= adress.getEnd(); i++) {
            this.physicMemory[i] = p.getId();
        }
    }

    private AdressMemory createAdressMemory(int start, int end) {
        return new AdressMemory(start, end);
    }

    private boolean comparator(int comp, int num1, int num2) {
        int result1 = comp - num1;
        int retult2 = comp - num2;
        if (result1 < retult2) {
            return true;
        } else {
            return false;
        }
    }
}

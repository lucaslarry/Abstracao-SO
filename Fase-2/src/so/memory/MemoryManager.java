package so.memory;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import so.Process;
import so.SubProcess;

public class MemoryManager {
    private SubProcess[][] physicalMemory;
    private Hashtable<String, FrameMemory> logicalMemory;
    private int pageSize;
    private int memorySize;

    public MemoryManager(int memorySize, int pageSize) {
        this.pageSize = pageSize;
        this.memorySize = memorySize;
        int pages = Math.round(this.memorySize / this.pageSize);
        this.physicalMemory = new SubProcess[memorySize][pages];
        this.logicalMemory = new Hashtable<>();

    }

    public void write(Process p) {
        /*
         * if (this.strategy.equals(Strategy.FIRST_FIT)) {
         * this.writeUsingFirstFit(p);
         * }
         * if (this.strategy.equals(Strategy.BEST_FIT)) {
         * this.writeUsingBestFit(p);
         * }
         * if (this.strategy.equals(Strategy.WORST_FIT)) {
         * this.writeUsingWorstFit(p);
         * }
         * if (this.strategy.equals(Strategy.PAGING)) {
         * this.writeUsingPaging(p);
         * }
         */

    }

    private List<FrameMemory> getFrames(Process p) {
        List<SubProcess> processes = p.getSubProcesses();
        int actuallyProcessSize = 0;
        List<FrameMemory> frames = new LinkedList<>();
        for (int frame = 0; frame < this.physicalMemory.length; frame++) {
            if (this.physicalMemory[frame][0] == null) {
                frames.add(new FrameMemory(frame, 0));
                actuallyProcessSize += this.pageSize;
                if (actuallyProcessSize >= p.getSizeInMemory()) {
                    return frames;
                }
            }

        }
        return null;

    }

    private void writeUsingPaging(Process p) {

    }

    private void writeUsingBestFit(Process p) {
        Integer index = null;
        int actualSize = 0;
        int freeSpaces = physicalMemory.length;
        for (int i = 0; i < physicalMemory.length; i++) {
            if (i == physicalMemory.length - 1) {
                if (actualSize > 0 || actualSize == p.getSizeInMemory()) {
                    if (actualSize < freeSpaces) {
                        index = i - actualSize;
                    }
                }

            }
            if (physicalMemory[i] == null) {
                actualSize++;
            } else {
                if (actualSize > 0) {
                    if (actualSize < freeSpaces && actualSize >= p.getSizeInMemory()) {
                        index = i - actualSize;
                        freeSpaces = actualSize;
                    }
                }
                actualSize = 0;
            }

        }

        if (index != null) {
            int start = (index);
            int end = start + p.getSizeInMemory();
            AddressMemory address = createAddressMemory(start, end);
            if (p.getSizeInMemory() <= address.getSize() && end <= physicalMemory.length - 1) {
                insertProcessInMemory(p, address);
            } else {
                System.out.println("===========================================================================");
                System.out.println("Insufficient memory!! Unable to add process: " + p.getId());
            }
        }

    }

    private void writeUsingWorstFit(Process p) {
        Integer index = null;
        int actualSize = 0;
        int freeSpaces = 0;
        for (int i = 0; i < physicalMemory.length; i++) {
            if (physicalMemory[i] == null) {
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
            if (p.getSizeInMemory() <= address.getSize() && end <= physicalMemory.length - 1) {
                insertProcessInMemory(p, address);
            } else {
                System.out.println("===========================================================================");
                System.out.println("Insufficient memory!! Unable to add process:  " + p.getId());
            }
        }
    }

    private void writeUsingFirstFit(Process p) {
        int actualSize = 0;
        for (int i = 0; i < physicalMemory.length; i++) {
            if (actualSize == (p.getSizeInMemory() + 1)) {
                int start = i - actualSize;
                int end = start + p.getSizeInMemory();
                AddressMemory address = createAddressMemory(start, end);
                if (p.getSizeInMemory() <= address.getSize()) {
                    insertProcessInMemory(p, address);
                    actualSize = -1;
                    break;
                }
            }
            if (physicalMemory[i] == null) {
                actualSize++;
            } else {
                if (actualSize > 0) {
                    if (actualSize == (p.getSizeInMemory() + 1)) {
                        int start = i - actualSize;
                        int end = start + p.getSizeInMemory();
                        AddressMemory address = createAddressMemory(start, end);
                        if (p.getSizeInMemory() <= address.getSize()) {
                            insertProcessInMemory(p, address);
                            actualSize = -1;
                            break;
                        }
                    }
                    actualSize = 0;
                }
            }

        }
        if (actualSize != -1) {
            System.out.println("===========================================================================");
            System.out.println("Insufficient memory!! Unable to add process: " + p.getId());
        }

    }

    public void delete(Process p) {
        List<FrameMemory> frames = this.logicalMemory.get(p.getId());
        for (int i = 0; i < frames.size(); i++) {
            FrameMemory actuallyFrame = frames.get(i);
            for (int j = actuallyFrame.getPageNum(); j < actuallyFrame.getDisplacement(); j++) {
                this.physicalMemory[j] = null;
            }
        }
        System.out.println("==========================================================================");
        System.out.println("Process: " + p.getId() + " deleted");

    }

    private void printMemoryStatus(Process p, AddressMemory address) {
        System.out.println("===========================================================================");
        System.out
                .println("Process: " + p.getId() + " inserted from index: : " + address.getStart() + " to "
                        + address.getEnd());
    }

    private void insertProcessInMemory(Process p, AddressMemory address) {
        for (int i = address.getStart(); i <= address.getEnd(); i++) {
            this.physicalMemory[i] = p.getId();
        }

        printMemoryStatus(p, address);
    }

    private AddressMemory createAddressMemory(int start, int end) {
        return new AddressMemory(start, end);
    }

}
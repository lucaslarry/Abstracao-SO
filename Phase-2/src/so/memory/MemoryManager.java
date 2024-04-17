package so.memory;

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
    public static int NUM_OF_INSTRUCTIONS_PER_PROCESS = 7;

    public MemoryManager(int memorySize, int pageSize) {
        this.pageSize = pageSize;
        this.memorySize = memorySize;
        int pages = Math.round(this.memorySize / this.pageSize);
        this.physicalMemory = new SubProcess[memorySize][pages];
        this.logicalMemory = new Hashtable<>();

    }

    public void write(Process p) {
        this.writeUsingPaging(p);

    }

    private void writeUsingPaging(Process p) {
        List<FrameMemory> frames = this.getFrames(p);

        if (frames != null) {
            for (int frame = 0; frame < frames.size(); frame++) {
                for (int offset = 0; offset < this.pageSize; offset++) {
                    FrameMemory actuallyFrame = frames.get(frame);
                    SubProcess sp = new SubProcess(p.getId(), NUM_OF_INSTRUCTIONS_PER_PROCESS);
                    this.physicalMemory[actuallyFrame.getPageNum()][offset] = sp;
                    actuallyFrame.setOffSet(offset);
                    this.logicalMemory.put(sp.getId(), actuallyFrame);
                }
            }
        } else {
            System.out.println("erro memoria full");
        }
        printMemoryStatus();
    }

    private List<FrameMemory> getFrames(Process p) {
        int numOfPages = Math.round(p.getSizeInMemory() / this.pageSize);
        List<FrameMemory> frames = new LinkedList<>();
        for (int frame = 0; frame < this.physicalMemory.length; frame++) {
            if (this.physicalMemory[frame][0] == null) {
                frames.add(new FrameMemory(frame));
                if (numOfPages == frames.size()) {
                    return frames;
                }
            }
        }
        return null;

    }

    public void delete(Process p) {

        System.out.println("==========================================================================");
        System.out.println("Process: " + p.getId() + " deleted");

    }

    private void printMemoryStatus() {
        for (int i = 0; i < this.physicalMemory.length; i++) {
            for (int j = 0; j < this.pageSize; j++) {
                if (j == (this.pageSize) - 1) {
                    if (this.physicalMemory[i][j] != null) {
                        System.out.println(this.physicalMemory[i][j].getId());
                    } else {
                        System.out.println(this.physicalMemory[i][j]);
                    }

                } else {
                    if (this.physicalMemory[i][j] != null) {
                        System.out.print(this.physicalMemory[i][j].getId() + " : ");
                    } else {
                        System.out.print(this.physicalMemory[i][j] + " : ");
                    }
                }
            }
        }
    }

    public List<SubProcess> read(Process p) {
        List<String> ids = p.getSubProcesses();
        List<SubProcess> sps = new LinkedList<>();
        for (String id : ids) {
            FrameMemory fm = this.logicalMemory.get(id);
            sps.add(this.physicalMemory[fm.getPageNum()][fm.getOffSet()]);
        }
        return sps;
    }

}
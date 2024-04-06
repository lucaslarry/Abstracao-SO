package so;

public class SubProcess {
    private String id;
    private int instructions;
    public static int count;

    public SubProcess(String processId, int instructions) {
        count++;
        this.id = processId + count;
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public int getInstructions() {
        return instructions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInstructions(int instructions) {
        this.instructions = instructions;
    }
}

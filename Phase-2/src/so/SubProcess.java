package so;

public class SubProcess {
    private String id;
    private String processId;
    private int instructions;

    public static int count;

    public SubProcess(String processId, int instructions) {
        this.processId = processId;
        this.id = processId + count;
        this.instructions = instructions;
        count++;
    }

    public String getId() {
        return id;
    }

    public int getInstructions() {
        return instructions;
    }

    public static int getCount() {
        return count;
    }

    public String getProcessId() {
        return processId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInstructions(int instructions) {
        this.instructions = instructions;
    }

    public static void setCount(int count) {
        SubProcess.count = count;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

}

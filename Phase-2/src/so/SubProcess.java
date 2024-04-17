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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((processId == null) ? 0 : processId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SubProcess other = (SubProcess) obj;
        if (processId == null) {
            if (other.processId != null)
                return false;
        } else if (!processId.equals(other.processId))
            return false;
        return true;
    }

}

package so.memory;

public class AddressMemory {
    private int start;
    private int end;

    public AddressMemory(int start, int end) {
        this.start = start;
        this.end = end;

    }

    public int getSize() {
        return (this.end - this.start) + 1;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

}

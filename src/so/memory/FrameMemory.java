package so.memory;

public class FrameMemory {
    private int pageNum;
    private int displacement;

    public FrameMemory(int pageNum, int displacement){
        this.pageNum = pageNum;
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return displacement;
    }
    public int getPageNum() {
        return pageNum;
    }
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    }

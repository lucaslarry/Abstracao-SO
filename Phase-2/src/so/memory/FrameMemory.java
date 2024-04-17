package so.memory;

public class FrameMemory {
    private int pageNum;
    private int offSet;

    public FrameMemory(int pageNum, int offSet) {
        this.pageNum = pageNum;
        this.offSet = offSet;
    }

    public FrameMemory(int pageNum) {
        this(pageNum, 0);
    }

    public int getOffSet() {
        return offSet;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}

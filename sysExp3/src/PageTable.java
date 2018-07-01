/**
 * Created by xixi on 29/06/2017.
 */
public class PageTable {
    private int pageNum;
    private boolean flag;
    private int blockNum;
    private boolean modifyFlag;
    private int location;


    public PageTable(){}

    public PageTable(int pageNum, boolean flag, int blockNum, boolean modifyFlag, int location) {
        this.pageNum = pageNum;
        this.flag = flag;
        this.blockNum = blockNum;
        this.modifyFlag = modifyFlag;
        this.location = location;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(int blockNum) {
        this.blockNum = blockNum;
    }

    public boolean isModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(boolean modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}

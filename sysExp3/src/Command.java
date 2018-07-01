/**
 * Created by xixi on 29/06/2017.
 */
public class Command {
    private String operation;
    private int pageNum;
    private int unitNUm;

    public Command(String operation, int pageNum, int unitNUm) {
        this.operation = operation;
        this.pageNum = pageNum;
        this.unitNUm = unitNUm;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getUnitNUm() {
        return unitNUm;
    }

    public void setUnitNUm(int unitNUm) {
        this.unitNUm = unitNUm;
    }
}

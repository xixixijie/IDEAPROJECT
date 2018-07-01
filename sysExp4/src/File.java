import java.util.Random;

/**
 * Created by xixi on 29/06/2017.
 */
public class File extends Ob{
    private String ptCode;
    private String address;
    private String contain;
    private int offset;

    public File(){
        super();
    }

    public File(String name){
        super(name);
        ptCode="111";
        address=""+99999999;
        contain="";
    }

    public String getPtCode() {
        return ptCode;
    }

    public void setPtCode(String ptCode) {
        this.ptCode = ptCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain += contain;
        offset=contain.length();
    }

    public void open(){
        System.out.println(contain);
    }
}

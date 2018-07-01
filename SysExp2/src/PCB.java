/**
 * Created by xixi on 22/06/2017.
 */
public class PCB {
    private String name;
    private PCB nextp;
    private int needTime;
    private int runTime;
    private String states;
    //states R-就绪 W-运行 E-结束


    public PCB(String name, int needTime, int runTime, String states) {
        this.name = name;
        this.needTime = needTime;
        this.runTime = runTime;
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PCB getNextp() {
        return nextp;
    }

    public void setNextp(PCB nextp) {
        this.nextp = nextp;
    }

    public int getNeedTime() {
        return needTime;
    }

    public void setNeedTime(int needTime) {
        this.needTime = needTime;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
}

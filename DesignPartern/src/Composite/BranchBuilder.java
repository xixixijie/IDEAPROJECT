package Composite;

/**
 * Created by xixi on 2017/10/9.
 */
public class BranchBuilder implements Builder{

    public static Component componentBuild(String name){
        Component component=new Branch(name);
        return component;
    }
}

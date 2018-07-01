package Composite;

/**
 * Created by xixi on 2017/10/9.
 */
public class LeafBuilder implements Builder{
    public static Component componentBuild(String name){
        Component component=new Leaf(name);
        return component;
    }
}

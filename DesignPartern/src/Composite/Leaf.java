package Composite;



/**
 * Created by xixi on 2017/10/9.
 */
public class Leaf extends Component{
    public Leaf(String name){
        this.leftChild=null;
        this.rightChild=null;
        this.name=name;
    }
}

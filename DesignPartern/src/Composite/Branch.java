package Composite;

/**
 * Created by xixi on 2017/10/9.
 */
public class Branch extends Component {


    public Branch(String name){
        this.name=name;
        leftChild=new Component();
        rightChild=new Component();
    }

    public void setLeftChild(Component c){
        this.leftChild=c;
    }

    public void setRightChild(Component c){
        this.rightChild=c;
    }
}

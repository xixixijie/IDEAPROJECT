package Composite;

import java.util.ArrayList;

/**
 * Created by xixi on 2017/10/9.
 */
public class Client {
    public static void main(String[] args) {
        int layer = 4;
        Component root = null;
        ArrayList<Component> nodes = new ArrayList<>();
        Component nowParent = null;
        for (int i = 0; i < Math.pow(2, layer) - 1; i++) {
            String name = "Level";

            if (i == 0) {
                name += "_" + 1;
            } else {
                //System.out.println((i-1)/2);
                Component parent = nodes.get((i - 1) / 2);

                String parentName = parent.name;
                String[] strs = parentName.split("_");
                int[] temp = new int[strs.length - 1];
                for (int j = 1; j < strs.length; j++) {
                    if (j == 1) {
                        temp[j - 1] = Integer.parseInt(strs[j]) + 1;
                    } else {
                        temp[j - 1] = Integer.parseInt(strs[j]);
                    }
                }

                for (int j = 0; j < temp.length; j++) {
                    name += "_" + temp[j];
                }

                if (parent != nowParent) {
                    name += "_1";
                    nowParent = parent;
                } else {
                    name += "_2";
                }
            }

            //System.out.println(name);
            //创建节点
            if (i < Math.pow(2, layer - 1) - 1) {
                nodes.add(BranchBuilder.componentBuild(name));
            } else {
                nodes.add(LeafBuilder.componentBuild(name));
            }
        }

        root = turnArrayToTree(nodes, layer);

        print(root);
    }


    public static Branch turnArrayToTree(ArrayList<Component> nodes, int layer) {
        Branch parent = null;
        for (int i = 0; i < Math.pow(2, layer - 1) - 1; i++) {
            parent = (Branch) nodes.get(i);
            parent.setLeftChild(nodes.get(2 * i + 1));
            parent.setRightChild(nodes.get(2 * i + 2));
        }
        return (Branch) nodes.get(0);
    }

    public static void print(Component root){
        String[] strs=root.name.split("_");
        int layer=Integer.parseInt(strs[1]);
        String blank="      ";
        if(layer==1){
            blank="";
        }
        while(--layer>0){
            blank+=blank;
        }

        System.out.println(blank+root.name);
        if(root.leftChild!=null){
            print(root.leftChild);
        }
        if(root.rightChild!=null){
            print(root.rightChild);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 29/06/2017.
 */
public class Dir extends Ob {
    private List<Ob> list;

    public Dir(){
        list=new ArrayList<>();
    }
    public Dir(String name) {
        super(name);
        list=new ArrayList<>();
    }

    public void add(Ob ob){
        list.add(ob);
    }

    public void delete(String name){
        for(Ob ob:list){
            if(ob.getName().equals(name)){
                list.remove(ob);
                return;
            }
        }
        System.out.println("this file not found");
    }

    public void deleteTheLast(){
        list.remove(list.size()-1);
    }

    public List<Ob> getList() {
        return list;
    }

    public void setList(List<Ob> list) {
        this.list = list;
    }

    public Ob get(String name){
        for(Ob ob:list){
            if(ob.getName().equals(name)){
               return ob;
            }
        }
        return null;
    }

    public void ls(){
        int n=0;
        for(Ob ob:list){

            System.out.print(ob.getName()+" ");
            if(n%4==0){
                System.out.println();
            }
        }
    }

}

import java.util.Comparator;

/**
 * Created by xixi on 29/06/2017.
 */
public class test {
    private static int blockLength=128;
    public static void main(String[] args) {
        PageTable[] pt=new PageTable[7];
        pt[0]=new PageTable(0,true,5,false,11);
        pt[1]=new PageTable(1,true,8,false,12);
        pt[2]=new PageTable(2,true,9,false,13);
        pt[3]=new PageTable(3,true,1,false,21);
        pt[4]=new PageTable(4,false,0,false,22);
        pt[5]=new PageTable(5,false,0,false,23);
        pt[6]=new PageTable(6,false,0,false,121);



//        Command c=new Command("+",0,070);
        Command cs[]=new Command[12];
        cs[0]=new Command("+",0,70);
        cs[1]=new Command("M",4,53);
        cs[2]=new Command("+",1,50);
        cs[3]=new Command("+",5,23);
        cs[4]=new Command("*",2,15);
        cs[5]=new Command("S",1,37);
        cs[6]=new Command("S",3,21);
        cs[7]=new Command("G",2,78);
        cs[8]=new Command("G",0,56);
        cs[9]=new Command("+",4,1);
        cs[10]=new Command("-",6,40);
        cs[11]=new Command("S",6,84);
        PageTable p=new PageTable();
        int m=0;
        for(PageTable pageTable:pt){
            if(pageTable.isFlag()){
                m++;
            }
        }
        int P[]={0,1,2,3};
        int k=0;
        for(int i=0;i<cs.length;i++){
            System.out.println("操作"+i);
            Command c=cs[i];
            //获得页号
            int pageNum=c.getPageNum();

            //查页表
            for(PageTable temp:pt){
                if(temp.getPageNum()==pageNum){
                    p=temp;
                    break;
                }
            }
            //p既L页
            if(p.isFlag()){
                int blockNum=p.getBlockNum();
                int address=blockNum*blockLength+c.getUnitNUm();

                if(c.getOperation().equals("S")){
                    p.setModifyFlag(true);
                }

                System.out.println("绝对地址:"+address);
                System.out.println();
            }else{
                //第1题
                System.out.println("*"+p.getPageNum()+"中断");
                //第二题


                if(pt[P[k]].isModifyFlag()){
                    System.out.println("OUT："+pt[P[k]].getPageNum());
                    pt[P[k]].setModifyFlag(false);
                }
                System.out.println("IN; "+p.getPageNum());

                pt[P[k]].setFlag(false);
                p.setBlockNum(pt[P[k]].getBlockNum());
                P[k]=p.getPageNum();
                k=(k+1)%m;
                p.setFlag(true);
                if(p.isFlag()){
                    int blockNum=p.getBlockNum();
                    int address=blockNum*blockLength+c.getUnitNUm();

                    if(c.getOperation().equals("S")){
                        p.setModifyFlag(true);
                    }

                    System.out.println("绝对地址:"+address);
                    System.out.println();
                }
            }

        }

        System.out.println(P[0]+" "+P[1]+" "+P[2]+" "+P[3]);
    }
}

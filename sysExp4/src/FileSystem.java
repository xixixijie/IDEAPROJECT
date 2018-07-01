import java.util.Scanner;

/**
 * Created by xixi on 29/06/2017.
 */
public class FileSystem {
    User u[]=new User[10];
    Dir MFD;
    Dir UFD;
    Dir AFD;
    public FileSystem(){
        u[0]=new User("chen");
        u[1]=new User("xi");
        u[2]=new User("hehe");
        u[3]=new User("jie");
        u[4]=new User("yu");
        u[5]=new User("fen");
        u[6]=new User("fang");
        u[7]=new User("wu");
        u[8]=new User("yi");
        u[9]=new User("bo");
        MFD=new Dir();
        for(User user:u){
            MFD.add(new Dir(user.getName()));
        }
    }
    public void run(){
        String command="";
        System.out.println("input the command:");
        Scanner scanner=new Scanner(System.in);
        command=scanner.nextLine();
        String fileName="";
        while(!command.equals("bye")) {
            switch (command) {
                case "login":
                    login();
                    break;
                case "create":
                    System.out.println("input the file name");
                    fileName=scanner.nextLine();
                    UFD.add(new File(fileName));
                    break;
                case "delete":
                    System.out.println("input the file name");
                    fileName=scanner.nextLine();
                    UFD.delete(fileName);
                    break;
                case "open":
                    System.out.println("input the file name");
                    fileName=scanner.nextLine();
                    File file= (File) UFD.get(fileName);
                    AFD.add(file);
                    file.open();
                    break;
                case "close":
                    System.out.println("input the file name");
                    fileName=scanner.nextLine();
                    AFD.delete(fileName);
                    break;
                case "read":
                    System.out.println("input the file name");
                    fileName=scanner.nextLine();
                    File file1= (File) UFD.get(fileName);
                    AFD.add(file1);
                    file1.open();
                    break;
                case "write":
                    System.out.println("input the file name");
                    fileName=scanner.nextLine();
                    File file2= (File) UFD.get(fileName);
                    String contain="";
                    AFD.add(file2);
                    System.out.println("input the contain");
                    contain=scanner.nextLine();
                    file2.setContain(contain);
                    break;
                case "dir":
                    System.out.println("文件名  保护码   物理地址  文件长度");
                    for(Ob ob:UFD.getList()){

                        if(ob instanceof File){
                            File file3= (File) ob;
                            System.out.println(ob.getName()+" "+((File) ob).getPtCode()+" "+((File) ob).getAddress()+" "+ ((File) ob).getContain().length());
                        }
                    }
                    break;
                case "bye":
                    break;
            }
            System.out.println("input the command:");
            command=scanner.nextLine();
        }
    }

    public void login(){
        String name;
        System.out.println("please input the userName");
        Scanner sc=new Scanner(System.in);
        name=sc.nextLine();
        for(Ob ob:MFD.getList()){
            if(ob.getName().equals(name)){
                System.out.println("hello "+name);
                UFD= (Dir) ob;
                AFD=new Dir();
            }
        }
    }

    public static void main(String[] args) {

        new FileSystem().run();


    }
}

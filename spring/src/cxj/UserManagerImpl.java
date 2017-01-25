package cxj;

/**
 * Created by xixi on 20/01/2017.
 */
public class UserManagerImpl implements UserManager{
    @Override
    public void addUser(String userName, String password) {
        System.out.println("----UserManagerImpl.add()----");
    }

    @Override
    public void delUser(int userId) {
        System.out.println("----UserManagerImpl.delUser()----");
    }

    @Override
    public String findUserById(int userId) {

        System.out.println("----UserManagerImpl.findUserById()----");

        if(userId <= 0){
            throw new IllegalArgumentException("该用户不存在");
        }
        return "jiuqiyuliang";
    }

    @Override
    public void modifyUser(int userId, String userName, String password) {
        System.out.println("----UserManagerImpl.modifyUser()----");
    }
}

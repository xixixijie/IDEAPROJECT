package bean;

/**
 * Created by xixi on 2018/7/5.
 */
public class OtherSpeaker implements Speaker {

    @Override
    public void speak() {
        System.out.println("other");
    }
}

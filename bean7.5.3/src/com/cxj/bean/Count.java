package com.cxj.bean;

/**
 * Created by jay chen on 2016/8/20.
 */
public class Count {
    private long count=0;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void Add(){
        this.count++;
    }
}

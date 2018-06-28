package jdk.test.ref;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 很大的一个对象，需要很大的内存存储
 */
public class VeryLarge implements Serializable {

    private List<Integer> intList;

    private String vlNo;

    public VeryLarge(String vlNo, List<Integer> intList) {
        this.vlNo = vlNo;
        this.intList = intList;
    }

    public VeryLarge(String vlNo, int[] ints) {
        this.vlNo = vlNo;
        this.intList = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            intList.add(ints[i]);
        }
    }

//    protected void finalize() {
//        System.out.println("finalizing " + vlNo);
//    }

    public String getVlNo() {
        return vlNo;
    }

    public void setVlNo(String vlNo) {
        this.vlNo = vlNo;
    }

    public List<Integer> getIntList() {
        return intList;
    }

    public void setIntList(List<Integer> intList) {
        this.intList = intList;
    }
}

package ua.rabota.pageObjects;

import ua.rabota.testCases.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class LazyExample extends BaseTest {


    private List<String> list;


    // lazy
    public List<String> getListLazy() {
        if (list == null) {
            list = new ArrayList<String>();
                    }
        return list;
    }

    // non lazy
    public List<String> getListNonLazy() {
        return list;
    }

    public static void main(String[] args) {
        LazyExample le = new LazyExample();

        le.getListLazy().add("abcdef");
        le.getListNonLazy().add("aaaa");
    }
}

package pro.sky;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("e1");
        stringList.add("e2");
        stringList.add("e3");
        stringList.add("e4");
        stringList.add(1, "e6");
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.clear();
        System.out.println(stringList.size());


    }
}

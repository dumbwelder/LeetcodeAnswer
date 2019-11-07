package ByteDance.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
//        for (String item : list) {
//            if ("1".equals(item)) {
//                list.remove(item);
//            }
//        }
        Iterator<String> ite  = list.iterator();
        while (ite.hasNext()){
            String item = ite.next();
            if ("1".equals(item)) {
                list.remove(item);
            }
        }

    }
    public void print(ArrayList<? extends List> list){
        for (List l : list){
            System.out.println(l);
        }

    }

}


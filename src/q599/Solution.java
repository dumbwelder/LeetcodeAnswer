package q599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(findRestaurant(list1, list2));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> strs = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        int minIndex = list1.length + list2.length;
        for (int i = 0; i < list1.length; i++) {
            m.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (m.containsKey(list2[i])) {
                int index = i + m.get(list2[i]);
                if (index < minIndex) {
                    minIndex = index;
                    strs.clear();
                    strs.add(list2[i]);
                }else if(index ==minIndex){
                    strs.add(list2[i]);
                }
            }
        }
        return strs.toArray(new String[strs.size()]);
    }
}

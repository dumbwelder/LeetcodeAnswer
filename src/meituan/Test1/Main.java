package meituan.Test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer, String> numToStringMap = new HashMap<>();
    static boolean isZero = false;
    static boolean haveAppend = false;

    public static void main(String[] args) {
        numToStringMap.put(1, "壹");
        numToStringMap.put(2, "贰");
        numToStringMap.put(3, "叁");
        numToStringMap.put(4, "肆");
        numToStringMap.put(5, "伍");
        numToStringMap.put(6, "陆");
        numToStringMap.put(7, "柒");
        numToStringMap.put(8, "捌");
        numToStringMap.put(9, "玖");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1, str.length() - 1);
        String[] resource = str.split(",");
        for (String s : resource) {
            s = s.substring(1, s.length() - 1);
            isZero = false;
            haveAppend = false;
            coverToChinese(s);
        }
    }

    private static void coverToChinese(String s) {
        StringBuilder sb = new StringBuilder();
        int indexOfPoint = s.indexOf('.');
        Long num1 = 0L;
        int num2 = 0;
        if (indexOfPoint != -1) {
            num1 = Long.parseLong(s.substring(0, indexOfPoint));
            num2 = Integer.parseInt(s.substring(indexOfPoint + 1, s.length()));
        } else {
            num1 = Long.parseLong(s);
        }
        int[] nums = new int[4];
        nums[0] = (int) (num1 / 1000000000000L);
        nums[1] = (int) (num1 / 100000000L);
        nums[2] = (int) ((num1 - nums[1] * 100000000L) / 10000L);
        nums[3] = (int) (num1 % 10000L);
        if (nums[0] != 0) {
            sb.append("壹万亿元整");

        }
        if (nums[1] != 0) {
            sb.append(coverToChineseYuan(nums[1]));
            sb.append("亿");

        }
        if (nums[2] != 0) {
            sb.append(coverToChineseYuan(nums[2]));
            sb.append("万");

        }
        if (nums[3] != 0) {
            sb.append(coverToChineseYuan(nums[3]));
            sb.append("元");

        }
        if (num2 == 0) {
            sb.append("整");
        } else {
            sb.append(coverToChineseCent(num2));
        }
        System.out.println(sb.toString());
    }

    private static String coverToChineseCent(Integer num2) {
        StringBuilder sb = new StringBuilder();
        int value = 0;
        if (num2 / 10 != 0) {
            value = num2 / 10;
            sb.append(numToStringMap.get(value));
            sb.append("角");
        } else {
            sb.append("零");
        }
        if (num2 % 10 != 0) {
            value = num2 % 10;
            sb.append(numToStringMap.get(value));
            sb.append("分");
        }
        return sb.toString();
    }

    private static String coverToChineseYuan(int num) {
        StringBuilder sb = new StringBuilder();
        int value = 0;
        if (num / 1000 != 0) {
            value = num / 1000;
            num -= value * 1000;
            if (isZero && haveAppend) {
                sb.append("零");
            }
            sb.append(numToStringMap.get(value));
            sb.append("仟");
            isZero = false;
            haveAppend = true;
        } else {
            isZero = true;
        }
        if (num / 100 != 0) {
            value = num / 100;
            num -= value * 100;
            if (isZero && haveAppend) {
                sb.append("零");
            }
            sb.append(numToStringMap.get(value));
            sb.append("佰");
            isZero = false;
            haveAppend = true;
        } else {
            isZero = true;
        }
        if (num / 10 != 0) {
            value = num / 10;
            num -= value * 10;
            if (isZero && haveAppend) {
                sb.append("零");
            }
            sb.append(numToStringMap.get(value));
            sb.append("拾");
            isZero = false;
            haveAppend = true;
        } else {
            isZero = true;
        }
        if (num != 0) {
            if (isZero && haveAppend) {
                sb.append("零");
            }
            sb.append(numToStringMap.get(num));
            haveAppend = true;
        } else {
            isZero = true;
        }
        return sb.toString();
    }

}

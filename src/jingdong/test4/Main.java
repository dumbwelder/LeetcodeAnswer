package jingdong.test4;
import java.util.*;
import java.util.List;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
        boolean flag = false;
        int distance = 0;
        for (int i = 0,j= xList.size()-1; i <xList.size() ; i++,j=i) {
            if (xList.get(i)==x&&yList.get(i)==y){
                flag = true;
                break;
            }

            if((y>=yList.get(i)&&y<yList.get(j))||(y<yList.get(i)&&y>=yList.get(j))){
                double yLine = yList.get(i)+(yList.get(j)-yList.get(i))/(xList.get(j)-xList.get(i))*(x-xList.get(i));
                if (y==yLine){
                    flag = true;
                    break;
                }
                if(y<yLine){
                    flag = !flag;
                }

            }

        }
        if (flag){
            return new String("yes,0");
        }else{
            return new String("no"+distance);
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}
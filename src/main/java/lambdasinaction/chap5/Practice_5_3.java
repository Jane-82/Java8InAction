package lambdasinaction.chap5;
import lambdasinaction.chap4.*;

import java.util.*;

import static lambdasinaction.chap4.Dish.menu;

public class Practice_5_3 {

    public static void main(String ... args) {
        // 用map和reduce方法统计一共有多少个菜
        Integer count = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println(count);

        // 内置count方法
        long count2 = menu.stream().count();
        System.out.println(count2);
    }

}
